package ch.bbc.uek223.openair.entitytest;

import ch.bbc.uek223.jeers.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import java.math.BigDecimal;
import java.util.List;

public class NamedQueriesTest extends EntityManagerTest {

	@Override
	public void before() throws Exception {
		super.before();

		Person person = new Person();
		person.setName("Ulfirch");
		person.setId(10000L);
		Rolle rolle = new Rolle();
		rolle.setName("Boss");
		person.addRolle(rolle);
		em.persist(new Person());
	}

	@Test
	public void testTicketKategorie() {
		List<TicketKategorie> resultList = em.createNamedQuery("TicketKategorie.findAll", TicketKategorie.class)
				.getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals("Stehplatz", resultList.get(0).getName());
	}

	@Test
	public void testEvent() {
		List<Event> resultList = em.createNamedQuery("Event.findAll", Event.class).getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals("Gurtenfestival", resultList.get(0).getName());
	}

	@Test
	public void testUnverkaufteTickets() {
		List<Ticket> resultList = em.createNamedQuery("Ticket.findUnsold", Ticket.class).getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals(new BigDecimal(150), resultList.get(0).getPreis());
	}

	@Test
	public void testUnverkaufteTicketsProKategorie() {
		Event e = em.find(Event.class, 1L);
		TicketKategorie tk = em.find(TicketKategorie.class, 1L);
		
		List<Ticket> resultList = em.createNamedQuery("Ticket.findUnsoldPerCategory", Ticket.class)
				.setParameter("event", e)
				.setParameter("ticketKategorie", tk)				
				.getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals(new BigDecimal(150), resultList.get(0).getPreis());
	}
	
	@Test
	public void testTotalUnverkaufteTickets() {
		Event e = em.find(Event.class, 1L);
		
		Long resultat = em.createNamedQuery("Ticket.findTotalUnsoldPerEvent", Long.class)
				.setParameter("event", e)
				.getSingleResult();

		Assert.assertEquals(new Long(1), resultat);
	}
	
	@Test
	public void testAnzahlUnverkaufteTickets() {
		
		List<Object[]> resultat = em.createNamedQuery("Ticket.findUnsoldAmount", Object[].class)
				.getResultList();

		Assert.assertEquals(1, resultat.size());
		Assert.assertEquals(1L, resultat.get(0)[0]);
		Assert.assertTrue(resultat.get(0)[1] instanceof Event);
		Assert.assertEquals("Gurtenfestival", ((Event) resultat.get(0)[1]).getName());
	}
	
	@Test
	public void testPerson() {
		List<Person> resultList = em.createNamedQuery("Person.findAll", Person.class).getResultList();

		Assert.assertEquals(2, resultList.size());
		Assert.assertEquals("Admin", resultList.get(0).getName());
		Assert.assertEquals("User", resultList.get(1).getName());
	}
	
	@Test
	public void testRolleProPerson() {
		List<Rolle> resultList = em.createNamedQuery("Rolle.findByPerson", Rolle.class)
				.setParameter("person", em.getReference(Person.class, 1L))
				.getResultList();

		em.find(Person.class, 10000L);

		Assert.assertEquals(2, resultList.size());
		Assert.assertEquals("admin", resultList.get(0).getName());
		Assert.assertEquals("user", resultList.get(1).getName());
	}

	@Test
	public void testRolleAll() {
		List<Rolle> resultList = em.createNamedQuery("Rolle.findAll", Rolle.class).getResultList();

		Assert.assertEquals(2, resultList.size());
	}

	public void testPersonByName() {
		List<Person> resultList = em.createNamedQuery("Person.findByName", Person.class)
				.setParameter("name", "user").getResultList();

		Assert.assertEquals("user", resultList.get(0).getName());
	}
}
