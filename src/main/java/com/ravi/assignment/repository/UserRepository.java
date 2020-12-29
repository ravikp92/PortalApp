package com.ravi.assignment.repository;

import com.ravi.assignment.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {}
