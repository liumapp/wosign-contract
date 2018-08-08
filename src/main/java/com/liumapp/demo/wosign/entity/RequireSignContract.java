package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

/**
 * @author liumapp
 * @file RequireSignContract.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@Component
public class RequireSignContract {

    private String tokenid;

    private String actiontype;

    private String filebase;

    private String fileformat;//签署文档格式

    private String orderNumber;

    private String tempid; //模板id

    private String suject; //签署合同标签

    private String password;


}
