package com.mum.ea.socialnetwork.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class user_relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int user_id_1;
    int user_id_2;
    int action_initiated;
    int status; //could be 1-pending,2-accepted,3-declined or 4-blocked/
}
