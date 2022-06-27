package org.example.eshop.jpa.user.repository;


import org.example.eshop.jpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u Join fetch u.authorities where u.email = :email")
    Optional<User> findUserByEmailWithAuthorities(String email);

    @Query("select u from User u where u.email= :email")
    User findUserByEmail(String email);
}