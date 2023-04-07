package service;

import model.Curs;
import model.Nota;
import model.Student;

import java.util.List;

public interface INotaService {
    void adaugaNota(Nota nota);

    Nota cautaNotaDupaStudentSiCurs(Student student, Curs curs);

    void stergeNota(Nota nota);

    void modificaNota(Student student, Curs curs, int nouaValoare);

    List<Nota> getNoteStudent(Student student);

    List<Nota> getNoteStudentCrescator(Student student);

    List<Nota> getNoteCurs(Curs curs);

    double calculeazaMedieAritmeticaStudent(Student student);

    double calculeazaMediePonderataStudent(Student student);

    int numarTotalCrediteObtinute(Student student);

    int numarPuncteCredite(Student student);

    List<Curs> getCursuriStudentCuRestanta(Student student);
}
