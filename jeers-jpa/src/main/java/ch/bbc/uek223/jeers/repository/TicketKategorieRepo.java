package ch.bbc.uek223.jeers.repository;

import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TicketKategorieRepo {

    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeers");

    public TicketKategorieRepo() {
        this.em = emf.createEntityManager();
    }

    public TicketKategorie getTicketKategorieById(Long id) {
        return em.find(TicketKategorie.class, id);
    }

    public List<TicketKategorie> getAllTicketKategorie() {
        return em.createNamedQuery("TicketKategorie.findAll", TicketKategorie.class).getResultList();
    }

    public void addTicketKategorie(TicketKategorie ticketKategorie) {
        em.persist(ticketKategorie);
        em.flush();
    }

    public void mergeTicketKategorie(TicketKategorie ticketKategorie) {
        em.merge(ticketKategorie);
        em.flush();
    }

    public void deleteTicketKategorie(TicketKategorie ticketKategorie) {
        em.remove(ticketKategorie);
        em.flush();
    }
}
