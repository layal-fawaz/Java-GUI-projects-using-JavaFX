/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import javafx.scene.control.Alert;

/**
 *
 * @author awadallah
 */
public class StudentList {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        for (Student std : students) {
            if (std.getId() == s.getId()) { //check if student for this id found before
            showAlert("ID Exists", "A student with this ID already exists. Please use a different ID.");
                return;
            }
        }
        students.add(s); //add student
    }
    //---------------------------------------------

    public boolean removeStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            //check if iterator has next student with (id) and this id equal id entered by user remove student

            if (iterator.next().getId() == id) {
                iterator.remove();
                return true; // removed std
            }
        }
        return false; // no std found
    }

    //---------------------------------------------
    public Student searchStdById(int id) {
        for (Student std : students) { //check if student found by searching with id
            if (std.getId() == id) {
                return std;
            }
        }
        return null; // Return null if no student is found
    }

    //---------------------------------------------
    public ArrayList<Student> searchStdByName(String name) {
        ArrayList<Student> foundStudents = new ArrayList<>(); //store students with specific name in array
        for (Student st : students) {
            if (st.getName().equalsIgnoreCase(name)) { //if name found std
                foundStudents.add(st);
            }
        }
        return foundStudents; // Return list of students found by name
    }

    //---------------------------------------------
    public Student displayTopStudentInAllMajors() {
        return students.stream().max(Comparator.comparing(Student::getGpa)).orElse(null);
    }

    //---------------------------------------------
    public Student displayTopStudentInSpecificMajor(String major) {
        Student top = null;// this var to hold the top student in the current major

        /*loop through all students to find the one with the highest GPA in the specified major
    then check If no top student is assigned yet or current std GPA is >top ==>update the top student*/
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                if (top == null || s.getGpa() > top.getGpa()) {
                    top = s;
                }
            }
        }

        // If a top student has been found print detailes and return std
        if (top != null) {
            System.out.println("Top student in major " + major + ":");
            System.out.println(top);
            return top;
        } else {
            System.out.println("No student found in this major");
            return null;
        }
    }

    public void displayAllStudentsSortedByGpa(int choice) {
        // sort the students using stream API and display them
        // Sort in descending order by GPA
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
    }

private void showAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.WARNING); 
    alert.setTitle(title); 
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
    
}
