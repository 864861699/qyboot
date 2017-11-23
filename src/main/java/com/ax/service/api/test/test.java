package com.ax.service.api.test;

import com.ax.service.service.apiinterface.TestI;
import com.ax.service.utils.RD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test {

    @Autowired
    TestI testSer;

    @RequestMapping("/bb")
    public RD te(){
        return RD.success(testSer.bb());
    }

}
