package rw.ac.auca.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Student {
    @Id
    private String regNo;
    private String fName;
    private String lName;
    private String dateOfBirth;
    @OneToOne(mappedBy = "student")
    private StudentRegistration studentRegistration;

    public Student() {
    }

    public Student(String regNo) {
        this.regNo = regNo;
    }

    public Student(String regNo, String fName, String lName, String dateOfBirth, StudentRegistration studentRegistration) {
        this.regNo = regNo;
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.studentRegistration = studentRegistration;
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
