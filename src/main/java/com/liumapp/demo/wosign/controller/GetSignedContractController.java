package com.liumapp.demo.wosign.controller;

import com.liumapp.demo.wosign.entity.SignedContract;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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

    @Value("${custom.pdfPath}")
    private String pdfPath;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * get the notify from wosign
     * get the pdf contract with certificate signed
     */
    @RequestMapping("/contract")
    public String index (@RequestBody SignedContract signedContract) throws IOException {
        logger.info("get info : ");
        logger.info(signedContract.toString());
        Base64FileTool.saveBase64File(signedContract.getExtendData().getContent(), pdfPath + "/saved.pdf");
        return "success";
    }

    @RequestMapping("/test")
    public String testConnect () {
        return "success";
    }

}
