package com.avrilko.learn.service;

import com.avrilko.learn.model.Spu;
import com.avrilko.learn.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;

    public Spu getSpu(Long id) {
        return this.spuRepository.findOneById(id);
    }

    public List<Spu> getLatestPagingSpu() {
        return this.spuRepository.findAll();
    }
}
