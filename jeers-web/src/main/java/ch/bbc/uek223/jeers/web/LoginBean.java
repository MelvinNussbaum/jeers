package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.PersonService;
import ch.bbc.uek223.jeers.entities.Person;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

    private PersonService service = new PersonService();

    private String email;
    private String password;

    public String login() {
        Person user = service.getPersonByMail(email);
        if (!user.getPasswort().equals(password)) {
            return "loginerror";
        }
        return "loginsuccess";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
