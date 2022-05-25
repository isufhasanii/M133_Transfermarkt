package ch.bzz.Transfermarkt.model;

import java.util.List;

/**
 * a mannschaft
 */
public class Mannschaft {
    private String mannschaftID;
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
