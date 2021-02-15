package com.vastika.ud.service;
import com.vastika.ud.model.User;
import com.vastika.ud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Collection;

@Transactional
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.getUserByUserName(username);
    if (user == null){

        throw  new UsernameNotFoundException("user not found");
    }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,  true,true,true, getAuthorities(user.getRole().getRoleName()));
    }



    public Collection<SimpleGrantedAuthority> getAuthorities(String roleName){

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleName));
        return authorities;
    }

}
