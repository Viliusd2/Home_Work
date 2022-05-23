package com.radom.eshop_ra_dom.user.entity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name;
    }
}
