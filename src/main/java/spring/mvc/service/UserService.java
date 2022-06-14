package spring.mvc.service;

import spring.mvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(Long id);
    void editUser(User user);
    User getUserById(Long id);
}
