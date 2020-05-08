package com.avrilko.learn.sample.hero;

import com.avrilko.learn.sample.ISkill;
import org.springframework.stereotype.Component;

public class DaoMei implements ISkill {
    @Override
    public void r() {
        System.out.println("刀妹开大");
    }
}
