package ch.bzz.Transfermarkt.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.util.List;

/**
 * a book publisher
 */
public class Agent {

    @FormParam("agentNummer")
    @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
    @NotNull
    private String agentNummer;

    @FormParam("vorname")
    @Size(min = 1, max = 64, message = "Es braucht zwischen 1 - 64 Zeichen")
    @Pattern(regexp = "[A-Z&&a-z]")
    @NotNull
    private String vorname;

    @FormParam("nachname")
    @Size(min = 1, max = 64, message = "Es braucht zwischen 1 - 64 Zeichen")
    @Pattern(regexp = "[A-Z&&a-z]")
    @NotNull
    private String nachname;

    @FormParam("agentur")
    @Size(min = 1, max = 64, message = "Es braucht zwischen 1 - 64 Zeichen")
    @Pattern(regexp = "[A-Z&&a-z]")
    @NotNull
    private String agentur;

    private List<ch.bzz.Transfermarkt.model.Spieler> spielerList;

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
     * @param vorname the value to set
     * @param nachname the value to set
     */
    public void setVollName(String vorname, String nachname) {
        this.vollName = vollName;
    }

    public List<ch.bzz.Transfermarkt.model.Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<ch.bzz.Transfermarkt.model.Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    public void addSpielertoList(ch.bzz.Transfermarkt.model.Spieler spieler){
        spielerList.add(spieler);
    }

    public String getAgentur() {
        return agentur;
    }

    public void setAgentur(String agentur) {
        this.agentur = agentur;
    }
}
