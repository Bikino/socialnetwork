package com.mum.ea.socialnetwork.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Advertisment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Lob
    private byte[] Banner;
    private String BannerPath;
}
