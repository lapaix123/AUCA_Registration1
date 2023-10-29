package rw.ac.auca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;
import rw.ac.auca.model.enums.EAccademicUnit;

import java.util.List;

@Entity
public class AccademicUnit {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "academicName")
    private String name;
    @Column(name = "Unit")
    @Enumerated(EnumType.STRING)
    private EAccademicUnit unit;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parent_id",nullable = true)
    private AccademicUnit parent;
    @OneToMany(mappedBy = "accademicUnit")
    private List<StudentRegistration> studentRegistration;
    @OneToMany(mappedBy = "accademicUnit")
    private List<Cource> cources;




    public AccademicUnit() {
    }

    public AccademicUnit(String code) {
        this.code = code;
    }

    public AccademicUnit(String code, String name, EAccademicUnit unit, AccademicUnit parent, List<StudentRegistration> studentRegistration, List<Cource> cources) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.parent = parent;
        this.studentRegistration = studentRegistration;
        this.cources = cources;
    }

    public List<StudentRegistration> getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(List<StudentRegistration> studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAccademicUnit getUnit() {
        return unit;
    }

    public void setUnit(EAccademicUnit unit) {
        this.unit = unit;
    }

    public AccademicUnit getParent() {
        return parent;
    }

    public void setParent(AccademicUnit parent) {
        this.parent = parent;
    }
}
