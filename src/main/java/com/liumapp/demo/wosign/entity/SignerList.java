package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * @author liumapp
 * @file SignerList.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@Component
public class SignerList {

    private String signType; //企业用户为1 个人用户为2

    //企业用户
    private String orgName;//企业名称

    private String orgNo; //营业执照号

    //个人用户
    private String userName;

    private String userNo;

    //通用
    private String pic; //营业执照照片base64 个人用户为身份证正面照片base64

    private String otherpic; //开户许可证照片base64 个人用户为身份证反面照片base64

    private String stampbase;//签章base64，可传可不传

    private LinkedList<SignList> signlist;

    public SignerList() {
    }

    public SignerList(String signType, String orgName, String orgNo, String userName, String userNo, String pic, String otherpic, String stampbase, LinkedList<SignList> signlist) {
        this.signType = signType;
        this.orgName = orgName;
        this.orgNo = orgNo;
        this.userName = userName;
        this.userNo = userNo;
        this.pic = pic;
        this.otherpic = otherpic;
        this.stampbase = stampbase;
        this.signlist = signlist;
    }

    public String getSignType() {
        return signType;
    }

    public SignerList setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public SignerList setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public SignerList setOrgNo(String orgNo) {
        this.orgNo = orgNo;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public SignerList setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserNo() {
        return userNo;
    }

    public SignerList setUserNo(String userNo) {
        this.userNo = userNo;
        return this;
    }

    public String getPic() {
        return pic;
    }

    public SignerList setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public String getOtherpic() {
        return otherpic;
    }

    public SignerList setOtherpic(String otherpic) {
        this.otherpic = otherpic;
        return this;
    }

    public String getStampbase() {
        return stampbase;
    }

    public SignerList setStampbase(String stampbase) {
        this.stampbase = stampbase;
        return this;
    }

    public LinkedList<SignList> getSignlist() {
        return signlist;
    }

    public SignerList setSignlist(LinkedList<SignList> signlist) {
        this.signlist = signlist;
        return this;
    }
}
