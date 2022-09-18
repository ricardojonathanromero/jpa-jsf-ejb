package mx.com.hiringa.jsf.service.web;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.com.hiringa.jsf.service.domain.Person;
import mx.com.hiringa.jsf.service.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import java.util.List;

@Named("beanPerson") @RequestScoped public class BeanPerson {
    static Logger log = LogManager.getRootLogger();

    @Inject private PersonService personService;

    private Person selectedPerson;

    List<Person> people;

    public BeanPerson(){ log.info("initializing bean person object..."); }

    @PostConstruct public void initializer(){
        // initialize variables
        this.people = personService.ListPersons();
        log.info("people => " + this.people);
        selectedPerson = new Person();
    }

    public void editListener(RowEditEvent event) throws ValidatorException {
        log.info("event edit start");
        Person person = (Person) event.getObject();
        log.info("person modified => " + person);
        personService.ModifyPerson(person);
    }

    public void addPerson() throws ValidatorException {
        log.info("adding person => " + selectedPerson);
        personService.AddPerson(selectedPerson);
        this.people.add(selectedPerson);
        this.selectedPerson = null;
    }

    public void removePerson() throws ValidatorException {
        log.info("removing person => " + selectedPerson);
        personService.DeletePerson(selectedPerson);
        this.people.remove(selectedPerson);
        this.selectedPerson = null;
    }

    public void resetSelectedPerson() { this.selectedPerson = new Person(); }

    public Person getSelectedPerson() {return selectedPerson;}

    public void setSelectedPerson(Person selectedPerson) {this.selectedPerson = selectedPerson;}

    public List<Person> getPeople() { return people; }

    public void setPeople(List<Person> people) { this.people = people; }
}
