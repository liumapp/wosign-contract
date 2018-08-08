package com.liumapp.demo.wosign;

import com.alibaba.fastjson.JSON;
import com.liumapp.demo.wosign.entity.SignList;
import com.liumapp.demo.wosign.entity.SignerList;
import com.liumapp.demo.wosign.utils.HttpsConnUtils;
import com.liumapp.qtools.file.base64.Base64FileTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
    private HttpsConnUtils httpsConnUtils;

    @Test
    public void testSign () throws Exception {
        SignerList signerList = new SignerList();
        SignList signList = new SignList();
        LinkedList<SignList> lists = new LinkedList<>();
        signList.setPagenumber(1)
                .setPosition("0.30,0.57,0.46,0.69");
        lists.add(signList);
        signerList.setSignType("2")
                .setUserName("zhangsan")
                .setUserNo("123456789123456789")
                .setPic(Base64FileTool.filePathToBase64(picPath + "1.jpg"))
                .setOtherpic(Base64FileTool.filePathToBase64(picPath + "2.jpg"))
                .setSignlist(lists);
        System.out.println("send info : ");
        System.out.println(JSON.toJSONString(signerList));
        httpsConnUtils.post("https://docapitest.wosign.com", JSON.toJSONString(signerList));
    }

}
