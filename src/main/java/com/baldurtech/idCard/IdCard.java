package com.baldurtech.idCard;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="idCard")
@NamedQueries({
    @NamedQuery(name = IdCard.GET_BY_ID, query = "from IdCard i where i.id = :id"),
    @NamedQuery(name = IdCard.GET_LATEST_ID_CARD, query = "from IdCard i where i.dateCreated = (select max(i.dateCreated) from IdCard i)")
   })
public class IdCard {
    public static final String GET_BY_ID = "IdCard.getById";
    public static final String GET_LATEST_ID_CARD = "IdCard.getLatestIdCard";
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String gender;
    private String folk;
    private String agency;
    private String address;
    private String code;
    private Date birthday;
    
    @Temporal( value = TemporalType.TIMESTAMP )
    private java.util.Date dateCreated;
    
    @Lob
    private byte[] content;
    private String contentType;
    
    @PrePersist
    protected void onCreate() {
        dateCreated = new java.util.Date();
    }

	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}  
    
    public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}
    
	public String getGender() {
		return gender;
	}
    
	public void setGender(String gender) {
		this.gender = gender;
	}
    
	public String getFolk() {
		return folk;
	}
    
	public void setFolk(String folk) {
		this.folk = folk;
	}
    
	public String getAgency() {
		return agency;
	}
    
	public void setAgency(String agency) {
		this.agency = agency;
	}
    
	public String getAddress() {
		return address;
	}
    
	public void setAddress(String address) {
		this.address = address;
	}
    
	public String getCode() {
		return code;
	}
    
	public void setCode(String code) {
		this.code = code;
	}
    
	public Date getBirthday() {
		return birthday;
	}
    
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
    public byte[] getContent() {
        return content;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    public String getContentType() {
        return contentType;
    }
        
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
