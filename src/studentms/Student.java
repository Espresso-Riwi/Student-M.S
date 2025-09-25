
package studentms;
 
public class Student extends Person{

    public Student(String name, String id, int age) {
        super(name, id, age);
    }

    @Override
    public String getInfo() {
        return "estudiante universitario";
    }

}
