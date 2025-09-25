import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    public void menu(){
        String[] options = {"Add Student", "Delete Student", "Show All Students", "Search Student By ID", "Exit"};
        String option = JOptionPane.showInputDialog(null, "Welcome to Park4U\nChoose the option that you want: ", "Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[0]).toString();
        DataBase db = new DataBase();
        boolean flag = true;
        while (flag){
            switch (option){
                case "Add Student":
                    break;
                case "Delete Student":
                    break;
                case "Show All Students":
                    showAllStudents(db);
                    break;
                case "Search Student By ID":
                    break;
                case "Exit":
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void showAllStudents(DataBase db){
        ArrayList<Student> usersList = db.getAll();
        String students = "";

        for (int i = 0; i < usersList.size(); i++) {
            students+="Name: "+usersList.get(i).getName()+"\nDegree: "+usersList.get(i).getDegree()+"\nID: "+usersList.get(i).getId()+"\n\n";
        }

        JOptionPane.showMessageDialog(null, students, "Students list", JOptionPane.INFORMATION_MESSAGE);

    }

    public void showStudentById(DataBase db){
        String id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student ID", JOptionPane.QUESTION_MESSAGE);
        Student student = db.findById(id);

        String studentInfo ="Name: "+student.getName()+"\nDegree: "+student.getDegree()+"\nID: "+student.getDegree();
        JOptionPane.showMessageDialog(null, studentInfo, "Student", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addStudentInfo(DataBase db){
        String id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student Info", JOptionPane.QUESTION_MESSAGE);
        String name = JOptionPane.showInputDialog(null, "Enter the Student name", "Student Info", JOptionPane.QUESTION_MESSAGE);
        String age = JOptionPane.showInputDialog(null, "Enter the Student age", "Student Info", JOptionPane.QUESTION_MESSAGE);
        int parsedAge = Integer.parseInt(age);
        String degree = JOptionPane.showInputDialog(null, "Enter the Student degree", "Student Info", JOptionPane.QUESTION_MESSAGE);
        String semester = JOptionPane.showInputDialog(null, "Enter the Student semester", "Student Info", JOptionPane.QUESTION_MESSAGE);
        int parsedSemester = Integer.parseInt(semester);

        Student student = new Student(name, parsedAge, id, degree, parsedSemester);
        db.addStudent(student);

    }
}
