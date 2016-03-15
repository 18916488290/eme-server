package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:08:08 by Hibernate Tools 3.2.2.GA


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

/**
 * AirEnv generated by hbm2java
 */
@Entity
@Table(name="air_env"
    ,catalog="eme"
)
public class AirEnv  implements java.io.Serializable {


     private Long id;
     private AirEnvType airEnvType;
     private EnvFunc envFunc;
     private String airEnvName;
     private String lat;
     private String lng;
     private String emePerson;
     private String emeMobile;
     private Set<CompanyAirEnv> companyAirEnvs = new HashSet<CompanyAirEnv>(0);

    public AirEnv() {
    }

	
    public AirEnv(String airEnvName) {
        this.airEnvName = airEnvName;
    }
    public AirEnv(AirEnvType airEnvType, EnvFunc envFunc, String airEnvName, String lat, String lng, String emePerson, String emeMobile, Set<CompanyAirEnv> companyAirEnvs) {
       this.airEnvType = airEnvType;
       this.envFunc = envFunc;
       this.airEnvName = airEnvName;
       this.lat = lat;
       this.lng = lng;
       this.emePerson = emePerson;
       this.emeMobile = emeMobile;
       this.companyAirEnvs = companyAirEnvs;
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
    @JoinColumn(name="id_air_env_type")
    public AirEnvType getAirEnvType() {
        return this.airEnvType;
    }
    
    public void setAirEnvType(AirEnvType airEnvType) {
        this.airEnvType = airEnvType;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_env_func")
    public EnvFunc getEnvFunc() {
        return this.envFunc;
    }
    
    public void setEnvFunc(EnvFunc envFunc) {
        this.envFunc = envFunc;
    }
    
    @Column(name="air_env_name", nullable=false, length=64)
    public String getAirEnvName() {
        return this.airEnvName;
    }
    
    public void setAirEnvName(String airEnvName) {
        this.airEnvName = airEnvName;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="airEnv")
    public Set<CompanyAirEnv> getCompanyAirEnvs() {
        return this.companyAirEnvs;
    }
    
    public void setCompanyAirEnvs(Set<CompanyAirEnv> companyAirEnvs) {
        this.companyAirEnvs = companyAirEnvs;
    }




}


