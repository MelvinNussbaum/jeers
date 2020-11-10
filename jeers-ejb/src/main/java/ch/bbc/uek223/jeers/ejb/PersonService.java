package ch.bbc.uek223.jeers.ejb;

import ch.bbc.uek223.jeers.entities.Person;
import ch.bbc.uek223.jeers.repository.PersonRepo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@LocalBean
@Stateless
public class PersonService {

    private PersonRepo repo = new PersonRepo();

    public Person getPersonById(Long id) {
        return repo.getPersonById(id);
    }

    public Person getPersonByMail(String email) {
        return repo.getPersonByMail(email);
    }

    public List<Person> getAllPersons() {
        return repo.getAllPersons();
    }

    public void addPerson(Person person) {
        repo.addPerson(person);
    }

    public void mergePerson(Person person) {
        repo.mergePerson(person);
    }

    public void deletePerson(Person person) {
        repo.deletePerson(person);
    }


}

