package com.vastika.ud.service;

import com.vastika.ud.model.Role;
import com.vastika.ud.model.User;
import com.vastika.ud.repository.UserRepository;
import com.vastika.ud.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
}
