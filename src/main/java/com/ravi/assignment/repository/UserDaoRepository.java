package com.ravi.assignment.repository;

import com.ravi.assignment.model.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends CrudRepository<UserDao, Integer> {
  UserDao findByUsername(String paramString);
}