package tema2.student;

public class Student implements Comparable<Student>{
    private String name;
    private double grade;

    public Student() {

    }

    public Student(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        return - Double.compare(this.grade, o.grade); // decreasing order
    }

    @Override
    public String toString() {
        return "name: "
                + this.name
                + ", grade: "
                + this.grade;
    }
}
