package com.founder.dataCenter.crime.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * CaseBean entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="EZCRM_AJ",schema="EZCRM")
@XmlRootElement(name="case")
public class CaseBean  implements java.io.Serializable {

     /** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = -9146929297529915582L;
	 private String ajbh;
     private String ajmc;
     private String ajlbdm;
     private Date fasj;
     private String afdz;
     private String ajms;
     private String ajztdm;
     private String ssxqdm;
     private String sspcsdm;
     private String ssgafjdm;
     private String ssgajdm;
     private Long objectid;
     private String ajzldm;
     private String ajwldm;
     private String zzjgdm;

    // Constructors

    /** default constructor */
    public CaseBean() {
    }

	/** minimal constructor */
    public CaseBean(String ajbh) {
        this.ajbh = ajbh;
    }
    
    /** full constructor */
    public CaseBean(String ajbh,String ajmc, String ajlbdm, 
    		Date fasj, String afdz, String ajms, String ajztdm, String ssxqdm, 
    		String sspcsdm, String ssgafjdm, String ssgajdm, Long objectid, 
    		String ajzldm, String ajwldm, String zzjgdm) {
        this.ajbh = ajbh;
        this.ajmc = ajmc;
        this.ajlbdm = ajlbdm;
        this.fasj = fasj;
        this.afdz = afdz;
        this.ajms = ajms;
        this.ajztdm = ajztdm;
        this.ssxqdm = ssxqdm;
        this.sspcsdm = sspcsdm;
        this.ssgafjdm = ssgafjdm;
        this.ssgajdm = ssgajdm;
        this.objectid = objectid;
        this.ajzldm = ajzldm;
        this.ajwldm = ajwldm;
        this.zzjgdm = zzjgdm;
    }

   
    // Property accessors
    @Id 
    @Column(name="AJBH", unique=true, nullable=false, length=21)
    @XmlAttribute(name="ajbh")
    public String getAjbh() {
        return this.ajbh;
    }
    
    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }
    
    @Column(name="AJMC", length=400)
    @XmlAttribute(name="ajmc")
    public String getAjmc() {
        return this.ajmc;
    }
    
    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }
    
    @Column(name="AJLBDM", length=10)
    @XmlAttribute(name="AJLBDM")
    public String getAjlbdm() {
        return this.ajlbdm;
    }
    
    public void setAjlbdm(String ajlbdm) {
        this.ajlbdm = ajlbdm;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="FASJ", length=7)
    @XmlAttribute(name="FASJ")
    public Date getFasj() {
        return this.fasj;
    }
    
    public void setFasj(Date fasj) {
        this.fasj = fasj;
    }
    
    @Column(name="AFDZ", length=400)
    @XmlAttribute(name="afdz")
    public String getAfdz() {
        return this.afdz;
    }
    
    public void setAfdz(String afdz) {
        this.afdz = afdz;
    }
    
    @Column(name="AJMS", length=400)
    @XmlAttribute(name="ajms")
    public String getAjms() {
        return this.ajms;
    }
    
    public void setAjms(String ajms) {
        this.ajms = ajms;
    }
    
    @Column(name="AJZTDM", length=10)
    @XmlAttribute(name="ajztdm")
    public String getAjztdm() {
        return this.ajztdm;
    }
    
    public void setAjztdm(String ajztdm) {
        this.ajztdm = ajztdm;
    }
    
    @Column(name="SSXQDM", length=12)
    @XmlAttribute(name="ssxqdm")
    public String getSsxqdm() {
        return this.ssxqdm;
    }
    
    public void setSsxqdm(String ssxqdm) {
        this.ssxqdm = ssxqdm;
    }
    
    @Column(name="SSPCSDM", length=12)
    @XmlAttribute(name="sspcsdm")
    public String getSspcsdm() {
        return this.sspcsdm;
    }
    
    public void setSspcsdm(String sspcsdm) {
        this.sspcsdm = sspcsdm;
    }
    
    @Column(name="SSGAFJDM", length=12)
    @XmlAttribute(name="ssgafjdm")
    public String getSsgafjdm() {
        return this.ssgafjdm;
    }
    
    public void setSsgafjdm(String ssgafjdm) {
        this.ssgafjdm = ssgafjdm;
    }
    
    @Column(name="SSGAJDM", length=12)
    @XmlAttribute(name="ssgajdm")
    public String getSsgajdm() {
        return this.ssgajdm;
    }
    
    public void setSsgajdm(String ssgajdm) {
        this.ssgajdm = ssgajdm;
    }
    
    @Column(name="OBJECTID", precision=10, scale=0)
    @XmlAttribute(name="objectid")
    public Long getObjectid() {
        return this.objectid;
    }
    
    public void setObjectid(Long objectid) {
        this.objectid = objectid;
    }
    
    @Column(name="AJZLDM")
    @XmlAttribute(name="ajzldm")
    public String getAjzldm() {
        return this.ajzldm;
    }
    
    public void setAjzldm(String ajzldm) {
        this.ajzldm = ajzldm;
    }
    
    @Column(name="AJWLDM")
    @XmlAttribute(name="ajwldm")
    public String getAjwldm() {
        return this.ajwldm;
    }
    
    public void setAjwldm(String ajwldm) {
        this.ajwldm = ajwldm;
    }
    
    @Column(name="ZZJGDM", length=12)
    @XmlAttribute(name="zzjgdm")
    public String getZzjgdm() {
        return this.zzjgdm;
    }
    
    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }
}