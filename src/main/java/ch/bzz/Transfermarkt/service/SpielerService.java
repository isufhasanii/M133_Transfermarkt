package ch.bzz.Transfermarkt.service;

import ch.bzz.Transfermarkt.data.DataHandler;
import ch.bzz.Transfermarkt.model.Spieler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * services for reading, adding, chaning and deleting players
 */
@Path("spieler")
public class SpielerService {

    /**
     * reads a list of all spielers
     * @return spielers as JSON
     */

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSpielers(){
        List<Spieler> spielerList = DataHandler.getInstance().readAllSpielers();
        return Response
                .status(200)
                .entity(spielerList)
                .build();
    }
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpieler(
            @QueryParam("nummer") String spielerNummer
    ){
        Spieler spieler = DataHandler.getInstance().readSpielerByNummer(spielerNummer);
        return Response
                .status(200)
                .entity(spieler)
                .build();
    }

    /**
     * deletes a spieler identified by nummer
     * @param spielerNummer the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteSpieler(
            @QueryParam("nummer") String spielerNummer
    ){
        int httpStatus = 200;
        if (!DataHandler.deleteSpieler(spielerNummer)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }


}
