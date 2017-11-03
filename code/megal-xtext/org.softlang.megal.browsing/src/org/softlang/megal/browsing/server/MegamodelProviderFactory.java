package org.softlang.megal.browsing.server;

import org.glassfish.hk2.api.Factory;

public class MegamodelProviderFactory implements Factory<MegamodelProvider> {

	private MegamodelProvider megamodelProvider;
	
	public MegamodelProviderFactory(MegamodelProvider megamodelProvider) {
		this.megamodelProvider = megamodelProvider;
	}
	
	@Override
	public void dispose(MegamodelProvider arg0) {
	}

	@Override
	public MegamodelProvider provide() {
		return megamodelProvider;
	}
	
}
