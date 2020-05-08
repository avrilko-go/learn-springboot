package com.avrilko.learn.api.v1;

import com.avrilko.learn.dto.PersonDTO;
import com.avrilko.learn.exception.http.ForbiddenException;
import com.avrilko.learn.exception.http.HttpException;
import com.avrilko.learn.exception.http.NotFoundException;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@Validated
@RestController
@RequestMapping("/banner")
public class BannerController {
    @PostMapping("/test/{id}")
    public String test(@PathVariable @Range(min = 1,max = 10,message = "hahhahah1") Integer id, @RequestParam String name, @RequestBody @Validated PersonDTO personDTO) {
        System.out.println(id);
        System.out.println(name);
        throw new ForbiddenException(10001);
    }
}
