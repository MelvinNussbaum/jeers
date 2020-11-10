package ch.bbc.uek223.jeers.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ROLLE")
@NamedQueries({
        @NamedQuery(name = "Rolle.findByPerson", query = "select r from Rolle r join r.personen p where p = :person"),
        @NamedQuery(name = "Rolle.findAll", query = "select r from Rolle r")}
)
public class Rolle extends AbstractBaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    // Rückbeziehung
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "rollen")
    private List<Person> personen = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(List<Person> persons) {
        this.personen = persons;
    }

    public void addPerson(Person person) {
        this.personen.add(person);
    }
}
