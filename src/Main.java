import model.*;
import service.NotaService;
import service.StudentService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        // creare obiect Specializare
//        Specializare specializare1 = new Specializare("Informatica", new ArrayList<>());
//
//        // creare obiecte Student
//        Student student1 = new Student("Popescu", "George", "1234567890123", 1, TipLoc.BUGET, new ArrayList<>());
//        Student student2 = new Student("Negoiu", "Andreea", "2234567890123", 1, TipLoc.BUGET, new ArrayList<>());
//        Student student3 = new Student("Dumitru", "Mihai", "1234567890123", 1, TipLoc.TAXA, new ArrayList<>());
//
//        // creare obiecte Curs
//        Curs curs1 = new Curs("Programare Avansata pe Obiecte", 5, "PAO", new ArrayList<>());
//        Curs curs2 = new Curs("Inteligenta Artificiala", 5, "IA", new ArrayList<>());
//
//        // creare obiecte Nota
//        Nota nota1 = new Nota(9, curs1, student1);
//        Nota nota2 = new Nota(8, curs2, student1);
//        Nota nota3 = new Nota(7, curs1, student2);
//        Nota nota4 = new Nota(6, curs2, student2);
//        Nota nota5 = new Nota(10, curs1, student3);
//        Nota nota6 = new Nota(8, curs2, student3);
//
//        // adaugare note in lista de note a cursurilor
//        curs1.getNote().add(nota1);
//        curs1.getNote().add(nota3);
//        curs1.getNote().add(nota5);
//        curs2.getNote().add(nota2);
//        curs2.getNote().add(nota4);
//        curs2.getNote().add(nota6);
//
//        // creare obiecte Grupa si adaugare studenti
//        Grupa grupa1 = new Grupa("101", new ArrayList<>());
//        grupa1.getStudenti().add(student1);
//        grupa1.getStudenti().add(student2);
//        grupa1.getStudenti().add(student3);
//
//        // creare obiecte Facultate si adaugare specializare si grupa
//        Facultate facultate = new Facultate("Facultatea de Informatica", "Bucuresti", new ArrayList<>());
//        specializare1.getGrupe().add(grupa1);
//        facultate.getSpecializari().add(specializare1);
//
//        // afisare informatii
//        System.out.println("Nume facultate: " + facultate.getNumeFacultate());
//        System.out.println("Adresa facultate: " + facultate.getAdresa());
//
//        System.out.println("\nSpecializari: ");
//        for (Specializare sp : facultate.getSpecializari()) {
//            System.out.println("- " + sp.getNumeSpecializare());
//        }
//
//        System.out.println("\nGrupe pentru specializarea de " + specializare1.getNumeSpecializare() + ":");
//        for (Grupa gr : specializare1.getGrupe()) {
//            System.out.println("- " + gr.getNume());
//        }
//
//        System.out.println("\nStudenti pentru grupa " + grupa1.getNume() + ":");
//        for (Student st : grupa1.getStudenti()) {
//            System.out.println("- " + st.getNume() + " " + st.getPrenume() + " - An de studiu: " + st.getAnStudiu() + " - Tip loc: " + st.getTipLoc());
//        }
//
//        System.out.println("\nNote pentru cursul " + curs1.getNumeCurs() + ":");
//        for (Nota n : curs1.getNote()) {
//            System.out.println("- " + n.getValoare() );
//        }


        // Adaugare studenti
        Student student1 = new Student("Constantin", "Ana", "1930407162811", 1, TipLoc.BUGET);
        Student student2 = new Student("Popa", "Costin", "2880122345166", 1, TipLoc.TAXA);
        Student student3 = new Student("Popescu", "George", "1850419358729", 1, TipLoc.BUGET);
        Student student4 = new Student("Negoiu", "Andreea", "2930601062748", 1, TipLoc.BUGET);
        Student student5 = new Student("Dumitru", "Mihai", "1970224160108", 1, TipLoc.TAXA);
        Student student6 = new Student("Dumitru", "Ioana", "1870828103456", 1, TipLoc.TAXA);

        StudentService studentService = new StudentService();

        // Adăugăm studenții
        studentService.adaugaStudent(student1);
        studentService.adaugaStudent(student2);
        studentService.adaugaStudent(student3);
        studentService.adaugaStudent(student4);
        studentService.adaugaStudent(student5);
        studentService.adaugaStudent(student6);

        // Obținem lista de studenți
        List<Student> studentList = studentService.getStudenti();
        System.out.println("Lista de studenți:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();


        // cautam studentul dupa id
        Optional<Student> optionalStudent = studentService.cautaStudent(2);
        if (optionalStudent.isPresent()) {
            Student studentCautat = optionalStudent.get();
            System.out.println("Studentul cautat: " + studentCautat);
        } else {
            System.out.println("Nu s-a gasit studentul cu id-ul 2");
        }

        // Obținem setul de studenți sortat după nume
        Set<Student> studentSet = studentService.getStudentiSortatiDupaNume();
        System.out.println("Setul de studenți sortat după nume:");
        for (Student student : studentSet) {
            System.out.println(student);
        }
        System.out.println();


        // Obținem studenții care sunt la taxă
        List<Student> studentiTaxa = studentService.getStudentiDupaTipLoc(TipLoc.TAXA);
        System.out.println("Studenții care sunt la taxă:");
        for (Student student : studentiTaxa) {
            System.out.println(student);
        }
        System.out.println();

        // Ștergem un student din listă
        studentService.stergeStudent(student4.getId());
        System.out.println("Lista de studenți după ștergere:");
        studentList = studentService.getStudenti();
        for (Student student : studentList) {
            System.out.println(student);
        }

        // Modificam un student
        student4.setTipLoc(TipLoc.BUGET);
        studentService.modificaStudent(student4);

        // Adaugare cursuri pentru un semestru
        Curs curs1 = new Curs("Programare Avansata pe Obiecte", 6, "PAO");
        Curs curs2 = new Curs("Inteligenta Artificiala", 6, "IA");
        Curs curs3 = new Curs("Baze de Date", 6, "BD");
        Curs curs4 = new Curs("Tehnici Web", 6, "TW");
        Curs curs5 = new Curs("Programare Algoritmilor", 6, "PA");

        Nota nota1 = new Nota(9, curs1, student1);
        Nota nota2 = new Nota(10, curs2, student1);
        Nota nota3 = new Nota(8, curs3, student1);
        Nota nota4 = new Nota(4, curs4, student1);
        Nota nota5 = new Nota(7, curs5, student1);
        Nota nota6 = new Nota(8, curs1, student2);

        List<Nota> note = new ArrayList<>();
        note.add(nota1);
        note.add(nota2);
        note.add(nota3);

        // creare serviciu pentru gestionarea notelor
        NotaService notaService = new NotaService(note);
        notaService.adaugaNota(nota4);
        notaService.adaugaNota(nota5);
        notaService.adaugaNota(nota6);

        // testarea metodelor
        System.out.println("Nota cautata: " + notaService.cautaNotaDupaStudentSiCurs(student1, curs1));
        System.out.println("Note student: " + notaService.getNoteStudent(student1));
        System.out.println("Note student crescator: " + notaService.getNoteStudentCrescator(student1));
        System.out.println("Note curs: " + notaService.getNoteCurs(curs1));
        System.out.println("Medie aritmetica student: " + notaService.calculeazaMedieAritmeticaStudent(student1));
        System.out.println("Medie ponderata student: " + notaService.calculeazaMediePonderataStudent(student1));
        System.out.println("Numar credite student: " + notaService.numarTotalCrediteObtinute(student1));
        System.out.println("Numar puncte credite student: " + notaService.numarPuncteCredite(student1));
        System.out.println("Cursuri cu restanta student: " + notaService.getCursuriStudentCuRestanta(student1));

        notaService.stergeNota(nota1);
        System.out.println("Note student dupa stergere: " + notaService.getNoteStudent(student1));

        notaService.modificaNota(student1, curs4, 5);
        System.out.println("Note student dupa modificare: " + notaService.getNoteStudent(student1));

    }
}
