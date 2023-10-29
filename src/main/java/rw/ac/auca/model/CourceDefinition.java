package rw.ac.auca.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
public class CourceDefinition {
    @Id
    private String codeDef;
    private String name;
    private String description;
    @OneToMany(mappedBy = "courceDefinition")
    private List<Cource> cources;

    public CourceDefinition() {
    }

    public CourceDefinition(String codeDef) {
        this.codeDef = codeDef;
    }

    public CourceDefinition(String codeDef, String name, String description, List<Cource> cources) {
        this.codeDef = codeDef;
        this.name = name;
        this.description = description;
        this.cources = cources;
    }

    public List<Cource> getCources() {
        return cources;
    }

    public void setCources(List<Cource> cources) {
        this.cources = cources;
    }

    public String getCodeDef() {
        return codeDef;
    }

    public void setCodeDef(String codeDef) {
        this.codeDef = codeDef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
