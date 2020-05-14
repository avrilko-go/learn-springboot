package com.avrilko.learn.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class BannerItem extends BaseEntity {
    @Id
    private long id;
    private String img;
    private String keyword;
    private short type;
    private Long bannerId;
    private String name;
}
