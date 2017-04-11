/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.rs;

import javax.servlet.http.HttpServletRequest;
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
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.VartotojasManager;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.utils.Utils;

/**
 * REST Web Service
 *
 * @author User1
 */
@Path("vartotojas")
public class VartotojasResource {

    @Context
    private UriInfo context;
    @Context
    HttpServletRequest req;

    /**
     * Creates a new instance of VartotojasResource
     */
    public VartotojasResource() {
    }

    /**
     * Retrieves representation of an instance of lt.svako.stud.robertasjarockis.baigiamasiswebapp.rs.VartotojasResource
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Vartotojas> getJson() {
//        VartotojasManager varman = new VartotojasManager();
//        return varman.getAllVartotojai();
   // }
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Vartotojas authJson(){
        String stringUsername = req.getHeader("request_user");
        String stringPassword = req.getHeader("request_pass");
        System.out.println(stringUsername);
        System.out.println(stringPassword);
        return Utils.authenticate(stringUsername, stringPassword).get(0);
    }

    /**
     * PUT method for updating or creating an instance of VartotojasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(String content){
       Vartotojas parse = Utils.parseVartotojas(content);
        System.out.println(content);
        VartotojasManager vm = new VartotojasManager();
        System.out.println(parse.getVartotojopav());
        vm.createVartotojas(parse);
        return Response.status(201).build();
    }
}
