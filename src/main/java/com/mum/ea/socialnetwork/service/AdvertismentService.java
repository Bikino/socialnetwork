package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Advertisment;

import java.util.List;

public interface AdvertismentService {
    public void saveAdvertisment(Advertisment advertisment);
    public List<Advertisment> getAllAdvertisment();
}
