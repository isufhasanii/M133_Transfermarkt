package ch.bzz.Transfermarkt.service;

import ch.bzz.Transfermarkt.data.DataHandler;
import ch.bzz.Transfermarkt.model.Agent;
import ch.bzz.Transfermarkt.model.Mannschaft;
import ch.bzz.Transfermarkt.model.Spieler;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
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
        List<Spieler> spielerList = DataHandler.readAllSpielers();
        return Response
                .status(200)
                .entity(spielerList)
                .build();
    }
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpieler(
            @NotNull
            @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
            @QueryParam("nummer") String spielerNummer

    ){
        Spieler spieler = DataHandler.readSpielerByNummer(spielerNummer);
        return Response
                .status(200)
                .entity(spieler)
                .build();
    }

    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteSpieler(
            @NotNull
            @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
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

    /**
     * inserts a new spieler
     * @param mannschaftID the mannschaftID
     * @return
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createSpieler(
            @Valid @BeanParam Spieler spieler,
            @FormParam("mannschaftID") String mannschaftID

    ){
        spieler = new Spieler();
        spieler.setMannschaftID(mannschaftID);

        DataHandler.insertSpieler(spieler);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateSpieler(
            @Valid @BeanParam Spieler spieler,
            @FormParam("mannschaftID") String mannschaftID
            ){
                int httpStatus = 200;
                spieler = DataHandler.readSpielerByNummer(spieler.getSpielernummer());
                if (spieler != null){
                    spieler.setMannschaftID(mannschaftID);
                    spieler.setMarktWert(spieler.getMarktWert());
                    spieler.setMarktID(spieler.getMarktID());
                    spieler.setName(spieler.getVorname(), spieler.getNachname());
                    spieler.setSpielerNummer(spieler.getSpielernummer());

                    DataHandler.updateSpieler();
                }else {
                    httpStatus = 410;
                }
                return Response
                        .status(httpStatus)
                        .entity("")
                        .build();
    }

}
