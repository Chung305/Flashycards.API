package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return userRepository.findByUsername(username);
        }catch(UsernameNotFoundException e){
            throw new UsernameNotFoundException("Username does not exist", e);
        }

    }
}
