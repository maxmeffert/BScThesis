package org.softlang.megal.plugins.impl.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.antlr.ANTLRFragmentizerPlugin;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;
import org.softlang.megal.plugins.api.antlr.ANTLRUtils;
import org.softlang.megal.plugins.api.fragmentation.Fragments;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;
import org.softlang.megal.plugins.impl.java.antlr.JavaLexer;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.FieldDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.InterfaceDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.MemberDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.MethodDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.ModifierContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.PackageDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.TypeDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.VariableDeclaratorContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.VariableDeclaratorsContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.AnnotationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.ClassBodyDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.ClassDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.CompilationUnitContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.ConstructorDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser.EnumDeclarationContext;
import org.softlang.megal.plugins.impl.java.antlr.JavaParserFactory;


/**
 * Disassembles a Java artifact into its fragments.
 * 
 * @author maxmeffert
 *
 */
public class JavaFragmentizer extends ANTLRFragmentizerPlugin<JavaParser, JavaLexer> {
	
	/* =====================================================================================================
	 * Fragment type names
	 * =====================================================================================================
	 */
	
	static final private String FRAGMENTTYPE_PACKAGE = "JavaPackage";
	static final private String FRAGMENTTYPE_CLASS = "JavaClass";
	static final private String FRAGMENTTYPE_INTERFACE = "JavaInterface";
	static final private String FRAGMENTTYPE_ENUM = "JavaEnum";
	static final private String FRAGMENTTYPE_FIELD = "JavaField";
	static final private String FRAGMENTTYPE_METHOD = "JavaMethod";
	static final private String FRAGMENTTYPE_CONSTRUCTOR = "JavaConstructor";
	static final private String FRAGMENTTYPE_ANNOTATION = "JavaAnnotation";
	
	/* =====================================================================================================
	 * Fragmentation Rules
	 * =====================================================================================================
	 * 
	 * Rule classes depend on the grammar specified in org.softlang.megal.plugins.impl.java.antlr.Java.g4
	 * 
	 */
	
	/**
	 * Fragmentation rule for packages.
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class PackageRule extends FragmentationRule<CompilationUnitContext> {

		/**
		 * Gets the targeted AST declaration context.
		 * 
		 * <p>
		 * This rule makes use of the CompilationUnitContext because the actual PackageDeclarationContext 
		 * does not have any children, which is counter-intuitive for fragments
		 * </p>
		 * 
		 */
		@Override
		protected Class<CompilationUnitContext> contextType() {
			return CompilationUnitContext.class;
		}

		@Override
		protected boolean isAtom(CompilationUnitContext context) {
			return false;
		}

