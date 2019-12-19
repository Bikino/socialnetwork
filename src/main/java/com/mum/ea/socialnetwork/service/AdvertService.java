package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Advert;

import java.util.List;

public interface AdvertService {
    public void saveAdvert(Advert advertisment);
    public List<Advert> getAllAdvertisment();

    public Advert findAdvertByCity(String city);
}
