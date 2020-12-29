package com.ravi.assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ravi.assignment.service.AuditorAwareImpl;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PatientPortalAppApplication {
  public static void main(String[] args) {
    SpringApplication.run(PatientPortalAppApplication.class, args);
  }
  
  @Bean
  public AuditorAware<String> auditorAware() {
      return new AuditorAwareImpl();
  }
}