		@Override
		protected boolean test(CompilationUnitContext context) {
			return context.packageDeclaration() instanceof PackageDeclarationContext;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, CompilationUnitContext context) {
			
			return Collections.singletonList(Fragments.create(
					context.packageDeclaration().qualifiedName().getText().replace('.', '_'), 
					FRAGMENTTYPE_PACKAGE, 
					ANTLRUtils.originalText(context), 
					entity, 
					artifact
					));
			
		}
		
	}
	
	/**
	 * Fragmentation rule for classes
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class ClassRule extends FragmentationRule<TypeDeclarationContext> {

		@Override
		protected Class<TypeDeclarationContext> contextType() {
			return TypeDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(TypeDeclarationContext context) {
			return false;
		}

		@Override
		protected boolean test(TypeDeclarationContext context) {
			return context.classDeclaration() instanceof ClassDeclarationContext;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, TypeDeclarationContext context) {
			// Create a new JavaClass fragment
			return Collections.singletonList(Fragments.create(
					context.classDeclaration().Identifier().getText(),
					FRAGMENTTYPE_CLASS, 
					ANTLRUtils.originalText(context),
					entity, 
					artifact
					));
		}
		
	};
	
	/**
	 * Fragmentation rule for inner classes
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class InnerClassRule extends FragmentationRule<ClassBodyDeclarationContext> {

		@Override
		protected Class<ClassBodyDeclarationContext> contextType() {
			return ClassBodyDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(ClassBodyDeclarationContext context) {
			return false;
		}

		@Override
		protected boolean test(ClassBodyDeclarationContext context) {
			return context.memberDeclaration() instanceof MemberDeclarationContext
					&& context.memberDeclaration().classDeclaration() instanceof ClassDeclarationContext;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, ClassBodyDeclarationContext context) {
			return Collections.singletonList(Fragments.create(
					context.memberDeclaration().classDeclaration().Identifier().getText(),
					FRAGMENTTYPE_CLASS, 
					ANTLRUtils.originalText(context),
					entity, 
					artifact
					));
		}
		
	};
	
	/**
	 * Fragmentation rule for interfaces
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class InterfaceRule extends FragmentationRule<TypeDeclarationContext> {

		@Override
		protected Class<TypeDeclarationContext> contextType() {
			return TypeDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(TypeDeclarationContext context) {
			return false;
		}

		@Override
		protected boolean test(TypeDeclarationContext context) {
			return context.interfaceDeclaration() instanceof InterfaceDeclarationContext;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, TypeDeclarationContext context) {
			// Create a new JavaClass fragment
			return Collections.singletonList(Fragments.create(
					context.interfaceDeclaration().Identifier().getText(),
					FRAGMENTTYPE_INTERFACE, 
					ANTLRUtils.originalText(context),
					entity, 
					artifact
					));
		}
		
	};
	
	/**
	 * Fragmentation rule for member interfaces
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class InnerInterfaceRule extends FragmentationRule<ClassBodyDeclarationContext> {

		@Override
		protected Class<ClassBodyDeclarationContext> contextType() {
			return ClassBodyDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(ClassBodyDeclarationContext context) {
			return false;
		}

		@Override
		protected boolean test(ClassBodyDeclarationContext context) {
			return context.memberDeclaration() instanceof MemberDeclarationContext
					&& context.memberDeclaration().interfaceDeclaration() instanceof InterfaceDeclarationContext;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, ClassBodyDeclarationContext context) {
			return Collections.singletonList(Fragments.create(
					context.memberDeclaration().interfaceDeclaration().Identifier().getText(),
					FRAGMENTTYPE_INTERFACE, 
					ANTLRUtils.originalText(context),
					entity, 
					artifact
					));
		}
		
	};
	
	/**
	 * Fragmentation rule for enums
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class EnumRule extends FragmentationRule<EnumDeclarationContext> {

		@Override
		protected Class<EnumDeclarationContext> contextType() {
			return EnumDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(EnumDeclarationContext context) {
			return false;
		}

		@Override
		protected boolean test(EnumDeclarationContext context) {
			return true;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, EnumDeclarationContext context) {
			return Collections.singletonList(Fragments.create(
					context.Identifier().getText(), 
					FRAGMENTTYPE_ENUM, 
					ANTLRUtils.originalText(context), 
					entity, 
					artifact
					));
		}
		
	}
	
	/**
	 * Fragmentation rule for fields
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class FieldRule extends FragmentationRule<VariableDeclaratorsContext> {
		

		@Override
		protected Class<VariableDeclaratorsContext> contextType() {
			return VariableDeclaratorsContext.class;
		}

		@Override
		protected boolean isAtom(VariableDeclaratorsContext context) {
			return true; // due to possible annotations
		}

		@Override
		protected boolean test(VariableDeclaratorsContext context) {
			
			return context.getParent() instanceof FieldDeclarationContext;
//			return context.getParent().getParent() instanceof FieldDeclarationContext;
		}

		private String getFieldNameOf(VariableDeclaratorContext context) {
			
			String name = context.variableDeclaratorId().getText();
			
			if (context.getParent().getParent() instanceof FieldDeclarationContext) {
				
				FieldDeclarationContext field = (FieldDeclarationContext) context.getParent().getParent();
				
				name += "_" + field.type().getText().replace("<", "[").replace(">", "]");
				
			}
			
			return name;
			
		}
		
		
		
		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, VariableDeclaratorsContext context) {
			
//			ClassBodyDeclarationContext ctx = (ClassBodyDeclarationContext) context;
			List<VariableDeclaratorContext> variableDeclarators = context.variableDeclarator();
			
			Collection<Fragment> result = new LinkedList<Fragment>();
			
			boolean isAnnotated = false;
			Collection<AnnotationContext> annotationContexts = new LinkedList<AnnotationContext>();
			ParserRuleContext ctx = context;
			
			while (ctx != null) {
				
				if (ctx instanceof ClassBodyDeclarationContext) {
					
					for(ModifierContext modifierContext : ((ClassBodyDeclarationContext) ctx).modifier()) {
						if (modifierContext.classOrInterfaceModifier().annotation() != null) {
							annotationContexts.add(modifierContext.classOrInterfaceModifier().annotation());
						}
					}
					
				}
				
				ctx = ctx.getParent();
				
			}
			
			/*
			 * Problem: Single Annotation on a VariableDeclaratorsContext, e.g.:
			 * 
			 *    ...
			 *    
			 *    @SomeAnnotation
			 *    private int foo, bar;
			 *    
			 *    ...
			 * 
			 */
			
			for(VariableDeclaratorContext vdCtx : variableDeclarators) {
				
				Fragment f = Fragments.create(
					getFieldNameOf(vdCtx),
					FRAGMENTTYPE_FIELD, 
					ANTLRUtils.originalText(context.getParent().getParent()),
					entity, 
					artifact
					);
				
				for (AnnotationContext annotationContext : annotationContexts) {
//					System.out.println(annotationContext);
					f.addPart(Fragments.create(
							annotationContext.getText(),
							FRAGMENTTYPE_ANNOTATION,
							ANTLRUtils.originalText(annotationContext), 
							entity,
							artifact
							));
					
				}
				
				result.add(f);
				
			}
			
			
			return result;
			
