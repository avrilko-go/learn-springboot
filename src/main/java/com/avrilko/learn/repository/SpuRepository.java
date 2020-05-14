package com.avrilko.learn.repository;

import com.avrilko.learn.model.Banner;
import com.avrilko.learn.model.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu,Long> {
    Spu findOneById(Long id);
}
