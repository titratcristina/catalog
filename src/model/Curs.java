package model;

import java.util.List;

public class Curs {
    protected String numeCurs;
    protected int numarCredite;
    protected String cod;
    protected List<Nota> note;

    public Curs(String numeCurs, int numarCredite, String cod, List<Nota> note) {
        this.numeCurs = numeCurs;
        this.numarCredite = numarCredite;
        this.cod = cod;
        this.note = note;
    }

    public Curs(String numeCurs, int numarCredite, String cod) {
        this.numeCurs = numeCurs;
        this.numarCredite = numarCredite;
        this.cod = cod;
    }

    public String getNumeCurs() {
        return numeCurs;
    }

    public void setNumeCurs(String numeCurs) {
        this.numeCurs = numeCurs;
    }

    public int getNumarCredite() {
        return numarCredite;
    }

    public void setNumarCredite(int numarCredite) {
        this.numarCredite = numarCredite;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<Nota> getNote() {
        return note;
    }

    public void setNote(List<Nota> note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Curs{" +
                "numeCurs='" + numeCurs + '\'' +
                ", numarCredite=" + numarCredite +
                ", cod='" + cod + '\'' +
                ", note=" + note +
                '}';
    }
}
