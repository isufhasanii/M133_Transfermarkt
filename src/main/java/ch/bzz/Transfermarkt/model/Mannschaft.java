package ch.bzz.Transfermarkt.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.util.List;

/**
 * a mannschaft
 */
public class Mannschaft {

    @FormParam("mannschaftID")
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}")
    @NotNull
    private String mannschaftID;

    @FormParam("vereinsname")
    @Size(min = 1, max = 64, message = "Es braucht zwischen 1 - 64 Zeichen")
    @Pattern(regexp = "[A-Z&&a-z]")
    private String vereinsname;

    private List<ch.bzz.Transfermarkt.model.Spieler> spielerList;

    /**
     * gets mannschaftID
     *
     * @return value of mannschaftID
     */
    public String getMannschaftID() {
        return mannschaftID;
    }

    /**
     * sets mannschaftID
     *
     * @param mannschaftID the value to set
     */
    public void setMannschaftID(String mannschaftID) {
        this.mannschaftID = mannschaftID;
    }

    /**
     * gets vereinsname
     *
     * @return value of vereinsname
     */
    public String getVereinsname() {
        return vereinsname;
    }

    /**
     * sets vereinsname
     *
     * @param vereinsname the value to set
     */
    public void setVereinsname(String vereinsname) {
        this.vereinsname = vereinsname;
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
}
