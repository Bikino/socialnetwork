package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Advert;

import java.util.List;

public interface AdvertService {
    void saveAdvert(Advert advertisment);
    List<Advert> getAllAdvertisment();

    Advert findAdvertByCity(String city);
}
