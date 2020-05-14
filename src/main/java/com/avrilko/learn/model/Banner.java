package com.avrilko.learn.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Banner extends BaseEntity {
    @Id
    private long id;
    private String name;
    private String description;
    private String title;
    private String img;

    @OneToMany(fetch = FetchType.LAZY) // 懒加载
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
