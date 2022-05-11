package ch.bzz.Transfermarkt.model;

import java.util.List;

/**
 * Der Agent hat keinen oder mehrere Spieler auf dem Transfermarkt.
 */

public class Agent {
    private String agentNummer;
    private String vorname;
    private String nachname;
    private String agentur;
    private List<Spieler> spielerList;

    public String getAgentNummer() {
        return agentNummer;
    }

    public void setAgentNummer(String agentNummer) {
        this.agentNummer = agentNummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAgentur() {
        return agentur;
    }

    public void setAgentur(String agentur) {
        this.agentur = agentur;
    }

    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }
}