//			String name = context.variableDeclaratorId().getText();
//			
//			if (context.getParent().getParent() instanceof FieldDeclarationContext) {
//				
//				FieldDeclarationContext field = (FieldDeclarationContext) context.getParent().getParent();
//				
//				name += "_" + field.type().getText().replace("<", "[").replace(">", "]");
//				
//			}
//			
//			return Collections.singletonList(Fragments.create(
//					name,
//					FRAGMENTTYPE_FIELD, 
//					ANTLRUtils.originalText(context.getParent().getParent()),
//					entity, 
//					artifact
//					));
		}
		
	};
	
	/**
	 * Fragmentation rule for methods
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class MethodRule extends FragmentationRule<MethodDeclarationContext> {
		

		@Override
		protected Class<MethodDeclarationContext> contextType() {
			return MethodDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(MethodDeclarationContext context) {
			return false; // due to possible annotations
		}

		@Override
		protected boolean test(MethodDeclarationContext context) {
			return true;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, MethodDeclarationContext context) {
			
			String name = context.Identifier().getText();
			
			if (context.formalParameters().formalParameterList() != null) {
				
				List<String> types = context.formalParameters().formalParameterList().formalParameter().stream()
						.map( p -> p.type().getText().replace("<", "[").replace(">", "]") )
						.collect(Collectors.toList());
				
				name += "(" + String.join(",", types) + ")";
				
				
			}
			
			if (context.type() != null) {
				
				name += "_" + context.type().getText().replace("<", "[").replace(">", "]");
				
			}
			
			return Collections.singletonList(Fragments.create(
					name,
					FRAGMENTTYPE_METHOD, 
					ANTLRUtils.originalText(context),
					entity, 
					artifact
					));
			
		}

		
		
	};
	
	/**
	 * 
	 * Fragmentation rule for constructors
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class ConstructorRule extends FragmentationRule<ConstructorDeclarationContext> {

		@Override
		protected Class<ConstructorDeclarationContext> contextType() {
			return ConstructorDeclarationContext.class;
		}

		@Override
		protected boolean isAtom(ConstructorDeclarationContext context) {
			return true;
		}

		@Override
		protected boolean test(ConstructorDeclarationContext context) {
			return false; // due to possible annotations
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, ConstructorDeclarationContext context) {
			
			String name = context.Identifier().getText();
			
			if (context.formalParameters().formalParameterList() != null) {
				
				List<String> types = context.formalParameters().formalParameterList().formalParameter().stream()
						.map( p -> p.type().getText() )
						.collect(Collectors.toList());
				
				name += "(" + String.join(",", types) + ")";
				name = name.replace("<", "[");
				name = name.replace(">", "]");
				
				
			}
			
//			System.err.println(name);
			
			return Collections.singletonList(Fragments.create(
					name,
					FRAGMENTTYPE_CONSTRUCTOR, 
					ANTLRUtils.originalText(context),
					entity, 
					artifact
					));
		}
		
	}
	
	/**
	 * 
	 * Fragmentation rule for annotations
	 * 
	 * @author maxmeffert
	 *
	 */
	static private class AnnotationRule extends FragmentationRule<AnnotationContext> {
		

		@Override
		protected Class<AnnotationContext> contextType() {
			return AnnotationContext.class;
		}

		@Override
		protected boolean isAtom(AnnotationContext context) {
			return true;
		}

		@Override
		protected boolean test(AnnotationContext context) {
			return true;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, AnnotationContext context) {
			
			String name = context.annotationName().qualifiedName().getText();
			
			return Collections.singletonList(Fragments.create(
					name,
					FRAGMENTTYPE_ANNOTATION, 
					ANTLRUtils.originalText(context.getParent().getParent()),
					entity, 
					artifact
					));
		}
		
	};
	
	/* =====================================================================================================
	 * Implemented ANTLRFRagmentizer methods
	 * =====================================================================================================
	 */
	
	/**
	 * Gets the collection of Java fragmentation rules
	 */
	@Override
	public Collection<FragmentationRule<? extends ParserRuleContext>> getRules() {
		
		Collection<FragmentationRule<? extends ParserRuleContext>> rules = new ArrayList<FragmentationRule<? extends ParserRuleContext>>();
		
		rules.add(new PackageRule());
		rules.add(new InnerClassRule());
		rules.add(new ClassRule());
		rules.add(new InterfaceRule());
		rules.add(new InnerInterfaceRule());
		rules.add(new EnumRule());
		rules.add(new FieldRule());
		rules.add(new MethodRule());
		rules.add(new ConstructorRule());
		
		return rules;
		
	}
	
	/**
	 * 
	 */
	@Override
	public ANTLRParserFactory<JavaParser, JavaLexer> getParserFactory() {
		return new JavaParserFactory();
	}

}
