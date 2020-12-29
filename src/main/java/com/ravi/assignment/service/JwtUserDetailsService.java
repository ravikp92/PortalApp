package com.ravi.assignment.service;

import com.ravi.assignment.model.UserDTO;
import com.ravi.assignment.model.UserDao;
import com.ravi.assignment.repository.UserDaoRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
  @Autowired
  private UserDaoRepository userDao;
  
  @Autowired
  private PasswordEncoder bcryptEncoder;
  
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDao user = this.userDao.findByUsername(username);
    if (user == null)
      throw new UsernameNotFoundException("User not found with username: " + username); 
    return (UserDetails)new User(user.getUsername(), user.getPassword(), new ArrayList<>());
  }
  
  public UserDao save(UserDTO user) {
    UserDao newUser = new UserDao();
    newUser.setUsername(user.getUsername());
    newUser.setPassword(this.bcryptEncoder.encode(user.getPassword()));
    return (UserDao)this.userDao.save(newUser);
  }
}
