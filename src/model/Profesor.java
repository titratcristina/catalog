package model;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persoana {
    private List<Curs> cursuri;

    public Profesor(String nume, String prenume, String CNP) {
        super(nume, prenume, CNP);
        this.cursuri = new ArrayList<>();
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }
}
