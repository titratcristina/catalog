package service;

import model.Curs;
import model.Nota;
import model.Student;
import model.TipLoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Clasa StudentService oferă metode pentru gestionarea unor liste, seturi și map de studenți.
 */
public class StudentService implements IStudentService {
    private List<Student> studentList;
    private Set<Student> studentSet;

    /**
     * Creează o nouă instanță a clasei StudentService.
     * Initializează cele trei variabile cu obiecte noi ale claselor ArrayList, TreeSet și HashMap.
     */
    public StudentService() {
        studentList = new ArrayList<>();
        // folosesc un sorted set pentru a stoca stundetii in ordine alfabetica
        studentSet = new TreeSet<>(Comparator.comparing(Student::getNume).thenComparing(Student::getPrenume));
    }

    /**
     * Adaugă un student în lista de studenți.
     * @param student obiectul Student care trebuie adăugat
     */
    @Override
    public void adaugaStudent(Student student) {
        studentList.add(student);
        studentSet.add(student);
    }

    /**
     * Modifică informațiile despre un student existent în lista de studenți.
     * @param student obiectul Student care trebuie modificat
     */
    @Override
    public void modificaStudent(Student student) {
        Optional<Student> optionalStudent = studentList.stream().filter(s -> s.getCNP() == student.getCNP ()).findFirst();
        optionalStudent.ifPresent(s -> {
            s.setNume(student.getNume());
            s.setPrenume(student.getPrenume());
            s.setCNP(student.getCNP());
            s.setAnStudiu(student.getAnStudiu());
            s.setTipLoc(student.getTipLoc());
            s.setCursuri(student.getCursuri());
        });
    }

    /**
     * Șterge un student din lista de studenți, pe baza id-ului.
     * @param id id-ul studentului care trebuie șters
     */
    @Override
    public void stergeStudent(int id) {
        studentList.removeIf(s -> s.getId() == id);
        studentSet.removeIf(s -> s.getId() == id);
    }

    /**
     * Caută un student în lista de studenți, pe baza id-ului.
     * @param id id-ul studentului căutat
     * @return un obiect de tip Optional<Student> care conține studentul căutat, sau null dacă nu există
     */
    @Override
    public Optional<Student> cautaStudent(int id) {
        return studentList.stream().filter(s -> s.getId() == id).findFirst();
    }

    /**
     * Returnează lista de studenți.
     * @return lista de studenți
     */
    @Override
    public List<Student> getStudenti() {
        return studentList;
    }

    /**
     * Returnează setul de studenți sortat după nume.
     * @return setul de studenți sortat după nume
     */
    @Override
    public Set<Student> getStudentiSortatiDupaNume() {
        return studentSet;
    }


    /**
     * Returnează studenții care sunt la taxă sau buget.
     * @return listă de studenți
     */
    @Override
    public List<Student> getStudentiDupaTipLoc(TipLoc tipLoc) {
        return studentList.stream().filter(s -> s.getTipLoc() == tipLoc).collect(Collectors.toList());
    }


}
