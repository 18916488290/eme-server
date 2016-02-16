package com.huihuan.eme.domain.db;
// Generated 2016-2-16 22:08:48 by Hibernate Tools 3.2.2.GA


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
 * CompanyAirEnv generated by hbm2java
 */
@Entity
@Table(name="company_air_env"
    ,catalog="eme"
)
public class CompanyAirEnv  implements java.io.Serializable {


     private CompanyAirEnvId id;
     private Company company;
     private LocationDic locationDic;
     private AirEnv airEnv;
     private Long distance;

    public CompanyAirEnv() {
    }

	
    public CompanyAirEnv(CompanyAirEnvId id, Company company, AirEnv airEnv) {
        this.id = id;
        this.company = company;
        this.airEnv = airEnv;
    }
    public CompanyAirEnv(CompanyAirEnvId id, Company company, LocationDic locationDic, AirEnv airEnv, Long distance) {
       this.id = id;
       this.company = company;
       this.locationDic = locationDic;
       this.airEnv = airEnv;
       this.distance = distance;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idAirEnv", column=@Column(name="id_air_env", nullable=false) ), 
        @AttributeOverride(name="idCompany", column=@Column(name="id_company", nullable=false) ) } )
    public CompanyAirEnvId getId() {
        return this.id;
    }
    
    public void setId(CompanyAirEnvId id) {
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
    @JoinColumn(name="id")
    public LocationDic getLocationDic() {
        return this.locationDic;
    }
    
    public void setLocationDic(LocationDic locationDic) {
        this.locationDic = locationDic;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_air_env", nullable=false, insertable=false, updatable=false)
    public AirEnv getAirEnv() {
        return this.airEnv;
    }
    
    public void setAirEnv(AirEnv airEnv) {
        this.airEnv = airEnv;
    }
    
    @Column(name="distance")
    public Long getDistance() {
        return this.distance;
    }
    
    public void setDistance(Long distance) {
        this.distance = distance;
    }




}


