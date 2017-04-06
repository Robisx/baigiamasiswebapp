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
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Kategorija;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.KategorijaManager;

/**
 * REST Web Service
 *
 * @author User1
 */
@Path("kategorija")
public class KategorijaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KategorijaResource
     */
    public KategorijaResource() {
    }
    /**
     * Retrieves representation of an instance of lt.svako.stud.robertasjarockis.baigiamasiswebapp.rs.KategorijaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kategorija> getJson() {
        KategorijaManager katman = new KategorijaManager();
        return katman.getAllKategorijos();
    }
    /**
     * PUT method for updating or creating an instance of KategorijaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}