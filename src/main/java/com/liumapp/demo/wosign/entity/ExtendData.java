package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

/**
 * @author liumapp
 * @file ExtendedData.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@Component
public class ExtendData {

    private String signid;

    private String ordernumber;

    private String content;

    private String hash;

    public ExtendData() {
    }

    public ExtendData(String signid, String ordernumber, String content, String hash) {
        this.signid = signid;
        this.ordernumber = ordernumber;
        this.content = content;
        this.hash = hash;
    }

    public String getSignid() {
        return signid;
    }

    public ExtendData setSignid(String signid) {
        this.signid = signid;
        return this;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public ExtendData setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ExtendData setContent(String content) {
        this.content = content;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public ExtendData setHash(String hash) {
        this.hash = hash;
        return this;
    }

    @Override
    public String toString() {
        return "ExtendedData{" +
                "signid='" + signid + '\'' +
                ", ordernumber='" + ordernumber + '\'' +
                ", content='" + content + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
