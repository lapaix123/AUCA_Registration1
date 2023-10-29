package rw.ac.auca.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Cource {
    @Id
    private String courseCode;
    private Integer credit;
    @ManyToOne
    @JoinColumn( name = "codeDef")
    private CourceDefinition courceDefinition;
    @ManyToOne
    @JoinColumn(name = "tId")
    private Teacher treTeacher;
    @ManyToOne
    @JoinColumn(name = "sId")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "code")
    private AccademicUnit accademicUnit;


    public Cource() {
    }

    public Cource(String courseCode) {
        this.courseCode = courseCode;
    }

    public Cource(String courseCode, Integer credit, CourceDefinition courceDefinition, Teacher treTeacher, Semester semester, AccademicUnit accademicUnit) {
        this.courseCode = courseCode;
        this.credit = credit;
        this.courceDefinition = courceDefinition;
        this.treTeacher = treTeacher;
        this.semester = semester;
        this.accademicUnit = accademicUnit;
    }

    public AccademicUnit getAccademicUnit() {
        return accademicUnit;
    }

    public void setAccademicUnit(AccademicUnit accademicUnit) {
        this.accademicUnit = accademicUnit;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public CourceDefinition getCourceDefinition() {
        return courceDefinition;
    }

    public void setCourceDefinition(CourceDefinition courceDefinition) {
        this.courceDefinition = courceDefinition;
    }

    public Teacher getTreTeacher() {
        return treTeacher;
    }

    public void setTreTeacher(Teacher treTeacher) {
        this.treTeacher = treTeacher;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
