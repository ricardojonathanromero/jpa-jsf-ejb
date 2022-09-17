package mx.com.hiringa.jsf.service.service;

import jakarta.ejb.Local;
import mx.com.hiringa.jsf.service.domain.Person;

import java.util.List;

@Local public interface PersonService {
    List<Person> ListPersons();
    Person FindPersonById(Person person);
    Person FindPersonByEmail(Person person);
    void AddPerson(Person person);
    void ModifyPerson(Person person);
    void DeletePerson(Person person);
}
