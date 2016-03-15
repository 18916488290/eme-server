package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:34:42 by Hibernate Tools 3.2.2.GA


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
 * EquipmentRisk generated by hbm2java
 */
@Entity
@Table(name="equipment_risk"
    ,catalog="eme"
)
public class EquipmentRisk  implements java.io.Serializable {


     private Long id;
     private Company company;
     private String equipmentName;
     private String lat;
     private String lng;
     private String installAddress;
     private String brand;
     private Date installDate;
     private String lifetime;
     private String equipmentModel;
     private String riskDes;

    public EquipmentRisk() {
    }

    public EquipmentRisk(Company company, String equipmentName, String lat, String lng, String installAddress, String brand, Date installDate, String lifetime, String equipmentModel, String riskDes) {
       this.company = company;
       this.equipmentName = equipmentName;
       this.lat = lat;
       this.lng = lng;
       this.installAddress = installAddress;
       this.brand = brand;
       this.installDate = installDate;
       this.lifetime = lifetime;
       this.equipmentModel = equipmentModel;
       this.riskDes = riskDes;
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
    @JoinColumn(name="id_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    
    @Column(name="equipment_name", length=64)
    public String getEquipmentName() {
        return this.equipmentName;
    }
    
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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
    
    @Column(name="install_address", length=64)
    public String getInstallAddress() {
        return this.installAddress;
    }
    
    public void setInstallAddress(String installAddress) {
        this.installAddress = installAddress;
    }
    
    @Column(name="brand", length=64)
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="install_date", length=10)
    public Date getInstallDate() {
        return this.installDate;
    }
    
    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }
    
    @Column(name="lifetime", length=20)
    public String getLifetime() {
        return this.lifetime;
    }
    
    public void setLifetime(String lifetime) {
        this.lifetime = lifetime;
    }
    
    @Column(name="equipment_model", length=64)
    public String getEquipmentModel() {
        return this.equipmentModel;
    }
    
    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }
    
    @Column(name="risk_des", length=256)
    public String getRiskDes() {
        return this.riskDes;
    }
    
    public void setRiskDes(String riskDes) {
        this.riskDes = riskDes;
    }




}


