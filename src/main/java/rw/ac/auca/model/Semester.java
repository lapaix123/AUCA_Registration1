package rw.ac.auca.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Semester {
    @Id
    private String semId;
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "semester")
    private List<Cource> cources;
    @OneToMany(mappedBy = "studentId")
    private List<StudentRegistration> studentRegistrations;

    public Semester() {
    }

    public Semester(String semId) {
        this.semId = semId;
    }

    public Semester(String semId, String name, LocalDate startDate, LocalDate endDate, List<Cource> cources, List<StudentRegistration> studentRegistrations) {
        this.semId = semId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cources = cources;
        this.studentRegistrations = studentRegistrations;
    }

    public List<StudentRegistration> getStudentRegistrations() {
        return studentRegistrations;
    }

    public void setStudentRegistrations(List<StudentRegistration> studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }

    public List<Cource> getCources() {
        return cources;
    }

    public void setCources(List<Cource> cources) {
        this.cources = cources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSemId() {
        return semId;
    }

    public void setSemId(String semId) {
        this.semId = semId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
