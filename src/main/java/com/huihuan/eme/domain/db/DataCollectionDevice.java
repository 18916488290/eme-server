package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DataCollectionDevice generated by hbm2java
 */
@Entity
@Table(name="data_collection_device"
    ,catalog="eme"
)
public class DataCollectionDevice  implements java.io.Serializable {


     private String mn;
     private DetectStation detectStation;
     private Company company;
     private String deviceName;
     private String lat;
     private String lng;
     private Set<DetectFactorCurrentValues> detectFactorCurrentValueses = new HashSet<DetectFactorCurrentValues>(0);
     private Set<DetectFactorValues> detectFactorValueses = new HashSet<DetectFactorValues>(0);

    public DataCollectionDevice() {
    }

	
    public DataCollectionDevice(String mn) {
        this.mn = mn;
    }
    public DataCollectionDevice(String mn, DetectStation detectStation, Company company, String deviceName, String lat, String lng, Set<DetectFactorCurrentValues> detectFactorCurrentValueses, Set<DetectFactorValues> detectFactorValueses) {
       this.mn = mn;
       this.detectStation = detectStation;
       this.company = company;
       this.deviceName = deviceName;
       this.lat = lat;
       this.lng = lng;
       this.detectFactorCurrentValueses = detectFactorCurrentValueses;
       this.detectFactorValueses = detectFactorValueses;
    }
   
     @Id 
    
    @Column(name="mn", unique=true, nullable=false, length=64)
    public String getMn() {
        return this.mn;
    }
    
    public void setMn(String mn) {
        this.mn = mn;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_detect_station")
    public DetectStation getDetectStation() {
        return this.detectStation;
    }
    
    public void setDetectStation(DetectStation detectStation) {
        this.detectStation = detectStation;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    
    @Column(name="device_name", length=20)
    public String getDeviceName() {
        return this.deviceName;
    }
    
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="dataCollectionDevice")
    public Set<DetectFactorCurrentValues> getDetectFactorCurrentValueses() {
        return this.detectFactorCurrentValueses;
    }
    
    public void setDetectFactorCurrentValueses(Set<DetectFactorCurrentValues> detectFactorCurrentValueses) {
        this.detectFactorCurrentValueses = detectFactorCurrentValueses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="dataCollectionDevice")
    public Set<DetectFactorValues> getDetectFactorValueses() {
        return this.detectFactorValueses;
    }
    
    public void setDetectFactorValueses(Set<DetectFactorValues> detectFactorValueses) {
        this.detectFactorValueses = detectFactorValueses;
    }




}


