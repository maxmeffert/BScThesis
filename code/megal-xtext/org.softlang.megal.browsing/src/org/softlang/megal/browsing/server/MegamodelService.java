package org.softlang.megal.browsing.server;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.softlang.megal.browsing.dtos.MegamodelDto;

@Path("megamodel")
public class MegamodelService {

   @Inject MegamodelProvider megamodelProvider;
	
   @GET
   @Path("/")
   @Produces(MediaType.APPLICATION_JSON)
   public MegamodelDto available() {
      return megamodelProvider.getMegamodel(); //"yes" + (megamodelProvider.getMegamodel() == null);
   }

}
