package ch.bbc.uek223.jeers.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="PERSON")
@NamedQueries({
	@NamedQuery(name = "Person.findAll", query = "select p from Person p order by p.name"),
	@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name = :name"),
	@NamedQuery(name = "Person.findByMail", query = "select p from Person p where p.email = :email")
})
public class Person extends AbstractBaseEntity {

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "VORNAME", nullable = false)
	private String vorname;

	@Column(name = "ADRESSE", nullable = false)
	private String adresse;

	@Column(name = "ORT", nullable = false)
	private String ort;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column(name = "PASSWORT")
	private String passwort;

	// Rückbeziehung
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="PERSON_ROLLE",
		joinColumns=@JoinColumn(name="PERSON_FK", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ROLLE_FK", referencedColumnName="ID")	)
	private List<Rolle> rollen = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rolle> getRollen() {
		return rollen;
	}

	public void setRollen(List<Rolle> rollen) {
		this.rollen = rollen;
	}

	public void addRolle(Rolle rolle) {
		this.rollen.add(rolle);
	}

	public void revokeRolle(Rolle rolle) {
		this.rollen.remove(rolle);
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
}
