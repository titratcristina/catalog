package model;

public class Nota {
    protected int valoare;
    protected Student student;
    protected Curs curs;

    public Nota(int valoare, Curs curs, Student student) {
        this.valoare = valoare;
        this.curs = curs;
        this.student = student;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    public int getValoare() {
        return valoare;
    }

    public Curs getCurs() {
        return curs;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Nota {" +
                "valoare=" + valoare +
                "; student=" + student.getNume() + " " + student.getPrenume() +
                "; curs=" + curs.getCod() + ", credite=" + curs.getNumarCredite() +
                "}\n";
    }
}
