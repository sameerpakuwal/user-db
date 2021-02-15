package com.vastika.ud.repository;

import com.vastika.ud.model.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUser();
    User getUserByUserName(String username);
    User getUserByEmail(String email);
    public User findByResetPasswordToken(String token);

}
