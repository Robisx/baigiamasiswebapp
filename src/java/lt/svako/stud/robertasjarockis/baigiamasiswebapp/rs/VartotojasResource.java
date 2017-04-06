/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.rs;

import java.util.List;
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
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vartotojas;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.VartotojasManager;

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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vartotojas> getJson() {
        VartotojasManager varman = new VartotojasManager();
        return varman.getAllVartotojai();
    }
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List<Vartotojas> authJson(){
        String stringUsername = req.getServletContext().getInitParameter("request_user");
        String stringPassword = req.getServletContext().getInitParameter("request_pass");
        return null;
    }

    /**
     * PUT method for updating or creating an instance of VartotojasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
