package org.example.eshop.jpa.user.repository;


import org.example.eshop.jpa.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
