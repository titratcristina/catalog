package model;

import java.util.List;

public class Grupa {
    protected String nume;
    protected List<Student> studenti;

    public Grupa(String nume, List<Student> studenti) {
        this.nume = nume;
        this.studenti = studenti;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }
}