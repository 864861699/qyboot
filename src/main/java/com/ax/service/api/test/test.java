package com.ax.service.api.test;

import com.ax.service.utils.RD;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test {


    @RequestMapping("/bb")
    public RD te(){
        return RD.success(1);
    }

}
