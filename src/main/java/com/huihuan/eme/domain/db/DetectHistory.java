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
 * DetectHistory generated by hbm2java
 */
@Entity
@Table(name="detect_history"
    ,catalog="eme"
)
public class DetectHistory  implements java.io.Serializable {


     private Long id;
     private DataCollectionDevice dataCollectionDevice;
     private DetectStation detectStation;
     private DetectFactor detectFactor;
     private Date detectTime;
     private Float val;

    public DetectHistory() {
    }

	
    public DetectHistory(DetectStation detectStation) {
        this.detectStation = detectStation;
    }
    public DetectHistory(DataCollectionDevice dataCollectionDevice, DetectStation detectStation, DetectFactor detectFactor, Date detectTime, Float val) {
       this.dataCollectionDevice = dataCollectionDevice;
       this.detectStation = detectStation;
       this.detectFactor = detectFactor;
       this.detectTime = detectTime;
       this.val = val;
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
    @JoinColumn(name="mn")
    public DataCollectionDevice getDataCollectionDevice() {
        return this.dataCollectionDevice;
    }
    
    public void setDataCollectionDevice(DataCollectionDevice dataCollectionDevice) {
        this.dataCollectionDevice = dataCollectionDevice;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_detect_station", nullable=false)
    public DetectStation getDetectStation() {
        return this.detectStation;
    }
    
    public void setDetectStation(DetectStation detectStation) {
        this.detectStation = detectStation;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_detect_factor")
    public DetectFactor getDetectFactor() {
        return this.detectFactor;
    }
    
    public void setDetectFactor(DetectFactor detectFactor) {
        this.detectFactor = detectFactor;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="detect_time", length=19)
    public Date getDetectTime() {
        return this.detectTime;
    }
    
    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }
    
    @Column(name="val", precision=12, scale=0)
    public Float getVal() {
        return this.val;
    }
    
    public void setVal(Float val) {
        this.val = val;
    }




}


