package eu.xn__emaitis_cxb.mokslai.docs;

/**
 * Created by edvin on 2017.04.10.
 */

public class Dokumentas {
    private String regNr;
    private String numeris;
    private String tipas;
    private String siuntejas;
    private String gavejas;
    private String aprasymas;
    private String atsakymas;

    public Dokumentas(String regNr, String numeris, String tipas, String siuntejas, String gavejas, String aprasymas, String atsakymas) {
        this.regNr = regNr;
        this.numeris = numeris;
        this.tipas = tipas;
        this.siuntejas = siuntejas;
        this.gavejas = gavejas;
        this.aprasymas = aprasymas;
        this.atsakymas = atsakymas;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getNumeris() {
        return numeris;
    }

    public void setNumeris(String numeris) {
        this.numeris = numeris;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    public String getSiuntejas() {
        return siuntejas;
    }

    public void setSiuntejas(String siuntejas) {
        this.siuntejas = siuntejas;
    }

    public String getGavejas() {
        return gavejas;
    }

    public void setGavejas(String gavejas) {
        this.gavejas = gavejas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public String getAtsakymas() {
        return atsakymas;
    }

    public void setAtsakymas(String atsakymas) {
        this.atsakymas = atsakymas;
    }
}