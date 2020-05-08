package com.avrilko.learn.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class SchoolDTO {
    @Length(min = 2,message = "hahahh1")
    private String schoolName;
}
