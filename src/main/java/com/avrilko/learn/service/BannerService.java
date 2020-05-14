package com.avrilko.learn.service;

import com.avrilko.learn.model.Banner;
import com.avrilko.learn.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    public Banner getByName(String name) {
        return this.bannerRepository.findOneByName(name);
    }
}
