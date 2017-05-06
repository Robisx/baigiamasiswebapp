/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.rs;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vartotojas;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vieta;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.VartotojasManager;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.VietaManager;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.utils.Utils;

/**
 * REST Web Service
 *
 * @author User1
 */
@Path("vieta")
public class VietaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VietaResource
     */
    public VietaResource() {
    }

    /**
     * Retrieves representation of an instance of lt.svako.stud.robertasjarockis.baigiamasiswebapp.rs.VietaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vieta> getJson() {
        VietaManager vieman = new VietaManager();
        return vieman.getAllVieta();
    }

    /**
     * PUT method for updating or creating an instance of VietaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(String content){
        System.out.println(content);
        VietaManager vm = new VietaManager();
        vm.addVieta(Utils.parseVieta(content));
        return Response.status(201).build();
    }
}
