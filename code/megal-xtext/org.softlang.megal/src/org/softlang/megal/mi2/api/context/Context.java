package org.softlang.megal.mi2.api.context;

import org.softlang.megal.mi2.api.emission.Emission;
import org.softlang.megal.mi2.api.resolution.Resolution;

/**
 * <p>
 * Context for plugin execution, sustains resolver input, binding resolution and
 * message emission.
 * </p>
 * 
 * @author Pazuzu
 *
 */
public interface Context extends Resolution, Emission {
}
