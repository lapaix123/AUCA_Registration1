package rw.ac.auca.model;

import jakarta.persistence.*;
import rw.ac.auca.model.enums.ERegistrationStatus;

import java.time.LocalDate;
import java.util.List;

@Entity
public class StudentRegistration {
    @Id
    private String studentId;
    private LocalDate registrationDate;
    @ManyToOne
    @JoinColumn(name = "code")
    private AccademicUnit accademicUnit;
    @Enumerated(EnumType.STRING)
    private ERegistrationStatus Regstatus;
    @OneToOne
    @JoinColumn(name = "regNo")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "semId")
    private Semester semester;
    @OneToMany(mappedBy = "stdCId")
    private List<StudentCource> studentCources;

    public StudentRegistration() {
    }

    public StudentRegistration(String studentId) {
        this.studentId = studentId;
    }

    public StudentRegistration(String studentId, LocalDate registrationDate, AccademicUnit accademicUnit, ERegistrationStatus regstatus, Student student, Semester semester, List<StudentCource> studentCources) {
        this.studentId = studentId;
        this.registrationDate = registrationDate;
        this.accademicUnit = accademicUnit;
        Regstatus = regstatus;
        this.student = student;
        this.semester = semester;
        this.studentCources = studentCources;
    }

    public List<StudentCource> getStudentCources() {
        return studentCources;
    }

    public void setStudentCources(List<StudentCource> studentCources) {
        this.studentCources = studentCources;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AccademicUnit getAccademicUnit() {
        return accademicUnit;
    }

    public void setAccademicUnit(AccademicUnit accademicUnit) {
        this.accademicUnit = accademicUnit;
    }

    public ERegistrationStatus getRegstatus() {
        return Regstatus;
    }

    public void setRegstatus(ERegistrationStatus regstatus) {
        Regstatus = regstatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
