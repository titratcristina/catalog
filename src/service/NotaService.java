package service;

import model.Curs;
import model.Nota;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clasa NotaService oferă metode pentru gestionarea obiectelor de tip Nota.
 */
public class NotaService implements INotaService {
    private final List<Nota> note;

    /**
     * Constructorul clasei.
     *
     * @param note o listă cu obiecte de tip Nota
     */
    public NotaService(List<Nota> note) {
        this.note = note;
    }

    /**
     * Adaugă un obiect de tip Nota în lista de note.
     *
     * @param nota obiectul de tip Nota de adăugat
     */
    @Override
    public void adaugaNota(Nota nota) {
        note.add(nota);
    }

    /**
     * Caută un obiect de tip Nota după student și curs.
     *
     * @param student obiectul de tip Student pentru care se caută nota
     * @param curs    obiectul de tip Curs pentru care se caută nota
     * @return obiectul de tip Nota căutat sau null dacă acesta nu există
     */
    @Override
    public Nota cautaNotaDupaStudentSiCurs(Student student, Curs curs) {
        for (Nota nota : note) {
            if (nota.getStudent().equals(student) && nota.getCurs().equals(curs)) {
                return nota;
            }
        }
        return null;
    }

    /**
     * Șterge un obiect de tip Nota din lista de note.
     *
     * @param nota obiectul de tip Nota de șters
     */
    @Override
    public void stergeNota(Nota nota) {
        note.remove(nota);
    }

    /**
     * Modifică valoarea unei note pentru un anumit student și curs.
     *
     * @param student     obiectul de tip Student pentru care se modifică nota
     * @param curs        obiectul de tip Curs pentru care se modifică nota
     * @param nouaValoare valoarea nouă a notei
     */
    @Override
    public void modificaNota(Student student, Curs curs, int nouaValoare) {
        Nota nota = cautaNotaDupaStudentSiCurs(student, curs);
        if (nota != null) {
            nota.setValoare(nouaValoare);
        }
    }

    /**
     * Returnează o listă cu toate notele pentru un anumit student.
     *
     * @param student obiectul de tip Student pentru care se caută notele
     * @return lista cu obiecte de tip Nota
     */
    @Override
    public List<Nota> getNoteStudent(Student student) {
        List<Nota> noteStudent = new ArrayList<>();
        for (Nota nota : note) {
            if (nota.getStudent().equals(student)) {
                noteStudent.add(nota);
            }
        }
        return noteStudent;
    }

    /**
     * Returnează o listă cu toate notele pentru un anumit student, sortate crescător.
     *
     * @param student obiectul de tip Student pentru care se caută notele
     * @return lista cu obiecte de tip Nota sortate crescător după valoare
     */
    @Override
    public List<Nota> getNoteStudentCrescator(Student student) {
        List<Nota> noteStudent = getNoteStudent(student);
        Collections.sort(noteStudent, (nota1, nota2) -> nota1.getValoare() - nota2.getValoare());
        return noteStudent;
    }

    /**
     * Returnează lista notelor asociate unui anumit curs.
     *
     * @param curs cursul pentru care se doresc notele
     * @return lista notelor asociate cursului dat
     */
    @Override
    public List<Nota> getNoteCurs(Curs curs) {
        List<Nota> noteCurs = new ArrayList<>();
        for (Nota nota : note) {
            if (nota.getCurs().equals(curs)) {
                noteCurs.add(nota);
            }
        }
        return noteCurs;
    }

    /**
     * Calculează media aritmetică a unui student.
     *
     * @param student studentul pentru care se dorește calcularea mediei
     * @return media aritmetică a notelor studentului sau 0 dacă studentul nu are nicio notă
     */
    @Override
    public double calculeazaMedieAritmeticaStudent(Student student) {
        List<Nota> noteStudent = getNoteStudent(student);
        int numarNote = noteStudent.size();
        if (numarNote == 0) {
            return 0.0;
        }
        int sumaNote = 0;
        for (Nota nota : noteStudent) {
            sumaNote += nota.getValoare();
        }
        return (double) sumaNote / numarNote;
    }

    /**
     * Calculează media ponderata a unui student.
     *
     * @param student studentul pentru care se dorește calcularea mediei
     * @return media ponderată a notelor studentului sau 0 dacă studentul nu are nicio notă
     */
    @Override
    public double calculeazaMediePonderataStudent(Student student) {
        List<Nota> noteStudent = getNoteStudent(student);
        int numarNote = noteStudent.size();
        if (numarNote == 0) {
            return 0.0;
        }
        int sumaProduselor = 0;
        int sumaCredite = 0;
        for (Nota nota : noteStudent) {
            int valoare = nota.getValoare();
            int numarCredite = nota.getCurs().getNumarCredite();
            if (valoare < 5) {
                sumaProduselor += 0 * numarCredite;
            } else {
                sumaProduselor += valoare * numarCredite;
            }
            sumaCredite += numarCredite;
        }
        return (double) sumaProduselor / sumaCredite;
    }

    /**
     * Calculează numărul de credite ale unui student.
     *
     * @param student studentul pentru care se dorește calcularea creditelor
     * @return numărul de credite ale studentului sau 0 dacă studentul nu are niciun credit
     */
    @Override
    public int numarTotalCrediteObtinute(Student student) {
        int numarCredite = 0;
        for (Nota nota : note) {
            if (nota.getStudent().equals(student) && nota.getValoare() >= 5) {
                numarCredite += nota.getCurs().getNumarCredite();
            }
        }
        return numarCredite;
    }

    /**
     * Calculează numărul de puncte credit ale unui student.
     *
     * @param student studentul pentru care se dorește calcularea creditelor
     * @return numărul de credite ale studentului sau 0 dacă studentul nu are niciun credit
     */
    @Override
    public int numarPuncteCredite(Student student) {
        int numarPuncte = 0;
        for (Nota nota : note) {
            if (nota.getStudent().equals(student)) {
                int puncte = nota.getValoare() >= 5 ? nota.getValoare() * nota.getCurs().getNumarCredite() : 0;
                numarPuncte += puncte;
            }
        }
        return numarPuncte;
    }

    /**
     * Returnează cursurile la care un student are restață.
     *
     * @param student studentul pentru care se dorește căutarea restanțelor
     * @return restanțele studentului
     */
    @Override
    public List<Curs> getCursuriStudentCuRestanta(Student student) {
        List<Nota> noteStudent = getNoteStudent(student);
        List<Curs> cursuriCuRestanta = new ArrayList<>();
        for (Nota nota : noteStudent) {
            if (nota.getValoare() < 5) {
                cursuriCuRestanta.add(nota.getCurs());
            }
        }
        return cursuriCuRestanta;
    }

}
