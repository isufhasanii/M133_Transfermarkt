package ch.bzz.Transfermarkt.service;

import ch.bzz.Transfermarkt.data.DataHandler;
import ch.bzz.Transfermarkt.model.Agent;
import ch.bzz.Transfermarkt.model.Mannschaft;
import ch.bzz.Transfermarkt.model.Spieler;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;

/**
 * services for reading, adding, chaning and deleting players
 */
@Path("mannschaft")
public class MannschaftService {

    /**
     * reads a list of all mannschafts
     * @return mannschaft as JSON
     */

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMannschafts(){
        List<Mannschaft> mannschaftList = DataHandler.readAllMannschafts();
        return Response
                .status(200)
                .entity(mannschaftList)
                .build();
    }
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMannschaft(
            @NotNull
            @Pattern(regexp = "[0-9]{3}-[0-9]{3}")
            @QueryParam("if") String mannschaftsID
    ){
        Mannschaft mannschaft = DataHandler.readMannschaftByID(mannschaftsID);
        return Response
                .status(200)
                .entity(mannschaft)
                .build();
    }

    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMannschaft(
            @NotNull
            @Pattern(regexp = "[0-9]{3}-[0-9]{3}")
            @QueryParam("id") String mannschaftsID
    ){
        int httpStatus = 200;
        if (!DataHandler.deleteMannschaft(mannschaftsID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createMannschaft(
            @Valid @BeanParam Mannschaft mannschaft
    ){
        mannschaft = new Mannschaft();

        DataHandler.insertMannschaft(mannschaft);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMannschaft(
            @Valid @BeanParam Mannschaft mannschaft
    ){
        int httpStatus = 200;
        mannschaft = DataHandler.readMannschaftByID(mannschaft.getMannschaftID());
        if (mannschaft != null){
            mannschaft.setMannschaftID(mannschaft.getMannschaftID());
            mannschaft.setVereinsname(mannschaft.getVereinsname());

            DataHandler.updateMannschaft();
        }else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
