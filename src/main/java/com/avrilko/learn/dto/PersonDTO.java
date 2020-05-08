package com.avrilko.learn.dto;

import com.avrilko.learn.validators.PasswordEqual;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

@Builder
@Getter
@PasswordEqual
public class PersonDTO {
    @Length(min = 1,max = 10,message = "名称太长了")
    private String name;
    private Integer age;

    @Valid
    private SchoolDTO schoolDTO;

    private String password1;
    private String password2;
}

// 数据传输对象
