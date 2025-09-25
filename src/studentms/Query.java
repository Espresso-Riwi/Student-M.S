package studentms;

import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Query implements IRepository {

    HashMap<String, Student> repo = new HashMap();
    ArrayList<Student> allStudents = new ArrayList<>();

    @Override
    public void save(Student student) {
        repo.put(student.getId(), student);
        allStudents.add(student);
    }

    @Override
    public void findAll() {
        String Message = "";
        for(Student s : allStudents){
            Message += s.getId()+"|NOMBRE: "+s.getName()+"|\t|EDAD: "+s.getAge()+"|\t|ROL: "+s.getInfo()+" |\n";
        }
        JOptionPane.showMessageDialog(null, Message, "List Students", -1);
    }

    @Override
    public void findById(String id) {
        if(repo.containsKey(id)){
            
        
        JOptionPane.showMessageDialog(null, "|ID: "+repo.get(id).getId() + "| NOMBRE " + repo.get(id).getName() + " |EDAD:  " + repo.get(id).getAge() + "| ROL:  " + repo.get(id).getInfo()+" |", "List Students", -1);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Id not found", "Error",-1);
        findById(id);
        }
        
        

    }

    @Override
    public void delete(String id) {
        if(repo.containsKey(id)){
            
        repo.remove(id);
        }
        else {
        JOptionPane.showMessageDialog(null,"Id not found", "Error",-1);
        delete(id);
        }

    }

}
