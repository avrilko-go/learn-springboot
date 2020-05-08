package com.avrilko.learn.api.v1;

import com.avrilko.learn.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/banner")
public class BannerController {
//    @PostMapping("/test/{id}")
//    public PersonDTO test(@PathVariable @Range(min = 1,max = 10,message = "hahhahah1") Integer id, @RequestBody @Validated PersonDTO personDTO) {
//        return personDTO;
//    }

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public void getByName(@PathVariable @NotBlank String name) {
        this.bannerService.getByName(name);
    }
}
