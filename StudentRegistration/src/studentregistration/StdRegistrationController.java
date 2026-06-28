/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

/**
 * FXML Controller class
 *
 * @author awadallah
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class StdRegistrationController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField major;
    @FXML
    private TextField gpa;
    @FXML
    private TextField name;

    StudentList studentList = new StudentList(); //creat object from studentList class to call methods

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void add(MouseEvent event) {
        try {
            //get attributes from user and store values in Student object
            int stdId = Integer.parseInt(id.getText());
            String stdName = name.getText();
            String stdMajor = major.getText();
            double stdGpa = Double.parseDouble(gpa.getText());

          // Create student object
        Student student = new Student(stdId, stdName, stdGpa, stdMajor);

        // Check if GPA is valid
        if (!student.setGpa(stdGpa)) { 
            showAlert("Invalid GPA", "GPA must be between 0 and 100");
            return;
        }

            studentList.addStudent(student); //call addaddStudent method to add this std

            showAlert("added done", "student added successfully:\n" + student);
        } catch (Exception e) {
            showAlert("failed added student", "Please Enter a Valid Values");
        }
    }

    @FXML
private void remove(MouseEvent event) {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("remove student by id");
    dialog.setHeaderText("enter student id:");
    dialog.setContentText("id:");

    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        int stdId = Integer.parseInt(result.get());
        if (studentList.removeStudent(stdId)) {
            Alert alert = new Alert(Alert.AlertType.NONE, "student removed successfully", ButtonType.OK);
            alert.showAndWait();
        }
        
        else{
            Alert alert = new Alert(Alert.AlertType.NONE, "no student to removed", ButtonType.OK);
            alert.showAndWait();  
        }
    }
}
@FXML
private void searchname(MouseEvent event) {
    // Create a dialog to get the student's name
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Search by Name");
    dialog.setHeaderText("Enter student's name:");
    dialog.setContentText("Name:");

    // Show the dialog and wait for the user to enter the name
    dialog.showAndWait().ifPresent(name -> {
        // Search for students with the entered name
        ArrayList<Student> foundStudents = studentList.searchStdByName(name);

        // If students are found, show their details in an alert
        if (!foundStudents.isEmpty()) {
            String result = foundStudents.stream()
                    .map(Student::toString)
                    .collect(Collectors.joining("\n"));
            showAlert("Search Result", result);
        } else {
            // If no student is found, show a message saying so
            showAlert("Search Result", "No student found with that name.");
        }
    });
}

@FXML
private void searchid(MouseEvent event) {
    // Create a dialog for user to enter the student ID
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Search by ID");
    dialog.setHeaderText("Enter the student ID:");
    dialog.setContentText("ID:");

    // Wait for user input
    dialog.showAndWait().ifPresent(input -> {
        try {
            // Convert input to integer
            int stdId = Integer.parseInt(input);

            // Search for the student with the given ID
            Student result = studentList.searchStdById(stdId);

            // If student is found, show their details in an alert
            if (result != null) {
                showAlert("Search Result", result.toString());
            } else {
                // If no student is found, show a message saying so
                showAlert("Search Result", "No student found with this ID.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid ID input
            showAlert("Error", "Please enter a valid number for the student ID.");
        }
    });
}

    @FXML
    private void top_majors(MouseEvent event) {
        Student top = studentList.displayTopStudentInAllMajors();
        if (top != null) {
            showAlert("Top Student In All Majors", top.toString());
        } else {
            showAlert("failed", "no students found");
        }
    }

    @FXML
    private void specefic_top(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("top student in specefic major");
        dialog.setHeaderText("enter major:");
        dialog.setContentText("major:");

        dialog.showAndWait().ifPresent(inputMajor -> {
            //call displayTopStudentInSpecificMajor method
            Student top = studentList.displayTopStudentInSpecificMajor(inputMajor);
            if (top != null) {
                showAlert("Top Student In Specific Major", top.toString());
            } else {
                showAlert("failed", "no students found in this major");
            }
        });
    }

    @FXML
    private void desc_sort(MouseEvent event) {
        String resultStr = studentList.students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .map(Student::toString)
                .collect(Collectors.joining("\n"));

        if (resultStr.isEmpty()) {
            showAlert("descending sort", "no students found");
        } else {
            showAlert("descending sort", resultStr);
        }
    }

    @FXML
    private void asc_sort(MouseEvent event) {
        String resultStr = studentList.students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .map(Student::toString)
                .collect(Collectors.joining("\n"));

        if (resultStr.isEmpty()) {
            showAlert("ascending sort", "no students found");
        } else {
            showAlert("ascending sort", resultStr);
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 300);
        alert.showAndWait();
    }

}
