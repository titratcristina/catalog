package service;

import model.Facultate;

import java.util.ArrayList;
import java.util.List;

public class FacultateService {
    private List<Facultate> facultati = new ArrayList<>();

    public void adaugaFacultate(Facultate facultate) {
        facultati.add(facultate);
    }

    public void stergeFacultate(Facultate facultate) {
        facultati.remove(facultate);
    }

    public void modificaFacultate(Facultate facultate, String numeFacultate, String adresa) {
        facultate.setNumeFacultate(numeFacultate);
        facultate.setAdresa(adresa);
    }

    public Facultate cautaFacultateDupaNume(String numeFacultate) {
        for (Facultate facultate : facultati) {
            if (facultate.getNumeFacultate().equals(numeFacultate)) {
                return facultate;
            }
        }
        return null;
    }

    public List<Facultate> getFacultati() {
        return facultati;
    }
}

