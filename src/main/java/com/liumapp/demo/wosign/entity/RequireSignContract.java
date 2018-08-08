package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

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

    private String actiontype; //CreateSignOrder

    private String filebase;

    private String fileformat;//签署文档格式

    private String orderNumber;

    private String tempid; //模板id

    private String subject; //签署合同标签

    private String password;

    private LinkedList<SignerList> signerlist;

    public RequireSignContract() {
    }

    public RequireSignContract(String tokenid, String actiontype, String filebase, String fileformat, String orderNumber, String tempid, String subject, String password, LinkedList<SignerList> signerlist) {
        this.tokenid = tokenid;
        this.actiontype = actiontype;
        this.filebase = filebase;
        this.fileformat = fileformat;
        this.orderNumber = orderNumber;
        this.tempid = tempid;
        this.subject = subject;
        this.password = password;
        this.signerlist = signerlist;
    }

    public String getTokenid() {
        return tokenid;
    }

    public RequireSignContract setTokenid(String tokenid) {
        this.tokenid = tokenid;
        return this;
    }

    public String getActiontype() {
        return actiontype;
    }

    public RequireSignContract setActiontype(String actiontype) {
        this.actiontype = actiontype;
        return this;
    }

    public String getFilebase() {
        return filebase;
    }

    public RequireSignContract setFilebase(String filebase) {
        this.filebase = filebase;
        return this;
    }

    public String getFileformat() {
        return fileformat;
    }

    public RequireSignContract setFileformat(String fileformat) {
        this.fileformat = fileformat;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public RequireSignContract setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public String getTempid() {
        return tempid;
    }

    public RequireSignContract setTempid(String tempid) {
        this.tempid = tempid;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public RequireSignContract setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RequireSignContract setPassword(String password) {
        this.password = password;
        return this;
    }

    public LinkedList<SignerList> getSignerlist() {
        return signerlist;
    }

    public RequireSignContract setSignerlist(LinkedList<SignerList> signerlist) {
        this.signerlist = signerlist;
        return this;
    }
}
