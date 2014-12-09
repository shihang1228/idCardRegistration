package com.baldurtech.idCard;

import java.sql.Date;

public class IdCard {
    private String name;
    private String gender;
    private String folk;
    private String code;
    private Date birthday;
    private String address;
    private String agency;
    private byte[] content;
    private String contentType;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public void setFolk(String folk) {
        this.folk = folk;
    }
    
    public String getFolk() {
        return this.folk;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAgency(String agency) {
        this.agency = agency;
    }
    
    public String getAgency() {
        return this.agency;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    public byte[] getContent() {
        return this.content;
    }
    
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public String getContentType() {
        return this.contentType;
    }
}