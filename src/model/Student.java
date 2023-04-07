package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Persoana {
    private int anStudiu;
    private TipLoc tipLoc;
    private List<Curs> cursuri;

    public Student(String nume, String prenume, String CNP, int anStudiu, TipLoc tipLoc) {
        super(nume, prenume, CNP);
        this.anStudiu = anStudiu;
        this.tipLoc = tipLoc;
        this.cursuri = new ArrayList<>();
    }

    public Student(String nume, String prenume, String CNP, int anStudiu, TipLoc tipLoc, List<Curs> cursuri) {
        super(nume, prenume, CNP);
        this.anStudiu = anStudiu;
        this.tipLoc = tipLoc;
        this.cursuri = cursuri;
    }

    public int getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(int anStudiu) {
        this.anStudiu = anStudiu;
    }

    public TipLoc getTipLoc() {
        return tipLoc;
    }

    public void setTipLoc(TipLoc tipLoc) {
        this.tipLoc = tipLoc;
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Student{" +
                "anStudiu=" + anStudiu +
                ", tipLoc=" + tipLoc +
                '}';
    }
}
