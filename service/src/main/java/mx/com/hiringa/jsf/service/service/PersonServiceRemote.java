package mx.com.hiringa.jsf.service.service;

import jakarta.ejb.Remote;
import mx.com.hiringa.jsf.service.domain.Person;

import java.util.List;

@Remote public interface PersonServiceRemote {
    List<Person> ListPersons();
    Person FindPersonById(Person person);
    Person FindPersonByEmail(Person person);
    void AddPerson(Person person);
    void ModifyPerson(Person person);
    void DeletePerson(Person person);
}
