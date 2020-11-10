package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.PersonService;
import ch.bbc.uek223.jeers.entities.Person;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "helloBean")
@RequestScoped
public class HelloWorldBean {

	PersonService service = new PersonService();

	public String getGreeting() {
		return service.getPersonByMail("admin@jeers.ch").getName();
	}

	public List<Person> getAllPersons() {
		return service.getAllPersons();
	}
}