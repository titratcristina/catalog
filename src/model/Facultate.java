package model;

import java.util.List;

public class Facultate {
    protected String numeFacultate;
    protected String adresa;
    protected List<Specializare> specializari;

    public Facultate(String numeFacultate, String adresa, List<Specializare> specializari) {
        this.numeFacultate = numeFacultate;
        this.adresa = adresa;
        this.specializari = specializari;
    }

    public String getNumeFacultate() {
        return numeFacultate;
    }

    public void setNumeFacultate(String numeFacultate) {
        this.numeFacultate = numeFacultate;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Specializare> getSpecializari() {
        return specializari;
    }

    public void setSpecializari(List<Specializare> specializari) {
        this.specializari = specializari;
    }

    @Override
    public String toString() {
        return "Facultate{" +
                "nume='" + numeFacultate + '\'' +
                ", adresa='" + adresa + '\'' +
                ", specializari=" + specializari +
                '}';
    }
}