package ch.bzz.Transfermarkt.model;

import java.math.BigDecimal;
/**
 * Ein Spieler auf dem Transfermarkt.
 */
public class Spieler {
private String spielerNummer;
private String vorname;
private String nachname;
private Agent agent;
private BigDecimal marktWert;
private Mannschaft verein;
private String marktID;

    public String getSpielerNummer() {
        return spielerNummer;
    }

    public void setSpielerNummer(String spielerNummer) {
        this.spielerNummer = spielerNummer;
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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public BigDecimal getMarktWert() {
        return marktWert;
    }

    public void setMarktWert(BigDecimal marktWert) {
        this.marktWert = marktWert;
    }

    public Mannschaft getVerein() {
        return verein;
    }

    public void setVerein(Mannschaft verein) {
        this.verein = verein;
    }

    public String getMarktID() {
        return marktID;
    }

    public void setMarktID(String marktID) {
        this.marktID = marktID;
    }
}
