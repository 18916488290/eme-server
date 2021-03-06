package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CompanyWaterEnv generated by hbm2java
 */
@Entity
@Table(name="company_water_env"
    ,catalog="eme"
)
public class CompanyWaterEnv  implements java.io.Serializable {


     private CompanyWaterEnvId id;
     private Company company;
     private WaterEnv waterEnv;
     private Long distance;
     private String location;

    public CompanyWaterEnv() {
    }

	
    public CompanyWaterEnv(CompanyWaterEnvId id, Company company, WaterEnv waterEnv, Long distance) {
        this.id = id;
        this.company = company;
        this.waterEnv = waterEnv;
        this.distance = distance;
    }
    public CompanyWaterEnv(CompanyWaterEnvId id, Company company, WaterEnv waterEnv, Long distance, String location) {
       this.id = id;
       this.company = company;
       this.waterEnv = waterEnv;
       this.distance = distance;
       this.location = location;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idWaterEnv", column=@Column(name="id_water_env", nullable=false) ), 
        @AttributeOverride(name="idCompany", column=@Column(name="id_company", nullable=false) ) } )
    public CompanyWaterEnvId getId() {
        return this.id;
    }
    
    public void setId(CompanyWaterEnvId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_company", nullable=false, insertable=false, updatable=false)
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_water_env", nullable=false, insertable=false, updatable=false)
    public WaterEnv getWaterEnv() {
        return this.waterEnv;
    }
    
    public void setWaterEnv(WaterEnv waterEnv) {
        this.waterEnv = waterEnv;
    }
    
    @Column(name="distance", nullable=false)
    public Long getDistance() {
        return this.distance;
    }
    
    public void setDistance(Long distance) {
        this.distance = distance;
    }
    
    @Column(name="location", length=20)
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }




}


