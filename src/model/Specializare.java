package model;

import java.util.List;

public class Specializare {
    protected String numeSpecializare;
    protected List<Grupa> grupe;

    public Specializare(String numeSpecializare, List<Grupa> grupe) {
        this.numeSpecializare = numeSpecializare;
        this.grupe = grupe;
    }

    public String getNumeSpecializare() {
        return numeSpecializare;
    }

    public void setNumeSpecializare(String numeSpecializare) {
        this.numeSpecializare = numeSpecializare;
    }

    public List<Grupa> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupa> grupe) {
        this.grupe = grupe;
    }
}
