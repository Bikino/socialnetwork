package com.mum.ea.socialnetwork.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    private byte[] Banner;
    private String BannerPath;
}
