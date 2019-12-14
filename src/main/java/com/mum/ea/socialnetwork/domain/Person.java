package com.mum.ea.socialnetwork.domain;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String addressState;
    private String addressCity;
    private String bio;
    @Lob
    private byte[] profilePic;
    private String profilePath;
    private String username;
    private String password;
}
