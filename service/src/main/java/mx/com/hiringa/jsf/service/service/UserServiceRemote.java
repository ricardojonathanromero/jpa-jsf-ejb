package mx.com.hiringa.jsf.service.service;

import jakarta.ejb.Remote;
import mx.com.hiringa.jsf.service.domain.User;

import java.util.List;

@Remote public interface UserServiceRemote {
    List<User> ListUsers();
    User FindUserById(User user);
    void AddUser(User user);
    void ModifyUser(User user);
    void DeleteUser(User user);
}
