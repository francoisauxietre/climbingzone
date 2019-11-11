package com.climbing.zone.repository;

import com.climbing.zone.domain.User;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
        User findByUsername(String userName);
        List<User> findAll();

}
