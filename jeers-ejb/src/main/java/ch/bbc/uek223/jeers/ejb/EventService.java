package ch.bbc.uek223.jeers.ejb;

import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.repository.EventRepo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class EventService {

    private EventRepo repo;

    public Event getEventById(Long id){
        return repo.getEventById(id);
    }

    public void addEvent(Event event) {
        repo.addEvent(event);
    }

    public void mergeEvent(Event event) {
        repo.addEvent(event);
    }

    public void deleteEvent(Event event) {
        repo.deleteEvent(event);
    }
}

