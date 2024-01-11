package web.springboot.PP_3_1_2_Spring_Boot.dao;


import web.springboot.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUserById(Long userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

}
