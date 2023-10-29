package rw.ac.auca.model;

import jakarta.persistence.*;
import rw.ac.auca.model.enums.EQualificatio;

import java.util.List;

@Entity
public class Teacher {
    @Id
    private String tCode;
    private String name;
    private String email;
    private String phone;
    private String teacherType;
    @Enumerated(EnumType.STRING)
    @Column(name = "qualification")
    private EQualificatio qualification;
    @OneToMany(mappedBy = "treTeacher")
    private List<Cource> cources;


    public Teacher() {

    }

    public Teacher(String tCode) {
        this.tCode = tCode;
    }

    public Teacher(String tCode, String name, String email, String phone, String teacherType, EQualificatio qualification, List<Cource> cources) {
        this.tCode = tCode;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.teacherType = teacherType;
        this.qualification = qualification;
        this.cources = cources;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public List<Cource> getCources() {
        return cources;
    }

    public void setCources(List<Cource> cources) {
        this.cources = cources;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EQualificatio getQualification() {
        return qualification;
    }

    public void setQualification(EQualificatio qualification) {
        this.qualification = qualification;
    }
}
