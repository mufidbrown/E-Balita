package com.magang.plnicon.repository;

import com.magang.plnicon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * Repository interface for accessing and managing User entities in the database.
 * This interface extends JpaRepository to provide basic CRUD operations for User entities.
 */
public interface UserRepository  extends JpaRepository <User, Long>{


    boolean existsByEmail(String email);


    Optional<User> findByUsername(String username);


    Optional<User> findByEmail(String email);

}
