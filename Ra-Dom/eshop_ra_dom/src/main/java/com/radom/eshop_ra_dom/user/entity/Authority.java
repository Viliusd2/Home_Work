package com.radom.eshop_ra_dom.user.entity;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
