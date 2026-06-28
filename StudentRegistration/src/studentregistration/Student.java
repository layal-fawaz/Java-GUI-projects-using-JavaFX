/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

/**
 *
 * @author awadallah
 */
public class Student {

    private int id;
    private String name;
    private double gpa;
    private String major;

    public Student(int id, String name, double gpa, String major) {
        this.id = id;
        this.name = name;
        setGpa(gpa);
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean setGpa(double gpa) {
        if (gpa > 0 && gpa <= 100) {
            this.gpa = gpa;
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        if (this.id != 0) {  // إذا الـ id تم تعيينه من قبل
            System.out.println("You can't change the ID once it's set.");
            return false;
        }

        if (id > 0) {
            this.id = id;   // assign id for first time
            return true;
        } else {
            System.out.println("ID must be greater than 0");
            return false;
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", id=" + id + ", major=" + major + '}';
    }

}
