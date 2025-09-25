import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    private Validations v = new Validations();

    public void menu(){
        String[] options = {"Add Student", "Delete Student", "Show All Students", "Search Student By ID", "Exit"};

        DataBase db = new DataBase();
        boolean flag = true;
        while (flag){
            String option = JOptionPane.showInputDialog(null, "Welcome to Park4U\nChoose the option that you want: ", "Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[0]).toString();
            switch (option){
                case "Add Student":
                    addStudentInfo(db);
                    break;
                case "Delete Student":
                    deleteStudentById(db);
                    break;
                case "Show All Students":
                    showAllStudents(db);
                    break;
                case "Search Student By ID":
                    showStudentById(db);
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
        StringBuilder students = new StringBuilder();

        for (int i = 0; i < usersList.size(); i++) {
            students.append("Name: ").append(usersList.get(i).getName()).append("\nDegree: ").append(usersList.get(i).getDegree()).append("\nID: ").append(usersList.get(i).getId()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, students.toString(), "Students list", JOptionPane.INFORMATION_MESSAGE);

    }

    public void showStudentById(DataBase db){
        String id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student ID", JOptionPane.QUESTION_MESSAGE);
        Student student = db.findById(id);

        String studentInfo ="Name: "+student.getName()+"\nDegree: "+student.getDegree()+"\nID: "+student.getId();
        JOptionPane.showMessageDialog(null, studentInfo, "Student", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addStudentInfo(DataBase db){
        String id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student Info", JOptionPane.QUESTION_MESSAGE);

        while(!v.isPositive(id) || !v.isInteger(id)){
            JOptionPane.showMessageDialog(null, "The ID is not a number or is a negative number", "Student", JOptionPane.WARNING_MESSAGE);
            id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student Info", JOptionPane.QUESTION_MESSAGE);
            while (!db.idExist(id)){
                JOptionPane.showMessageDialog(null, "The ID is in the database", "Student", JOptionPane.WARNING_MESSAGE);
                id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student Info", JOptionPane.QUESTION_MESSAGE);
            }
        }

        String name = JOptionPane.showInputDialog(null, "Enter the Student name", "Student Info", JOptionPane.QUESTION_MESSAGE);

        while(!v.isValidName(name)){
            JOptionPane.showMessageDialog(null, "The name contains invalid characters", "Student", JOptionPane.WARNING_MESSAGE);
            name = JOptionPane.showInputDialog(null, "Enter the Student name", "Student Info", JOptionPane.QUESTION_MESSAGE);
        }


        String age = JOptionPane.showInputDialog(null, "Enter the Student age", "Student Info", JOptionPane.QUESTION_MESSAGE);

        while(!v.isInteger(age) || !v.isPositive(age)){
            JOptionPane.showMessageDialog(null, "The age is not a number or it's a negative number", "Student", JOptionPane.WARNING_MESSAGE);
            age = JOptionPane.showInputDialog(null, "Enter the Student age", "Student Info", JOptionPane.QUESTION_MESSAGE);
        }
        int parsedAge = Integer.parseInt(age);

        String degree = JOptionPane.showInputDialog(null, "Enter the Student degree", "Student Info", JOptionPane.QUESTION_MESSAGE);
        while(!v.isValidName(degree)){
            JOptionPane.showMessageDialog(null, "The degree contains invalid characters", "Student", JOptionPane.WARNING_MESSAGE);
            degree = JOptionPane.showInputDialog(null, "Enter the Student degree", "Student Info", JOptionPane.QUESTION_MESSAGE);
        }

        String semester = JOptionPane.showInputDialog(null, "Enter the Student semester", "Student Info", JOptionPane.QUESTION_MESSAGE);
        while(!v.isInteger(semester) || !v.isPositive(semester)){
            JOptionPane.showMessageDialog(null, "The semester is not a number or it's a negative number", "Student", JOptionPane.WARNING_MESSAGE);
            semester = JOptionPane.showInputDialog(null, "Enter the Student semester", "Student Info", JOptionPane.QUESTION_MESSAGE);
        }
        int parsedSemester = Integer.parseInt(semester);

        Student student = new Student(name, parsedAge, id, degree, parsedSemester);
        db.addStudent(student);
        JOptionPane.showMessageDialog(null, "The user was created correctly", "Student", JOptionPane.INFORMATION_MESSAGE);

    }

    public void deleteStudentById(DataBase db){
        String id = JOptionPane.showInputDialog(null, "Enter the Student ID", "Student Info", JOptionPane.QUESTION_MESSAGE);
        db.deleteById(id);
        JOptionPane.showMessageDialog(null, "Student deleted correctly", "Student", JOptionPane.INFORMATION_MESSAGE);

    }
}