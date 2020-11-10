package ch.bbc.uek223.jeers.repository;

import ch.bbc.uek223.jeers.entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EventRepo {

    @PersistenceContext(unitName = "jeers")
    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeers");

    public EventRepo(EntityManager em) {
        this.em = em;
    }

    public Event getEventById(Long id) {
        return em.find(Event.class, id);
    }

    public void addEvent(Event event) {
        em.persist(event);
        em.flush();
    }

    public void mergeEvent(Event event) {
        em.merge(event);
        em.flush();
    }

    public void deleteEvent(Event event) {
        em.remove(event);
        em.flush();
    }
}
