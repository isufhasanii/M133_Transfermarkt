package ch.bzz.Transfermarkt.data;

import ch.bzz.Transfermarkt.model.Spieler;
import ch.bzz.Transfermarkt.model.Mannschaft;
import ch.bzz.Transfermarkt.model.Agent;
import ch.bzz.Transfermarkt.service.Config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private List<Spieler> spielerList;
    private List<Mannschaft> mannschaftList;
    private List<Agent> agentList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setMannschaftList(new ArrayList<>());
        readMannschaftJSON();
        setSpielerList(new ArrayList<>());
        readSpielerJSON();
        setAgentList(new ArrayList<>());
        readAgentJSON();
    }

    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


    /**
     * reads all spieler
     * @return list of spieler
     */
    public List<Spieler> readAllSpielers() {
        return getSpielerList();
    }

    /**
     * reads a spieler by its spielerNummer
     * @param spielerNummer
     * @return the Spieler (null=not found)
     */
    public Spieler readSpielerByNummer(String spielerNummer) {
        Spieler spieler = null;
        for (Spieler entry : getSpielerList()) {
            if (entry.getSpielernummer().equals(spielerNummer)) {
                spieler = entry;
            }
        }
        return spieler;
    }

    /**
     * reads all Mannschafts
     * @return list of mannschafts
     */
    public List<Mannschaft> readAllMannschaft() {

        return getMannschaftList();
    }
    /**
     * reads all Agents
     * @return list of Agents
     */
    public List<Agent> readAllAgent() {

        return getAgentList();
    }

    /**
     * reads a mannschaft by its ID
     * @param mannschaftID
     * @return the Mannschaft (null=not found)
     */
    public Mannschaft readMannschaftByID(String mannschaftID) {
        Mannschaft verein = null;
        for (Mannschaft entry : getMannschaftList()) {
            if (entry.getMannschaftID().equals(mannschaftID)) {
                verein = entry;
            }
        }
        return verein;
    }
    /**
     * reads a agent by its Nummer
     * @param agentNummer
     * @return the Agent (null=not found)
     */
    public Agent readAgentByNummer(String agentNummer) {
        Agent agent = null;
        for (Agent entry : getAgentList()) {
            if (entry.getAgentNummer().equals(agentNummer)) {
                agent = entry;
            }
        }
        return agent;
    }

    /**
     * reads the spieler from the JSON-file
     */
    private void readSpielerJSON() {
        try {
            String path = Config.getProperty("spielerJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Spieler[] spielers = objectMapper.readValue(jsonData, Spieler[].class);
            for (Spieler spieler : spielers) {
                getSpielerList().add(spieler);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the mannschafts from the JSON-file
     */
    private void readMannschaftJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("mannschaftJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Mannschaft[] mannschafts = objectMapper.readValue(jsonData, Mannschaft[].class);
            for (Mannschaft mannschaft : mannschafts) {
                getMannschaftList().add(mannschaft);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * reads the agent from the JSON-file
     */
    private void readAgentJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("agentJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Agent[] agents = objectMapper.readValue(jsonData, Agent[].class);
            for (Agent agent : agents) {
                getAgentList().add(agent);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * gets spielerList
     *
     * @return value of spielerList
     */
    private List<Spieler> getSpielerList() {
        return spielerList;
    }

    /**
     * sets spielerList
     *
     * @param spielerList the value to set
     */
    private void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    /**
     * gets mannschaftList
     *
     * @return value of mannschaftList
     */
    private List<Mannschaft> getMannschaftList() {
        return mannschaftList;
    }

    /**
     * sets mannschaftLIst
     *
     * @param mannschaftList the value to set
     */
    private void setMannschaftList(List<Mannschaft> mannschaftList) {
        this.mannschaftList = mannschaftList;
    }

    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }
}