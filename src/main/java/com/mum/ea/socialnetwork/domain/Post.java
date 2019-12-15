package com.mum.ea.socialnetwork.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long postId;
    private String postText;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    @ManyToOne
    private Person person;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Lob
    private byte[] postPicture;

    private String postPhoto;

    private String status;

}
