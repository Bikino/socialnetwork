package com.mum.ea.socialnetwork.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;


//    private String email;
//    private String phoneNumber;
//    private String profilePicture;
//    private String username;
//    private String password;
//    @OneToOne(cascade = CascadeType.ALL)
//    private Address address;
}
