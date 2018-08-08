package com.liumapp.demo.wosign;

import com.liumapp.qtools.file.base64.Base64FileTool;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * @author liumapp
 * @file UtilTest.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/7
 */
public class UtilTest extends TestCase {

    private String dataPath = "/usr/local/tomcat/project/wosign-contract/data/pdf/";

    @Test
    public void testOpenFileAndConvertToBase64 () throws IOException {
        String base64File = Base64FileTool.filePathToBase64(dataPath + "test.pdf");
        System.out.println(base64File);
    }

}
