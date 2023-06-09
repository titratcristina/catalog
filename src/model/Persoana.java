package model;

import util.IDGenerator;

public abstract class Persoana {
    private String nume;
    private String prenume;
    private String CNP;
    private int id;

    public Persoana(String nume, String prenume, String CNP) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.id = IDGenerator.generateID();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", id=" + id +
                '}';
    }
}
