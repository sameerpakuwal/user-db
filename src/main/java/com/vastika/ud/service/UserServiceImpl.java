package com.vastika.ud.service;

import com.vastika.ud.model.Role;
import com.vastika.ud.model.User;
import com.vastika.ud.repository.UserRepository;
import com.vastika.ud.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
         String encodedPass = PasswordEncoderUtil.encodePassword(user.getPassword());
         user.setPassword(encodedPass);

         Role role = new Role();
         role.setId(2);
         role.setRoleName("ROLE_USER");
         user.setRole(role);
         userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        String encodedPass = PasswordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(encodedPass);

        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public void updateResetPassword(String token, String email) {
        User user = userRepository.getUserByEmail(email);

        if (user != null) {

            user.setResetPasswordToken(token);
            userRepository.updateUser(user);

        }else {
            throw new UsernameNotFoundException("No User found with email!!" +email);
        }
    }

    @Override
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.updateUser(user);
    }
}
