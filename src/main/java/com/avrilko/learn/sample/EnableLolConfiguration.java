package com.avrilko.learn.sample;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LolConfigurationSelector.class)
public @interface EnableLolConfiguration {
}
