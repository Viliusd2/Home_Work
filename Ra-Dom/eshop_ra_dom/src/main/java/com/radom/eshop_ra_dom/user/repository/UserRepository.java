package com.radom.eshop_ra_dom.user.repository;

import com.radom.eshop_ra_dom.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
