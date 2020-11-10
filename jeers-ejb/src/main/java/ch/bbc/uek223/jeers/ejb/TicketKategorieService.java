package ch.bbc.uek223.jeers.ejb;

import ch.bbc.uek223.jeers.entities.Ticket;
import ch.bbc.uek223.jeers.entities.TicketKategorie;
import ch.bbc.uek223.jeers.repository.TicketKategorieRepo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@LocalBean
@Stateless
public class TicketKategorieService {

    private TicketKategorieRepo repo = new TicketKategorieRepo();

    public TicketKategorie getTicketKategorieById(Long id){
        return repo.getTicketKategorieById(id);
    }

    public List<TicketKategorie> getAllTicketKategorie() {
        return repo.getAllTicketKategorie();
    }

    public void addTicketKategorie(TicketKategorie ticketKategorie) {
        repo.addTicketKategorie(ticketKategorie);
    }

    public void mergeTicketKategorie(TicketKategorie ticketKategorie) {
        repo.mergeTicketKategorie(ticketKategorie);
    }

    public void deleteTicketKategorie(TicketKategorie ticketKategorie) {
        repo.deleteTicketKategorie(ticketKategorie);
    }
}

