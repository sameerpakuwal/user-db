package com.vastika.ud.service;

import com.vastika.ud.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUser();

    User getUserByEmail(String email);
    void updateResetPassword(String token, String email) throws UserNotFoundException;
    User getByResetPasswordToken(String token);
    void updatePassword(User user, String newPassword);

}

