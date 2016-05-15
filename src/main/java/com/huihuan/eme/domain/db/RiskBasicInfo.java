package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RiskBasicInfo generated by hbm2java
 */
@Entity
@Table(name="risk_basic_info"
    ,catalog="eme"
)
public class RiskBasicInfo  implements java.io.Serializable {


     private Long id;
     private ProductStatus productStatus;
     private Company company;
     private IndustrialPark industrialPark;
     private String riskName;
     private Date creationDate;
     private Float area;
     private String emePerson;
     private String emeMobile;
     private Long status;
     private String comment;
     private String lat;
     private String lng;
     private String description;
     private String lvl;

    public RiskBasicInfo() {
    }

    public RiskBasicInfo(ProductStatus productStatus, Company company, IndustrialPark industrialPark, String riskName, Date creationDate, Float area, String emePerson, String emeMobile, Long status, String comment, String lat, String lng, String description, String lvl) {
       this.productStatus = productStatus;
       this.company = company;
       this.industrialPark = industrialPark;
       this.riskName = riskName;
       this.creationDate = creationDate;
       this.area = area;
       this.emePerson = emePerson;
       this.emeMobile = emeMobile;
       this.status = status;
       this.comment = comment;
       this.lat = lat;
       this.lng = lng;
       this.description = description;
       this.lvl = lvl;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_product_status")
    public ProductStatus getProductStatus() {
        return this.productStatus;
    }
    
    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_industrial_park")
    public IndustrialPark getIndustrialPark() {
        return this.industrialPark;
    }
    
    public void setIndustrialPark(IndustrialPark industrialPark) {
        this.industrialPark = industrialPark;
    }
    
    @Column(name="risk_name", length=32)
    public String getRiskName() {
        return this.riskName;
    }
    
    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", length=10)
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    @Column(name="area", precision=12, scale=0)
    public Float getArea() {
        return this.area;
    }
    
    public void setArea(Float area) {
        this.area = area;
    }
    
    @Column(name="eme_person", length=20)
    public String getEmePerson() {
        return this.emePerson;
    }
    
    public void setEmePerson(String emePerson) {
        this.emePerson = emePerson;
    }
    
    @Column(name="eme_mobile", length=20)
    public String getEmeMobile() {
        return this.emeMobile;
    }
    
    public void setEmeMobile(String emeMobile) {
        this.emeMobile = emeMobile;
    }
    
    @Column(name="status")
    public Long getStatus() {
        return this.status;
    }
    
    public void setStatus(Long status) {
        this.status = status;
    }
    
    @Column(name="comment", length=256)
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Column(name="lat", length=20)
    public String getLat() {
        return this.lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }
    
    @Column(name="lng", length=20)
    public String getLng() {
        return this.lng;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }
    
    @Column(name="description", length=256)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="lvl", length=20)
    public String getLvl() {
        return this.lvl;
    }
    
    public void setLvl(String lvl) {
        this.lvl = lvl;
    }




}


