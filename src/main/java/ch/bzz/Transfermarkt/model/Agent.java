package ch.bzz.Transfermarkt.model;

import java.util.List;

/**
 * a book publisher
 */
public class Agent {
    private String agentNummer;
    private String vorname;
    private String nachname;
    private String agentur;
    private List<Spieler> spielerList;
    private String vollName = vorname + " "+ nachname;

    /**
     * gets agentNummer
     *
     * @return value of agentNummer
     */
    public String getAgentNummer() {
        return agentNummer;
    }

    /**
     * sets agentNummer
     *
     * @param agentNummer the value to set
     */
    public void setAgentNummer(String agentNummer) {
        this.agentNummer = agentNummer;
    }

    /**
     * gets vollName
     *
     * @return value of vollName
     */
    public String getVollName() {
        return vollName;
    }

    /**
     * sets vollName
     *
     * @param vollName the value to set
     */
    public void setVollName(String vollName) {
        this.vollName = vollName;
    }

    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    public void addSpielertoList(Spieler spieler){
        spielerList.add(spieler);
    }

    public String getAgentur() {
        return agentur;
    }

    public void setAgentur(String agentur) {
        this.agentur = agentur;
    }
}
