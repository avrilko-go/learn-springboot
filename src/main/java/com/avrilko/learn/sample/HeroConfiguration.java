package com.avrilko.learn.sample;

import com.avrilko.learn.sample.hero.DaoMei;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    @Bean
    public ISkill daoMei() {
        return new DaoMei();
    }

}
