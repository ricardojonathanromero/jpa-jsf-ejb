package mx.com.hiringa.jsf.service.dao;

import mx.com.hiringa.jsf.service.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
