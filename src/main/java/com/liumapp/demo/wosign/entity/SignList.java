package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

/**
 * @author liumapp
 * @file SignList.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@Component
public class SignList {

    private Integer pagenumber;

    private String position; // "0.30,0.57,0.46,0.69"

    public SignList() {
    }

    public SignList(Integer pagenumber, String position) {
        this.pagenumber = pagenumber;
        this.position = position;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public SignList setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public SignList setPosition(String position) {
        this.position = position;
        return this;
    }
}
