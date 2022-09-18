package mx.com.hiringa.jsf.service.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.com.hiringa.jsf.service.domain.Person;

import java.util.List;

@Stateless public class PersonDaoImpl implements PersonDao {
    @PersistenceContext(name = "persistence") EntityManager em;

    @Override public List<Person> findAll() { return em.createNamedQuery("FindAllPersons").getResultList(); }

    @Override public Person findPersonById(Person person) { return em.find(Person.class, person.getId()); }

    @Override
    public Person findPersonByEmail(Person person) {
        return (Person) em.
                createNamedQuery("FindPersonByEmail").
                setParameter("email", person.getEmail()).getSingleResult();
    }

    @Override public void createPerson(Person person) { em.persist(person); }

    @Override public void updatePerson(Person person) { em.merge(person); }

    @Override public void deletePerson(Person person) { em.remove(em.merge(person)); }
}
