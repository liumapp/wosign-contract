package com.liumapp.demo.wosign.entity;

import org.springframework.stereotype.Component;

/**
 * @author liumapp
 * @file SignedContract.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/8
 */
@Component
public class SignedContract {

    private String actiontype;

    private Integer status;

    private String errorcode;

    private ExtendedData extendedData;

    public SignedContract() {
    }

    public SignedContract(String actiontype, Integer status, String errorcode, ExtendedData extendedData) {
        this.actiontype = actiontype;
        this.status = status;
        this.errorcode = errorcode;
        this.extendedData = extendedData;
    }

    public String getActiontype() {
        return actiontype;
    }

    public SignedContract setActiontype(String actiontype) {
        this.actiontype = actiontype;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SignedContract setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public SignedContract setErrorcode(String errorcode) {
        this.errorcode = errorcode;
        return this;
    }

    public ExtendedData getExtendedData() {
        return extendedData;
    }

    public SignedContract setExtendedData(ExtendedData extendedData) {
        this.extendedData = extendedData;
        return this;
    }

    @Override
    public String toString() {
        return "SignedContract{" +
                "actiontype='" + actiontype + '\'' +
                ", status=" + status +
                ", errorcode='" + errorcode + '\'' +
                ", extendedData=" + extendedData.toString() +
                '}';
    }
}
