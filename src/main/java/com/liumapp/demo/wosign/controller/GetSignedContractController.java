package com.liumapp.demo.wosign.controller;

import com.liumapp.demo.wosign.entity.SignedContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liumapp
 * @file GetSignedContractController.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@RestController
@RequestMapping("notify")
public class GetSignedContractController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/contract")
    public String index (@RequestBody SignedContract signedContract) {
        logger.info("get info : ");
        logger.info(signedContract.toString());
        return "success";
    }

    @RequestMapping("/test")
    public String testConnect () {
        return "success";
    }

}
