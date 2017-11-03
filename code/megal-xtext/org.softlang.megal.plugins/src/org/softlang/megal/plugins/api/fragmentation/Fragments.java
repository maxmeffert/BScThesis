package org.softlang.megal.plugins.api.fragmentation;

import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;

import com.google.common.collect.TreeTraverser;

import java.util.Optional;
import java.util.Set;

/**
 * 
 * Utility class for fragments.
 * This class also acts as a fragment KB.
 * 
 * @author maxmeffert
 *
 */
public abstract class Fragments {
		
	/**
	 * 
	 * @author maxmeffert
	 *
	 */
	static final public class Fragment {
		
		private String name;
		
		/**
		 * The entity type name of the fragment
		 */
		private String type;
		
		private String text;
				
		/**
		 * The containing entity of the fragment
		 */
		private Entity entity;
		
		/**
		 * The containing artifact of the fragment
		 */
		private Artifact artifact;
		
		/**
		 * The parent of the fragment
		 */
		private Fragment parent;
		
		/**
		 * The Collection of fragment parts
		 */
		private List<Fragment> parts = new ArrayList<Fragment>();
		
		/**
		 * Constructs a new fragment
		 * 
		 * @param type
		 * @param entity
		 * @param artifact
		 * @param facts
		 */
		private Fragment (String name, String type, String text, Entity entity, Artifact artifact) {
			this.name = name;
			this.type = type;
			this.text = text;
			this.entity = entity;
			this.artifact = artifact;
		}
		
		/**
		 * Gets the name of the fragment
		 * @return
		 */
		public String getName () {
			return name;
		}
		
		/**
		 * Gets the type of the fragment
		 * @return
		 */
		public String getType () {
			return type;
		}


		/**
		 * Gets the text of the fragment
		 * @return
		 */
		public String getText () {
			return text;
		}
		
		/**
		 * Gets the containing entity of the fragment
		 * @return
		 */
		public Entity getEntity () {
			return entity;
		}
		
		/**
		 * Gets the containing artifact of the fragment
		 * @return
		 */
		public Artifact getArtifact() {
			return artifact;
		}
				
		/**
		 * Whether the fragment has a parent or is a child
		 * @return
		 */
		public boolean hasParent () {
			return parent != null;
		}
		
		/**
		 * Gets the parent of the fragment
		 * @return
		 */
		public Fragment getParent() {
			return parent;
		}
		
		
		
		public void setParent(Fragment parent) {
			this.parent = parent;
		}

		/**
		 * Gets the index of the fragment
		 * @return
		 */
		public int getIndex () {
			
			// If the fragment has a parent
			if (hasParent()) {
				
				// Get the index of the fragment from its parent parts
				return getParent().parts.indexOf(this);
				
			}
			
			// Return 0 by default
			return 0;
			
		}
		
		/**
		 * Gets the qualified name of the fragment
		 * @return
		 */
		public String getQualifiedName () {
			
			// The qualified name of the fragment
			String name = getName() + "" + getIndex();
			
			// If the fragment has parent
			if (hasParent()) {
				
				// Return the qualified name of the fragment appended to its parent's qualified name
				return getParent().getQualifiedName() + "." + name;
				
			}
 			
			// Return the qualified name of the fragment appended to its containing entity's name
			return getEntity().getName() + "." + name;
			
		}
		
		/**
		 * Get the collection of parts of the fragment
		 * @return
		 */
		public Collection<Fragment> getParts() {
			return parts;
		}
		
		/**
		 * Add a new part to the fragment
		 * @param part
		 */
		public void addPart (Fragment child) {
			
			// Prevent cycles
			if (child != this) {
			
				// Associate the child with its new parent 
				child.parent = this;
				
				// Add the child to the collection of parts
				parts.add(child);
			
			}
			
		}
		
		public void addParts(Collection<Fragment> children) {
			for(Fragment child : children) {
				addPart(child);
			}
		}
		
		/**
		 * Gets the URI of the fragment
		 * @return
		 */
		public URI getURI () {
			
			try {
			
				// The 'path' of the fragment
				String path = "/" + getIndex() + "/" + getName() + "/" + getType();
				
				// If the fragment has a parent
				if (hasParent()) {
				
					// Return the path of the fragment appended to its parent's URI
					return new URI(getParent().getURI() + path);
					
				}
			
				// Return the path of the fragment as fragment segment of its artifact's location
				return new URI(getArtifact().getLocation() + "#" + path);
			
			} catch (URISyntaxException e) {
			
				System.err.println("Fragments says:" + e);
				throw new IllegalStateException();
				
			}
			
		}
		
