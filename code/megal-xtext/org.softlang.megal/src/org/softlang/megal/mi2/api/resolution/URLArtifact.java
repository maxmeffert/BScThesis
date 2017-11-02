package org.softlang.megal.mi2.api.resolution;

import static com.google.common.base.Objects.equal;
import static java.util.Collections.emptyList;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.softlang.megal.mi2.api.Artifact;

import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;

public class URLArtifact extends Artifact {
	/**
	 * <p>
	 * Number of cached URLs.
	 * </p>
	 */
	private static final int EXISTING_CACHE_SIZE = 64;

	/**
	 * <p>
	 * Caches the existence of an URL.
	 * </p>
	 */
	private static final Map<URL, Boolean> EXISTING = new LinkedHashMap<URL, Boolean>() {
		private static final long serialVersionUID = 7192855081861250904L;

		@Override
		protected boolean removeEldestEntry(Entry<URL, Boolean> eldest) {
			return size() > EXISTING_CACHE_SIZE;
		}
	};

	private final URL url;

	public URLArtifact(URL url) {
		this.url = url;
	}

	public URL getURL() {
		return url;
	}

	@Override
	public boolean exists() {
		// Check in cache, web resources should at least be available through this evaluation session
		Boolean resultValue = EXISTING.get(getURL());
		if (resultValue != null)
			return resultValue;

		try {
			// Open the URL
			URLConnection urlConnection = getURL().openConnection();

			// For URLs, request the head
			if (urlConnection instanceof HttpURLConnection)
				try {
					HttpURLConnection http = (HttpURLConnection) urlConnection;
					http.setRequestMethod("HEAD");
					http.setInstanceFollowRedirects(true);

					http.connect();

					switch (http.getResponseCode()) {
					// Those indicate we can at least do something with the URL
					case HttpURLConnection.HTTP_OK:
					case HttpURLConnection.HTTP_MOVED_TEMP:
					case HttpURLConnection.HTTP_MOVED_PERM:
					case HttpURLConnection.HTTP_SEE_OTHER:
						EXISTING.put(getURL(), true);
						return true;

						// Otherwise we have been killed of by the URL
					default:
						EXISTING.put(getURL(), false);
						return false;
					}
				} catch (IOException e) {
					EXISTING.put(getURL(), false);
					return false;
				}

			// Default do by get stream
			try {
				urlConnection.connect();
				urlConnection.getInputStream().close();

				EXISTING.put(getURL(), true);
				return true;
			} catch (IOException e) {
				EXISTING.put(getURL(), false);
				return false;
			}
		} catch (IOException e) {
			EXISTING.put(getURL(), false);
			return false;
		}
	}

	@Override
	public URI getLocation() {
		try {
			return getURL().toURI();
		} catch (URISyntaxException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public String getName() {
		return getURL().getFile();
	}

	@Override
	public Artifact getParent() {
		return null;
	}

	@Override
	public List<? extends Artifact> getChildren() {
		return emptyList();
	}

	@Override
	public boolean hasContent() {
		return true;
	}

	@Override
	public ByteSource getBytes() {
		return Resources.asByteSource(getURL());
	}

	@Override
	public CharSource getChars() {
		return Resources.asCharSource(getURL(), Charset.defaultCharset());
	}

	@Override
	public int hashCode() {
		return getURL().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof URLArtifact) {
			URLArtifact other = (URLArtifact) obj;

			return equal(getURL(), other.getURL());
		}

		if (obj instanceof Artifact) {
			Artifact other = (Artifact) obj;

			return equal(getLocation(), other.getLocation());
		}

		return false;
	}

}
