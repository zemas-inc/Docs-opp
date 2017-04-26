package eu.xn__emaitis_cxb.mokslai.docs;

/**
 * Created by edvin on 2017.04.19.
 */

public class NaujasVartotojas {
    public String vardas;
    public String slaptazodis;
    public String elPastas;

    public NaujasVartotojas(String vardas, String slaptazodis, String elPastas) {
        this.vardas = vardas;
        this.slaptazodis = slaptazodis;
        this.elPastas = elPastas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }
}
