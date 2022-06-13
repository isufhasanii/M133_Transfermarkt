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
    private static List<Spieler> spielerList;
    private static List<Mannschaft> mannschaftList;
    private static List<Agent> agentList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
    }



    /**
     * reads all spielers
     * @return list of spielers
     */
    public static List<Spieler> readAllSpielers() {
        return getSpielerList();
    }

    /**
     * reads a spieler by its nummer
     * @param spielerNummer
     * @return the Spieler (null=not found)
     */
    public static Spieler readSpielerByNummer(String spielerNummer) {
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
    public static List<Mannschaft> readAllMannschafts() {

        return getMannschaftList();
    }

    /**
     * reads a mannschaft by its uuid
     * @param mannschaftID
     * @return the Mannschaft (null=not found)
     */
    public static Mannschaft readMannschaftByID(String mannschaftID) {
        Mannschaft mannschaft = null;
        for (Mannschaft entry : getMannschaftList()) {
            if (entry.getMannschaftID().equals(mannschaftID)) {
                mannschaft = entry;
            }
        }
        return mannschaft;
    }

    /**
     * reads all Agents
     * @return list of agents
     */
    public static List<Agent> readAgents() {

        return getAgentList();
    }

    /**
     * reads a agent by its nummer
     * @param agentNummer
     * @return the Agent (null=not found)
     */
    public static Agent readAgentByNummer(String agentNummer) {
        Agent agent = null;
        for (Agent entry : getAgentList()) {
            if (entry.getAgentNummer().equals(agentNummer)) {
                agent = entry;
            }
        }
        return agent;
    }

    /**
     * reads the spielers from the JSON-file
     */
    private static void readSpielerJSON() {
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
    private static void readMannschaftJSON() {
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
     * reads the mannschafts from the JSON-file
     */
    private static void readAgentJSON() {
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
    private static List<Spieler> getSpielerList() {
        if (spielerList == null) {
            setSpielerList(new ArrayList<>());
            readSpielerJSON();
        }
        return spielerList;
    }

    /**
     * sets spielerList
     *
     * @param spielerList the value to set
     */
    private static void setSpielerList(List<Spieler> spielerList) {
        spielerList = spielerList;
    }

    /**
     * gets mannschaftList
     *
     * @return value of mannschaft
     */
    private static List<Mannschaft> getMannschaftList() {
        if (mannschaftList == null) {
            setMannschaftList(new ArrayList<>());
            readMannschaftJSON();
        }
        return mannschaftList;
    }

    /**
     * sets mannschaftList
     *
     * @param mannschaftList the value to set
     */
    private static void setMannschaftList(List<Mannschaft> mannschaftList) {
        mannschaftList = mannschaftList;
    }

    public static List<Agent> getAgentList() {
        if (agentList == null) {
            setAgentList(new ArrayList<>());
            readAgentJSON();
        }
        return agentList;
    }

    public static void setAgentList(List<Agent> agentList) {
        DataHandler.agentList = agentList;
    }

    public static List<Agent> readAllAgents() {
        return getAgentList();
    }

    public static void insertAgent(Agent agent) {
        getAgentList().add(agent);
        writeAgentJSON();
    }

    public static void insertMannschaft(Mannschaft mannschaft) {
        getMannschaftList().add(mannschaft);
        writeMannschaftJSON();
    }

    public static void insertSpieler(Spieler spieler) {
        getSpielerList().add(spieler);
        writeSpielerJSON();
    }

    public static boolean deleteSpieler(String spielerNummer) {
        Spieler spieler = readSpielerByNummer(spielerNummer);
        if (spieler != null){
            getSpielerList().remove(spieler);
            writeSpielerJSON();
            return true;
        }else {
            return false;
        }
    }

    public static boolean deleteMannschaft(String mannschaftsID) {
        Mannschaft mannschaft = readMannschaftByID(mannschaftsID);
        if (mannschaft != null){
            getMannschaftList().remove(mannschaft);
            writeMannschaftJSON();
            return true;
        }else {
            return false;
        }
    }

    public static boolean deleteAgent(String agentNummer) {
        Agent agent = readAgentByNummer(agentNummer);
        if (agent != null){
            getAgentList().remove(agent);
            writeAgentJSON();
            return true;
        }else {
            return false;
        }
    }

    public static void updateSpieler() {
        writeSpielerJSON();
    }

    public static void updateMannschaft() {
        writeMannschaftJSON();
    }

    public static void updateAgent() {
        writeAgentJSON();
    }

    private static void writeSpielerJSON() {

    }
    private static void writeMannschaftJSON() {

    }
    private static void writeAgentJSON() {

    }

}