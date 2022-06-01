package ch.bzz.Transfermarkt.service;

import ch.bzz.Transfermarkt.data.DataHandler;
import ch.bzz.Transfermarkt.model.Agent;
import ch.bzz.Transfermarkt.model.Spieler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;

/**
 * services for reading, adding, chaning and deleting players
 */
@Path("agent")
public class AgentService {

    /**
     * reads a list of all agents
     * @return agents as JSON
     */

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAgents(){
        List<Agent> agents = DataHandler.readAllAgents();
        return Response
                .status(200)
                .entity(agents)
                .build();
    }
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAgent(
            @QueryParam("nummer") String agentNummer
    ){
        Agent agent = DataHandler.readAgentByNummer(agentNummer);
        return Response
                .status(200)
                .entity(agent)
                .build();
    }

    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAgent(
            @QueryParam("nummer") String agentNummer
    ){
        int httpStatus = 200;
        if (!DataHandler.deleteAgent(agentNummer)){
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
    public Response createAgent(
            @FormParam("agentNummer")String agentNummer,
            @FormParam("vorname") String vorname,
            @FormParam("nachname") String nachname,
            @FormParam("agentur") String agentur
    ){
        Agent agent = new Agent();
        agent.setVollName(vorname, nachname);
        agent.setAgentNummer(agentNummer);
        agent.setAgentur(agentur);

        DataHandler.insertAgent(agent);
        return Response
                .status(200)
                .entity("")
                .build();
    }
}
