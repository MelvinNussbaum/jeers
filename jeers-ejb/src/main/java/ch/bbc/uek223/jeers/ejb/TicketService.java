package ch.bbc.uek223.jeers.ejb;

import ch.bbc.uek223.jeers.entities.Person;
import ch.bbc.uek223.jeers.entities.Ticket;
import ch.bbc.uek223.jeers.repository.TicketRepo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@LocalBean
@Stateless
public class TicketService {

    private TicketRepo repo = new TicketRepo();

    public Ticket getTicketById(Long id) {
        return repo.getTicketById(id);
    }

    public List<Ticket> getUnsoldTickets() {
        return repo.getUnsoldTickets();
    }

    public void addTicket(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public void mergeTicket(Ticket ticket) {
        repo.mergeTicket(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        repo.deleteTicket(ticket);
    }

    public void buyTicket(Ticket ticket, Person buyer) {
        ticket.setKaeufer(buyer);
        this.mergeTicket(ticket);
    }
}

