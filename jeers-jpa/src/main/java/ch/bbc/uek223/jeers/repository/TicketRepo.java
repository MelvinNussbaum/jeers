package ch.bbc.uek223.jeers.repository;

import ch.bbc.uek223.jeers.entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TicketRepo {

    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeers");

    public TicketRepo() {
        this.em = emf.createEntityManager();
    }

    public Ticket getTicketById(Long id) {
        return em.find(Ticket.class, id);
    }

    public void addTicket(Ticket ticket) {
        em.persist(ticket);
        em.flush();
    }

    public void mergeTicket(Ticket ticket) {
        em.merge(ticket);
        em.flush();
    }

    public void deleteTicket(Ticket ticket) {
        em.remove(ticket);
        em.flush();
    }

    public List<Ticket> getUnsoldTickets() {
        return em.createNamedQuery("Ticket.findUnsold", Ticket.class).getResultList();
    }
}
