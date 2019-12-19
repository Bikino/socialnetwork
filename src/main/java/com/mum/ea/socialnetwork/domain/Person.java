package com.mum.ea.socialnetwork.domain;

import lombok.Data;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;



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
    private String status;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_ROLESS",
            joinColumns =  @JoinColumn(name ="USER_ID"),inverseJoinColumns= @JoinColumn(name="ROLE_ID"))
    private Set<Role> roles = new HashSet<>();




}
