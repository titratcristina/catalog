package service;


import model.Curs;

import java.util.ArrayList;
import java.util.List;

public class CursService {
    private List<Curs> cursuri = new ArrayList<>();

    public void adaugaCurs(Curs curs) {
        cursuri.add(curs);
    }

    public void stergeCurs(Curs curs) {
        cursuri.remove(curs);
    }

    public void modificaCurs(Curs curs, String numeCurs, int numarCredite, String cod) {
        curs.setNumeCurs(numeCurs);
        curs.setNumarCredite(numarCredite);
        curs.setCod(cod);
    }

    public Curs cautaCursDupaCod(String cod) {
        for (Curs curs : cursuri) {
            if (curs.getCod().equals(cod)) {
                return curs;
            }
        }
        return null;
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }
}
