package org.softlang.megal.browsing.server;

import org.softlang.megal.browsing.dtos.MegamodelDto;
import org.softlang.megal.mi2.KB;

public class MegamodelProvider {

	private MegamodelDto megamodel = new MegamodelDto();

	protected MegamodelDto getMegamodel() {
		return megamodel;
	}

	protected void setMegamodel(KB megamodel) {
		this.megamodel = MegamodelDto.from(megamodel);
	}
	
}
