package com.avrilko.learn.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {
    String message() default "password are not equal";
    int min() default 2;
    int max() default 20;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
