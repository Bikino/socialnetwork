package com.mum.ea.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @Lob
    private byte[] profilePicture;
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Address address;

}
