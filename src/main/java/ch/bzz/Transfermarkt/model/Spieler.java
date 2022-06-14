package ch.bzz.Transfermarkt.model;

import ch.bzz.Transfermarkt.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.spi.LocaleServiceProvider;

/**
 * a book in the bookshelf
 */
public class Spieler {
    @JsonIgnore

    @FormParam("spielerNummer")
    @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
    @NotNull
    private String spielerNummer;

    @FormParam("vorname")
    @Pattern(regexp = "[A-Z&&a-z]")
    @Size(min = 1, max = 64, message = "Es braucht zwischen 1 - 64 Zeichen")
    private String vorname;

    @FormParam("nachname")
    @Pattern(regexp = "[A-Z&&a-z]")
    @Size(min = 1, max = 64, message = "Es braucht zwischen 1 - 64 Zeichen")
    private String nachname;

    @FormParam("agent")
    private Agent agent;

    @FormParam("marktWert")
    @Pattern(regexp = "[0-9]")
    @Size(min = 100000, max = 1000000000, message = "Marktwert muss zwischen 100'000 & 100'000'000 liegen")
    private BigDecimal marktWert;

    @FormParam("verein")
    private Mannschaft verein;

    @FormParam("marktID")
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}")
    @Size
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
        Mannschaft mannschaft = DataHandler.readMannschaftByID(mannschaftID);
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

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    /**
     * sets vollName
     *
     * @param vorname + nachname the value to set
     */
    public void setName(String vorname, String nachname) {
        vollName = vorname + " " + nachname;
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