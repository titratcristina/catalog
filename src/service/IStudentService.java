package service;

import model.Student;
import model.TipLoc;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IStudentService {
    void adaugaStudent(Student student);

    void modificaStudent(Student student);

    void stergeStudent(int id);

    Optional<Student> cautaStudent(int id);

    List<Student> getStudenti();

    Set<Student> getStudentiSortatiDupaNume();

    List<Student> getStudentiDupaTipLoc(TipLoc tipLoc);
}
