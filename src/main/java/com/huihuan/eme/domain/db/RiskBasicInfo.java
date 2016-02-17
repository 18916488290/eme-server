package com.huihuan.eme.domain.db;
// Generated 2016-2-17 22:23:55 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
     private IndustrialPark industrialPark;
     private Date creationDate;
     private String registrationCode;
     private String licenseCode;
     private String corporation;
     private String corporationFax;
     private Float area;
     private String emePerson;
     private String emeMobile;
     private Set<Company> companies = new HashSet<Company>(0);

    public RiskBasicInfo() {
    }

    public RiskBasicInfo(ProductStatus productStatus, IndustrialPark industrialPark, Date creationDate, String registrationCode, String licenseCode, String corporation, String corporationFax, Float area, String emePerson, String emeMobile, Set<Company> companies) {
       this.productStatus = productStatus;
       this.industrialPark = industrialPark;
       this.creationDate = creationDate;
       this.registrationCode = registrationCode;
       this.licenseCode = licenseCode;
       this.corporation = corporation;
       this.corporationFax = corporationFax;
       this.area = area;
       this.emePerson = emePerson;
       this.emeMobile = emeMobile;
       this.companies = companies;
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
    @JoinColumn(name="id_industrial_park")
    public IndustrialPark getIndustrialPark() {
        return this.industrialPark;
    }
    
    public void setIndustrialPark(IndustrialPark industrialPark) {
        this.industrialPark = industrialPark;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", length=10)
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    @Column(name="registration_code", length=64)
    public String getRegistrationCode() {
        return this.registrationCode;
    }
    
    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }
    
    @Column(name="license_code", length=64)
    public String getLicenseCode() {
        return this.licenseCode;
    }
    
    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }
    
    @Column(name="corporation", length=20)
    public String getCorporation() {
        return this.corporation;
    }
    
    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }
    
    @Column(name="corporation_fax", length=20)
    public String getCorporationFax() {
        return this.corporationFax;
    }
    
    public void setCorporationFax(String corporationFax) {
        this.corporationFax = corporationFax;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="riskBasicInfo")
    public Set<Company> getCompanies() {
        return this.companies;
    }
    
    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }




}


