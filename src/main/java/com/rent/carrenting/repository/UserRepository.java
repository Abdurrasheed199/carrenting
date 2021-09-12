package com.rent.carrenting.repository;

import com.rent.carrenting.models.Role;
import com.rent.carrenting.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<Role> findAllByAccountLockedFalse();
    boolean   existsByUsername(String username);
}

