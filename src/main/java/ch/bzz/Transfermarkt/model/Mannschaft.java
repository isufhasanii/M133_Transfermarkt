package ch.bzz.Transfermarkt.model;

import java.util.List;
/**
 * Die Mannschaft hat keinen oder mehrere Spieler auf dem Transfermarkt.
 */
public class Mannschaft {
    private String mannschaftID;
    private String vereinsname;
    private List<Spieler> spielerList;

    public String getMannschaftID() {
        return mannschaftID;
    }

    public void setMannschaftID(String mannschaftID) {
        this.mannschaftID = mannschaftID;
    }

    public String getVereinsname() {
        return vereinsname;
    }

    public void setVereinsname(String vereinsname) {
        this.vereinsname = vereinsname;
    }

    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }
}
