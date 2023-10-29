package rw.ac.auca.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class StudentCource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdCId;
    private BigDecimal results;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentRegistration stdReg;
    @ManyToOne
    @JoinColumn(name = "courseCode")
    private Cource cource;

    public StudentCource() {
    }

    public Integer getStdCId() {
        return stdCId;
    }

    public void setStdCId(Integer stdCId) {
        this.stdCId = stdCId;
    }

    public StudentCource(Integer stdCId, BigDecimal results, StudentRegistration stdReg, Cource cource) {
        this.stdCId = stdCId;

        this.results = results;
        this.stdReg = stdReg;
        this.cource = cource;
    }


    public BigDecimal getResults() {
        return results;
    }

    public void setResults(BigDecimal results) {
        this.results = results;
    }

    public StudentRegistration getStdReg() {
        return stdReg;
    }

    public void setStdReg(StudentRegistration stdReg) {
        this.stdReg = stdReg;
    }

    public Cource getCource() {
        return cource;
    }

    public void setCource(Cource cource) {
        this.cource = cource;
    }
}
