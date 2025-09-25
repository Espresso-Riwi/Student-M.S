import java.util.List;

public interface Repository {

    Student findById(String id);
    List<Student> getAll();

    void deleteById(String id);
    void addStudent(Student student);

}
