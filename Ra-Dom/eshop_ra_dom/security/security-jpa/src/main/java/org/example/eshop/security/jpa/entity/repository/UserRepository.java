package org.example.eshop.security.jpa.entity.repository;


import org.example.eshop.security.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u Join fetch u.authorities where u.email = :email")
    Optional<User> findUserByEmailWithAuthorities(String email);

}
