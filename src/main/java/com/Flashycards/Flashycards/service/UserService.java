package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.exceptions.RequestNotProcessedException;
import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.models.dao.RegisterAndUpdateDAO;
import com.Flashycards.Flashycards.models.enums.Roles;
import com.Flashycards.Flashycards.repositories.UserRepository;
import com.Flashycards.Flashycards.utilities.JwtUtil;
import com.Flashycards.Flashycards.utilities.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = findByUsername(username);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
        }catch(UsernameNotFoundException e){
            throw new UsernameNotFoundException("Username does not exist", e);
        }

    }

    public String createUser(RegisterAndUpdateDAO newUser) {
        User user = new User();

        if(!userRepository.existsByUsernameAndEmail(newUser.getUsername(), newUser.getEmail())
                && Validators.validatePassword(newUser.getPassword())
                && newUser.getPassword().equals(newUser.getConfirmPassword())){

            user.setEmail(newUser.getEmail());
            user.setUsername(newUser.getUsername());
            user.setPassword(passwordEncoder.encode(newUser.getPassword()));
            user.setEnabled(true);
            user.setRoles(Roles.MEMBER.toString());
            user.setRegister_date(LocalDate.now());
            userRepository.save(user);

            return "Account Created";
        }else{
            throw new RequestNotProcessedException("Username or Email already exists", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
    public String updateUser(RegisterAndUpdateDAO userUpdate, Long id) {
        User user = findById(id);

        if(userRepository.existsByUsernameAndEmail(userUpdate.getUsername(), userUpdate.getEmail())
                && Validators.validatePassword(userUpdate.getPassword())
                && userUpdate.getPassword().equals(userUpdate.getConfirmPassword())){

            user.setEmail(userUpdate.getEmail());
            user.setUsername(userUpdate.getUsername());
            user.setPassword(passwordEncoder.encode(userUpdate.getPassword()));
            userRepository.save(user);

            UserDetails updatedDetails = loadUserByUsername(user.getUsername());

            return new JwtUtil().generateToken(updatedDetails);
        }else{
            throw new RequestNotProcessedException("Username or Email already exists", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    public User userAuthorityUpdate(Long id) {
        User user = findById(id);

        if(user.getRoles().equals(Roles.MEMBER.toString()))
            user.setRoles(Roles.ADMIN.toString());
        else
            user.setRoles(Roles.MEMBER.toString());

        return userRepository.save(user);
    }

    public User findByUsername (String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findAllByRole(String role) {
        return userRepository.findAllByRoles(role);
    }

    public User findById(Long id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else
            return null;
    }

    public Boolean delete(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
