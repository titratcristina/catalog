package service;

import model.Grupa;
import model.Student;

import java.util.List;

public class GrupaService {
    private final List<Grupa> grupe;

    public GrupaService(List<Grupa> grupe) {
        this.grupe = grupe;
    }

    public void adaugaGrupa(Grupa grupa) {
        grupe.add(grupa);
    }

    public Grupa cautaGrupaDupaNume(String numeGrupa) {
        for (Grupa grupa : grupe) {
            if (grupa.getNume().equals(numeGrupa)) {
                return grupa;
            }
        }
        return null;
    }

    public void stergeGrupa(Grupa grupa) {
        grupe.remove(grupa);
    }

    public List<Student> getStudentiGrupa(Grupa grupa) {
        return grupa.getStudenti();
    }

    public void adaugaStudentInGrupa(Student student, Grupa grupa) {
        grupa.getStudenti().add(student);
    }

    public void stergeStudentDinGrupa(Student student, Grupa grupa) {
        grupa.getStudenti().remove(student);
    }
}
