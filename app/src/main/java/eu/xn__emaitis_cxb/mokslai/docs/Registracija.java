package eu.xn__emaitis_cxb.mokslai.docs;

public class Registracija {
    private String naujasVardas;
    private String naujasSlaptazodis;
    private String naujasElpastas;

    public Registracija(String naujasVardas, String naujasSlaptazodis, String naujasElpastas) {
        this.naujasVardas = naujasVardas;
        this.naujasSlaptazodis = naujasSlaptazodis;
        this.naujasElpastas = naujasElpastas;
    }

    public String getNaujasVardas() {
        return naujasVardas;
    }

    public void setNaujasVardas(String naujasVardas) {
        this.naujasVardas = naujasVardas;
    }

    public String getNaujasSlaptazodis() {
        return naujasSlaptazodis;
    }

    public void setNaujasSlaptazodis(String naujasSlaptazodis) {
        this.naujasSlaptazodis = naujasSlaptazodis;
    }

    public String getNaujasElpastas() {
        return naujasElpastas;
    }

    public void setNaujasElpastas(String naujasElpastas) {
        this.naujasElpastas = naujasElpastas;
    }
}
