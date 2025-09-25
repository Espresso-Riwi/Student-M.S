package studentms;

import javax.swing.JOptionPane;

public class StudentMS {

    public static void main(String[] args) {
        Query makeQuery = new Query();

        JOptionPane.showMessageDialog(null, "Welcome to students management system", "Welcome", -1);
        String opt;
        do {
            opt = JOptionPane.showInputDialog(null, "Enter a option\n1 Save student\n2 List of all students\n3 Find a student by name\n4 Delete student\n5 Exit", "Main menu", -1);
            switch (opt) {
                case "1":
                    String id = JOptionPane.showInputDialog(null, "Enter the id to student", "Save Student",-1);
                    String name = JOptionPane.showInputDialog(null, "Enter the name of student", "Save Student",-1);
                    int age = validateInt("Enter the age of student","Save Student");
                    Student estudiante = new Student(id, name, age);
                    makeQuery.save(estudiante);
                    JOptionPane.showMessageDialog(null, "Saved", "Succesful", 1);
                    break;
                case "2":
                    makeQuery.findAll();
                    break;
                case "3":
                    String findId = JOptionPane.showInputDialog(null, "Enter the id of student", "Find Student", -1);
                    makeQuery.findById(findId);
                    break;
                case "4":
                    String deleteId = JOptionPane.showInputDialog(null, "Enter the id of student", "Delete Student", -1);
                    makeQuery.delete(deleteId);
                    JOptionPane.showMessageDialog(null, "Deleted", "succesful", -1);
                    break;
                case "5":
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Please try again", "Invalid Entry", -1);
                    break;
            }
        } while (!opt.equals("5"));
    
    
    }

    static public int validateInt(String input, String tittle) {
        String val = JOptionPane.showInputDialog(null, input, tittle, -1);

        if (val == null) {
            JOptionPane.showMessageDialog(null, "Input cancelled, please try again.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return validateInt(input, tittle);
        }

        if (!val.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid integer.", "Invalid", JOptionPane.ERROR_MESSAGE);
            return validateInt(input, tittle);
        }

        int numero = Integer.parseInt(val);
        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "The number cannot be negative.", "Invalid", JOptionPane.ERROR_MESSAGE);
            return validateInt(input, tittle);
        }

        return numero;
    }

}

