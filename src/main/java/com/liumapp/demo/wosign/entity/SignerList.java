package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

/**
 * @author liumapp
 * @file SignerList.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@Component
public class SignerList {

    //企业用户
    private String signType; //企业用户为1

    private String orgName;//企业名称

    private String orgNo; //营业执照号

    private String stampbase;//签章base64，可传可不传

    private String pic; //营业执照照片base64

    private String otherpic; //开户许可证照片base64


}
