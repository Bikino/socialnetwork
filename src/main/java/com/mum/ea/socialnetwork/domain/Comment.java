package com.mum.ea.socialnetwork.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String commentText;

    @ManyToOne
    private Post post;


}
