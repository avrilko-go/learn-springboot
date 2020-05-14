package com.avrilko.learn.api.v1;

import com.avrilko.learn.exception.http.NotFoundException;
import com.avrilko.learn.model.Spu;
import com.avrilko.learn.service.SpuService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive long id) {
        Spu spu =  this.spuService.getSpu(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/latest")
    public List<Spu> getLatestSpuList(){
        return this.spuService.getLatestPagingSpu();
    }
}
