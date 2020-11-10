package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.TicketKategorieService;
import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "ticketKategorieBean")
@RequestScoped
public class TicketKategorieBean {

    TicketKategorieService service = new TicketKategorieService();

    public List<TicketKategorie> getAllTicketKategorie() {
        return service.getAllTicketKategorie();
    }
}
