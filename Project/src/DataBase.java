import java.util.ArrayList;
import java.util.HashMap;

public class DataBase implements Repository{

    private final HashMap<String, Student> studentDataBase = new HashMap<>();

    @Override
    public Student findById(String id) {
        return studentDataBase.get(id);
    }

    @Override
    public ArrayList<Student> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void deleteById(String id) {
        studentDataBase.remove(id);
    }

    @Override
    public void addStudent(Student student) {
        studentDataBase.put(student.getId(), student);
    }


}
