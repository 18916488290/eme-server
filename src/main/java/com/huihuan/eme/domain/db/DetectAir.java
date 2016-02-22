package com.huihuan.eme.domain.db;
// Generated 2016-2-22 12:27:37 by Hibernate Tools 3.2.2.GA


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
 * DetectAir generated by hbm2java
 */
@Entity
@Table(name="detect_air"
    ,catalog="eme"
)
public class DetectAir  implements java.io.Serializable {


     private Long id;
     private DetectStation detectStation;
     private DetectFactor detectFactor;
     private Float avgVal;
     private Date reportTime;
     private Boolean isDaily;
     private Float val;

    public DetectAir() {
    }

    public DetectAir(DetectStation detectStation, DetectFactor detectFactor, Float avgVal, Date reportTime, Boolean isDaily, Float val) {
       this.detectStation = detectStation;
       this.detectFactor = detectFactor;
       this.avgVal = avgVal;
       this.reportTime = reportTime;
       this.isDaily = isDaily;
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
    @JoinColumn(name="id_detect_station")
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
    
    @Column(name="avg_val", precision=12, scale=0)
    public Float getAvgVal() {
        return this.avgVal;
    }
    
    public void setAvgVal(Float avgVal) {
        this.avgVal = avgVal;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="report_time", length=19)
    public Date getReportTime() {
        return this.reportTime;
    }
    
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
    
    @Column(name="is_daily")
    public Boolean getIsDaily() {
        return this.isDaily;
    }
    
    public void setIsDaily(Boolean isDaily) {
        this.isDaily = isDaily;
    }
    
    @Column(name="val", precision=12, scale=0)
    public Float getVal() {
        return this.val;
    }
    
    public void setVal(Float val) {
        this.val = val;
    }




}


