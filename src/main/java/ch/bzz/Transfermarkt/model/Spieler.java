package ch.bzz.Transfermarkt.model;

import ch.bzz.Transfermarkt.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

/**
 * a book in the bookshelf
 */
public class Spieler {
    @JsonIgnore
    private String spielerNummer;
    private String vorname;
    private String nachname;
    private Agent agent;
    private BigDecimal marktWert;
    private Mannschaft verein;
    private String marktID;
    private String vollName = vorname +" "+ nachname;

    /**
     * gets the mannschaftID from the Mannschaft-object
     * @return
     */
    public String getMannschaftID() {
        return verein.getMannschaftID();
    }

    /**
     * creates a Mannschaft-object without the spielerList
     * @param mannschaftID
     */
    public void setMannschaftID(String mannschaftID) {
        setMannschaft( new Mannschaft());
        Mannschaft mannschaft = DataHandler.getInstance().readMannschaftByID(mannschaftID);
        verein.setMannschaftID(mannschaftID);
        verein.setMannschaftID(verein.getMannschaftID());

    }

    /**
     * gets Mannschaft
     *
     * @return value of verein
     */
    public Mannschaft getMannschaft() {
        return verein;
    }

    /**
     * sets Mannschaft
     *
     * @param verein the value to set
     */
    public void setMannschaft(Mannschaft verein) {
        this.verein = verein;
    }

    /**
     * gets spielerNummer
     *
     * @return value of spielerNummer
     */
    public String getSpielernummer() {
        return spielerNummer;
    }

    /**
     * sets spielerID
     *
     * @param spielerNummer the value to set
     */
    public void setSpielerNummer(String spielerNummer) {
        this.spielerNummer = spielerNummer;
    }

    /**
     * gets vollName
     *
     * @return value of vollName
     */
    public String getName() {
        return vollName;
    }

    /**
     * sets vollName
     *
     * @param vollName the value to set
     */
    public void setName(String vollName) {
        this.vollName = vollName;
    }

    /**
     * gets agent
     *
     * @return value of agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * sets agent
     *
     * @param agent the value to set
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }


    /**
     * gets marktWert
     *
     * @return value of marktWert
     */
    public BigDecimal getMarktWert() {
        return marktWert;
    }

    /**
     * sets pmarktWert
     *
     * @param marktWert the value to set
     */
    public void setMarktWert(BigDecimal marktWert) {
        this.marktWert = marktWert;
    }

    /**
     * gets marktID
     *
     * @return value of marktID
     */
    public String getMarktID() {
        return marktID;
    }

    /**
     * sets marktID
     *
     * @param marktID the value to set
     */
    public void setMarktID(String marktID) {
        this.marktID = marktID;
    }
}