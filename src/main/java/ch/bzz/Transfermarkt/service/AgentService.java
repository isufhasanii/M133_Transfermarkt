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
            @NotNull
            @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
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
            @NotNull
            @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
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
            @Valid @BeanParam Agent agent
    ){
        agent = new Agent();

        DataHandler.insertAgent(agent);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateAgent(
            @Valid @BeanParam Agent agent

    ){
        int httpStatus = 200;
        agent = DataHandler.readAgentByNummer(agent.getAgentNummer());
        if (agent != null){
            agent.setAgentNummer(agent.getAgentNummer());
            agent.setVollName(agent.getVorname(), agent.getNachname());
            agent.setAgentur(agent.getAgentur());

            DataHandler.updateAgent();
        }else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
