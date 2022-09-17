package mx.com.hiringa.jsf.service.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.com.hiringa.jsf.service.domain.User;

import java.util.List;

@SuppressWarnings("unchecked")
@Stateless
public class UserDaoImpl implements UserDao {
    @PersistenceContext(name = "persistence")
    EntityManager em;

    @Override
    public List<User> findAll() { return em.createNamedQuery("FindAllUsers").getResultList(); }

    @Override
    public void createUser(User user) { em.persist(user); }

    @Override
    public void updateUser(User user) { em.merge(user); }

    @Override
    public void deleteUser(User user) { em.remove(em.merge(user)); }
}
