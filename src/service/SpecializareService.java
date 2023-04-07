package service;

import model.Specializare;

import java.util.ArrayList;
import java.util.List;

public class SpecializareService {
    private List<Specializare> specializari = new ArrayList<>();

    public void adaugaSpecializare(Specializare specializare) {
        specializari.add(specializare);
    }

    public void stergeSpecializare(Specializare specializare) {
        specializari.remove(specializare);
    }

    public void modificaSpecializare(Specializare specializare, String numeSpecializare) {
        specializare.setNumeSpecializare(numeSpecializare);
    }

    public Specializare cautaSpecializareDupaNume(String nume) {
        for (Specializare specializare : specializari) {
            if (specializare.getNumeSpecializare().equals(nume)) {
                return specializare;
            }
        }
        return null;
    }

    public List<Specializare> getSpecializari() {
        return specializari;
    }

    public void setSpecializari(List<Specializare> specializari) {
        this.specializari = specializari;
    }
}

