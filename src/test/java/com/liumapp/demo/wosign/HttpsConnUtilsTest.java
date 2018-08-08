package com.liumapp.demo.wosign;

import com.liumapp.demo.wosign.utils.HttpsConnUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
    private HttpsConnUtils httpsConnUtils;

    @Test
    public void testSign () throws Exception {
        httpsConnUtils.post("https://docapitest.wosign.com", null);
    }

}
