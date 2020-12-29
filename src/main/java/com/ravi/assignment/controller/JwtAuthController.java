package com.ravi.assignment.controller;

import com.ravi.assignment.config.JwtTokenUtil;
import com.ravi.assignment.model.JwtRequest;
import com.ravi.assignment.model.JwtResponse;
import com.ravi.assignment.model.UserDTO;
import com.ravi.assignment.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthController {
	
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  
  @Autowired
  private JwtUserDetailsService userDetailsService;
  
  @PostMapping({"/authenticate"})
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    String token = this.jwtTokenUtil.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token));
  }
  
  @PostMapping({"/register"})
  public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
    return ResponseEntity.ok(this.userDetailsService.save(user));
  }
  
  private void authenticate(String username, String password) throws Exception {
    try {
      this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    } 
  }
}
