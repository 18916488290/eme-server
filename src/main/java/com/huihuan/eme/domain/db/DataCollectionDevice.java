package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:34:42 by Hibernate Tools 3.2.2.GA


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
     private String deviceName;
     private Set<DetectHistory> detectHistories = new HashSet<DetectHistory>(0);
     private Set<Detect> detects = new HashSet<Detect>(0);

    public DataCollectionDevice() {
    }

	
    public DataCollectionDevice(String mn) {
        this.mn = mn;
    }
    public DataCollectionDevice(String mn, DetectStation detectStation, String deviceName, Set<DetectHistory> detectHistories, Set<Detect> detects) {
       this.mn = mn;
       this.detectStation = detectStation;
       this.deviceName = deviceName;
       this.detectHistories = detectHistories;
       this.detects = detects;
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
    
    @Column(name="device_name", length=20)
    public String getDeviceName() {
        return this.deviceName;
    }
    
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="dataCollectionDevice")
    public Set<DetectHistory> getDetectHistories() {
        return this.detectHistories;
    }
    
    public void setDetectHistories(Set<DetectHistory> detectHistories) {
        this.detectHistories = detectHistories;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="dataCollectionDevice")
    public Set<Detect> getDetects() {
        return this.detects;
    }
    
    public void setDetects(Set<Detect> detects) {
        this.detects = detects;
    }




}


