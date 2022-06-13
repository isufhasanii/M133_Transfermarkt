package ch.bzz.Transfermarkt.service;

import ch.bzz.Transfermarkt.data.DataHandler;
import ch.bzz.Transfermarkt.model.Agent;
import ch.bzz.Transfermarkt.model.Mannschaft;
import ch.bzz.Transfermarkt.model.Spieler;

import javax.ws.rs.*;
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
     * @param vorname the vorname
     * @param nachname the nachname
     * @param marktID the marktID
     * @param marktWert the marktWert
     * @param spielerNummer the SpielerNummer
     * @return
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createSpieler(
            @FormParam("vorname") String vorname,
            @FormParam("nachname") String nachname,
            @FormParam("marktID") String marktID,
            @FormParam("marktWert")BigDecimal marktWert,
            @FormParam("spielerNummer")String spielerNummer
    ){
        Spieler spieler = new Spieler();
        spieler.setName(vorname, nachname);
        spieler.setMarktID(marktID);
        spieler.setMarktWert(marktWert);
        spieler.setSpielerNummer(spielerNummer);

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
            @FormParam("spielerNummer") String spielerNummer,
            @FormParam("vorname") String vorname,
            @FormParam("nachname") String nachname,
            @FormParam("marktID") String marktID,
            @FormParam("marktWert") BigDecimal marktWert

            ){
                int httpStatus = 200;
                Spieler spieler = DataHandler.readSpielerByNummer(spielerNummer);
                if (spieler != null){
                    spieler.setName(vorname, nachname);
                    spieler.setMarktID(marktID);
                    spieler.setMarktWert(marktWert);

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
