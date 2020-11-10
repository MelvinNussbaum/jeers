package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.TicketService;
import ch.bbc.uek223.jeers.entities.Ticket;
import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "ticketBean")
@RequestScoped
public class TicketBean {

    private TicketKategorie ticketKategorie;

    TicketService service = new TicketService();

    public List<Ticket> getUnsoldTickets() {
        return service.getUnsoldTickets();
    }

    public TicketKategorie getTicketKategorie() {
        return ticketKategorie;
    }

    public void setTicketKategorie(TicketKategorie ticketKategorie) {
        this.ticketKategorie = ticketKategorie;
    }
}
