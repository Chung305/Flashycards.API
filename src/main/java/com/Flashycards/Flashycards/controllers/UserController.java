package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.dao.AuthenticationRequest;
import com.Flashycards.Flashycards.dao.AuthenticationResponse;
import com.Flashycards.Flashycards.dao.RegisterAndUpdateDAO;
import com.Flashycards.Flashycards.service.UserService;
import com.Flashycards.Flashycards.utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    /**
     * @param authenticationRequest with a (username, password)
     * @return AuthenticationResponse with a JWToken
     * @throws BadCredentialsException
     */
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }
        catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    /**
     * Registration
     * Access to all users
     */
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterAndUpdateDAO newUser){
            return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
    }

    /**
     * PUT Request for updating users
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> userUpdate(@RequestBody RegisterAndUpdateDAO userUpdate, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(userUpdate, id), HttpStatus.OK);
    }

    /**
     *  ADMIN use only for changing authority of a user
     * @param id of the user
     * @return
     */
    @PutMapping("/update/authority/{id}")
    public ResponseEntity<User> userAuthorityUpdate (@PathVariable Long id){
        return new ResponseEntity<>(userService.userAuthorityUpdate(id), HttpStatus.OK);
    }

    /**
     * GET request methods =====================================
     */
    @GetMapping("/all-users")
    public ResponseEntity<List<User>> findAllUsers (){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all-users/{role}")
    public ResponseEntity<List<User>> findAllByRole(@PathVariable String role){
        return new ResponseEntity<>(userService.findAllByRole(role), HttpStatus.OK);
    }

    /**
     * DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }



}
