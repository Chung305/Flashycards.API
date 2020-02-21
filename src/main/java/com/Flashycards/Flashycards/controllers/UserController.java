package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.models.dao.AuthenticationRequest;
import com.Flashycards.Flashycards.models.dao.AuthenticationResponse;
import com.Flashycards.Flashycards.models.dao.RegisterDAO;
import com.Flashycards.Flashycards.service.UserService;
import com.Flashycards.Flashycards.utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtUtil jwtTokenUtil;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserService userDetailsService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

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
     */
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterDAO newUser){
            return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
    }
}
