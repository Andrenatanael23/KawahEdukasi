package id.kawahedukasi.controller;

import id.kawahedukasi.model.Peserta;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Path("/peserta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PesertaController {

//    @Path("/{nama}")
//    @GET
//    public String InputPathParameter(@PathParam("nama") String nama){
//        return "Peserta dengan nama Input Path Parameter : " + nama;
//    }
//
//    @GET
//    public String InputQueryParameter(@QueryParam("nama") String nama){
//        return "Peserta dengan nama Input Query Parameter : " + nama;
//    }

    @GET
    public Response get(){
        return Response.status(Response.Status.OK).entity(Peserta.findAll().list()).build();
    }

    @POST
    @Transactional
    public Response post(Map<String, Object> request){
        Peserta peserta = new Peserta();
        peserta.name = request.get("name").toString();
        peserta.email= request.get("email").toString();
        peserta.phoneNumber= request.get("phoneNumber").toString();

        peserta.persist();  //save to database

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response put(@PathParam("id") Long id, Map<String, Object> request){
        Peserta peserta = Peserta.findById(id);
        if(peserta == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        peserta.name = request.get("name").toString();
        peserta.email= request.get("email").toString();
        peserta.phoneNumber= request.get("phoneNumber").toString();

        peserta.persist();  //save to database

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id, Map<String, Object> request){
        Peserta peserta = Peserta.findById(id);
        if(peserta == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        //save to database
        peserta.delete();

        return Response.status(Response.Status.OK).entity(new HashMap<>()).build();
    }

}
