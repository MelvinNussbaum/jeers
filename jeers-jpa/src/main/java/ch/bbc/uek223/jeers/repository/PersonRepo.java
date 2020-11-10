package ch.bbc.uek223.jeers.repository;

import ch.bbc.uek223.jeers.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonRepo {

    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeers");

    public PersonRepo() {
        this.em = emf.createEntityManager();
    }

    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }

    public Person getPersonByMail(String email) {
        return em.createNamedQuery("Person.findByMail", Person.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public List<Person> getAllPersons() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    public void addPerson(Person person) {
        em.persist(person);
        em.flush();
    }

    public void mergePerson(Person person) {
        em.merge(person);
        em.flush();
    }

    public void deletePerson(Person person) {
        em.remove(person);
        em.flush();
    }
}
