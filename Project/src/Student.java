public class Student extends Person{

    private String degree;
    private int semester;

    public Student(String name, int age, String id, String degree, int semester) {
        super(name, age, id);
        setDegree(degree);
        setSemester(semester);
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
