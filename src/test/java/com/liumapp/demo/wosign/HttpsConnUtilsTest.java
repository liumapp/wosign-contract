package com.liumapp.demo.wosign;

import com.alibaba.fastjson.JSON;
import com.liumapp.demo.wosign.entity.RequireSignContract;
import com.liumapp.demo.wosign.entity.SignList;
import com.liumapp.demo.wosign.entity.SignerList;
import com.liumapp.demo.wosign.utils.HttpsConnUtils;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;

/**
 * @author liumapp
 * @file HttpsConnUtilsTest.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpsConnUtilsTest {

    @Value("${custom.picPath}")
    private String picPath;

    @Value("${custom.tokenid}")
    private String tokenid;

    @Value("${custom.pdfPath}")
    private String pdfPath;

    @Autowired
    private HttpsConnUtils httpsConnUtils;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testSign () throws Exception {
        RequireSignContract requireSignContract = new RequireSignContract();
        requireSignContract.setTokenid(tokenid)
                .setActiontype("CreateSignOrder")
                .setFilebase(Base64FileTool.filePathToBase64(pdfPath + "test.pdf"))
                .setFileformat("pdf")
                .setOrderNumber("wiejfisdjfiwe12312314")
                .setSubject("测试合同");
        SignerList signerList = new SignerList();
        SignList signList = new SignList();
        LinkedList<SignList> lists = new LinkedList<>();
        LinkedList<SignerList> signerLists = new LinkedList<>();
        signList.setPagenumber(1)
                .setPosition("0.30,0.57,0.46,0.69");
        lists.add(signList);
        signerList.setSignType("2")
                .setUserName("zhangsan")
                .setUserNo("123456789123456789")
                .setPic(Base64FileTool.filePathToBase64(picPath + "1.jpg"))
                .setOtherpic(Base64FileTool.filePathToBase64(picPath + "2.jpg"))
                .setSignlist(lists);
        signerLists.add(signerList);
        requireSignContract.setSignerlist(signerLists);
        logger.info("send info : ");
        logger.info(JSON.toJSONString(requireSignContract));
        FileTool.writeStringToNewFile(new File(pdfPath + "params.json"), JSON.toJSONString(requireSignContract));
        String result = httpsConnUtils.post("https://docapitest.wosign.com", URLEncoder.encode(JSON.toJSONString(requireSignContract), "UTF-8"));
        System.out.println(result);
    }

}
