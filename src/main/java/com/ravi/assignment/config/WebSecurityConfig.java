package com.ravi.assignment.config;

import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  
  @Autowired
  private UserDetailsService jwtUserDetailsService;
  
  @Autowired
  private JwtRequestFilter jwtRequestFilter;
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(this.jwtUserDetailsService).passwordEncoder(passwordEncoder());
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return (PasswordEncoder)new BCryptPasswordEncoder();
  }
  
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
  
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    ((HttpSecurity)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity)httpSecurity.csrf().disable())
      
      .authorizeRequests().antMatchers(new String[] { "/authenticate", "/register", "/h2-console/**", "/v2/api-docs/**", "/swagger-ui/**", "/swagger-resources/**", 
          "/swagger-ui.html", "/webjars/**" })).permitAll()
      
      .anyRequest()).authenticated().and())
      
      .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and()).sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    httpSecurity.headers().frameOptions().disable();
    httpSecurity.addFilterBefore((Filter)this.jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