		public boolean isRoot () {
			return !hasParent();
		}
		
		public boolean isAtom () {
			return getParts().isEmpty();
		}
		
		public boolean isCompound () {
			return !isAtom();
		}
		
		public int depth () {
			
			if (hasParent()) {
				return getParent().depth() + 1;
			}
			
			return 0;
			
		}
		
		/**
		 * Gets the string representation of the artifact.
		 * Returns the URI of the fragment as string.
		 */
		public String toString () {
			return getURI().toString();
		}
		
	}
	
	/**
	 * The fragment KB 
	 */
	static private Set<Fragment> fragments = new HashSet<Fragment>();
	
	static private class FragmentTraverser extends TreeTraverser<Fragment> {

		@Override
		public Iterable<Fragment> children(Fragment f) {
			return f.getParts();
		}
		
	}
	
	static public interface FragmentVisitor<T> {
		
		public T visit (Fragment f);
		
	}
	
	/**
	 * Factory method for fragments.
	 * Creates a new fragment. 
	 * 
	 * @param type
	 * @param entity
	 * @param artifact
	 * @param facts
	 * @return
	 */
	static public Fragment create (String name, String type, String text, Entity entity, Artifact artifact) {
		
		// Create a new fragment
		Fragment f = new Fragment(name, type, text, entity, artifact);
		
		// Add fragment to the fragment KB
		fragments.add(f);
		
		return f;
		
	}
	
	
	
	static public void print (Fragment f, PrintStream p) {
		
		FragmentTraverser t = new FragmentTraverser();
		
		for (Fragment ff : t.preOrderTraversal(f)) {
			
			for (int i=0; i < ff.depth()-f.depth(); i++)
				p.print("  ");
			p.println(ff);
			
		}
		
	}
	
	/**
	 * Checks whether a fragment with a given URI was created.
	 * @param uri
	 * @return
	 */
	static public boolean exists (URI uri) {
		return fragments.stream()
				.anyMatch( f -> f.getURI().equals(uri) );
	}
	
	/**
	 * Checks whether a fragment for a given artifact was created.
	 * @param artifact
	 * @return
	 */
	static public boolean hasFragment (Artifact artifact) {
		return fragments.stream()
				.anyMatch( f -> f.getArtifact().equals(artifact) );
	}
	
	/**
	 * Checks whether a fragment for a given entity was created.
	 * @param entity
	 * @return
	 */
	static public boolean hasFragment (Entity entity) {
		return entity.hasBinding() 
				&& exists((URI)entity.getBinding());
	}
	
	/**
	 * Gets the first fragment for a given URI.
	 * @param uri
	 * @return
	 */
	static public Optional<Fragment> fragmentOf (URI uri) {
		return fragments.stream()
				.filter( f -> f.getURI().equals(uri) )
				.findFirst();
	}
		
	/**
	 * Gets the first fragment bound a given entity.
	 * @param entity
	 * @return
	 */
	static public Optional<Fragment> fragmentOf (Entity entity) {
		
		// If the entity is bound to an URI instance
		if (entity.getBinding() instanceof URI) {
			
			// Return the first fragment for the URI
			return fragmentOf((URI)entity.getBinding());
			
		}
		
		// Return the first fragment where the string representation of the URI equals the binding
		return fragments.stream()
				.filter( f -> f.getURI().toString().equals(entity.getBinding()))
				.findFirst();
		
	}
	
	static public Optional<Fragment> fragmentFor (URI uri) {
		return Optional.empty();
	}
	
	/**
	 * Gets all fragments for a given artifact.
	 * @param artifact
	 * @return
	 */
	static public List<Fragment> fragmentsOf (Artifact artifact) {
		return fragments.stream()
				.filter( f -> f.getArtifact().equals(artifact) )
				.collect(Collectors.toList());
	}
	
	/**
	 * Gets all fragments contained of a given entity.
	 * @param entity
	 * @return
	 */
	static public List<Fragment> fragmentsOf (Entity entity) {
		return fragments.stream()
				.filter( f -> f.getEntity().equals(entity) )
				.collect(Collectors.toList());
	}
	
	
}
