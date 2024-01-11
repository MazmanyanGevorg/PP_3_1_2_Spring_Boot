package web.springboot.PP_3_1_2_Spring_Boot.service;


import web.springboot.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}
