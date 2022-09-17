package mx.com.hiringa.jsf.service.service;

import jakarta.annotation.Resource;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import mx.com.hiringa.jsf.service.dao.PersonDao;
import mx.com.hiringa.jsf.service.domain.Person;

import java.util.List;

@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService {
    @Inject PersonDao repo;

    @Resource private SessionContext context;

    @Override
    public List<Person> ListPersons() { return repo.findAll(); }

    @Override
    public Person FindPersonById(Person person) { return repo.findPersonById(person); }

    @Override
    public Person FindPersonByEmail(Person person) {
        return repo.findPersonByEmail(person);
    }

    @Override
    public void AddPerson(Person person) {
        repo.createPerson(person);
    }

    @Override
    public void ModifyPerson(Person person) {
        try {
            repo.updatePerson(person);
        } catch (Throwable t) {
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void DeletePerson(Person person) {
        repo.deletePerson(person);
    }
}
