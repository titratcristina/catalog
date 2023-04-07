package service;

import model.Curs;
import model.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorService {
    private List<Profesor> profesorList;

    public ProfesorService() {
        this.profesorList = new ArrayList<>();
    }

    public void adaugaProfesor(Profesor profesor) {
        profesorList.add(profesor);
    }

    public void stergeProfesor(Profesor profesor) {
        profesorList.remove(profesor);
    }

    public void adaugaCurs(Profesor profesor, Curs curs) {
        profesor.getCursuri().add(curs);
    }

    public void stergeCurs(Profesor profesor, Curs curs) {
        profesor.getCursuri().remove(curs);
    }

    public List<Profesor> cautaProfesorDupaNume(String nume) {
        List<Profesor> profesoriGasiti = new ArrayList<>();
        for (Profesor profesor : profesorList) {
            if (profesor.getNume().equalsIgnoreCase(nume)) {
                profesoriGasiti.add(profesor);
            }
        }
        return profesoriGasiti;
    }

    public List<Curs> cautaCursDupaNume(String nume) {
        List<Curs> cursuriGasite = new ArrayList<>();
        for (Profesor profesor : profesorList) {
            for (Curs curs : profesor.getCursuri()) {
                if (curs.getNumeCurs().equalsIgnoreCase(nume)) {
                    cursuriGasite.add(curs);
                }
            }
        }
        return cursuriGasite;
    }

    public List<Profesor> getProfesori() {
        return profesorList;
    }

    public void modificaInformatiiProfesor(Profesor profesor, String nume, String prenume) {
        profesor.setNume(nume);
        profesor.setPrenume(prenume);
    }
}