package com.avrilko.learn;

import com.avrilko.learn.sample.EnableLolConfiguration;
import com.avrilko.learn.sample.HeroConfiguration;
import com.avrilko.learn.sample.ISkill;
import com.avrilko.learn.sample.LolConfigurationSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableLolConfiguration
public class LolApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(LolApplication.class).web(WebApplicationType.NONE).run(args);

        ISkill skill = (ISkill) context.getBean("daoMei");
        skill.r();
    }

}
