package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:08:08 by Hibernate Tools 3.2.2.GA


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
 * DetectWater generated by hbm2java
 */
@Entity
@Table(name="detect_water"
    ,catalog="eme"
)
public class DetectWater  implements java.io.Serializable {


     private Long id;
     private DetectFactor detectFactor;
     private WaterSource waterSource;
     private Float val;
     private Float avgVal;
     private Date reportTime;
     private Boolean isDaily;

    public DetectWater() {
    }

    public DetectWater(DetectFactor detectFactor, WaterSource waterSource, Float val, Float avgVal, Date reportTime, Boolean isDaily) {
       this.detectFactor = detectFactor;
       this.waterSource = waterSource;
       this.val = val;
       this.avgVal = avgVal;
       this.reportTime = reportTime;
       this.isDaily = isDaily;
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
    @JoinColumn(name="id_factor")
    public DetectFactor getDetectFactor() {
        return this.detectFactor;
    }
    
    public void setDetectFactor(DetectFactor detectFactor) {
        this.detectFactor = detectFactor;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_water_source")
    public WaterSource getWaterSource() {
        return this.waterSource;
    }
    
    public void setWaterSource(WaterSource waterSource) {
        this.waterSource = waterSource;
    }
    
    @Column(name="val", precision=12, scale=0)
    public Float getVal() {
        return this.val;
    }
    
    public void setVal(Float val) {
        this.val = val;
    }
    
    @Column(name="avg_val", precision=12, scale=0)
    public Float getAvgVal() {
        return this.avgVal;
    }
    
    public void setAvgVal(Float avgVal) {
        this.avgVal = avgVal;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="report_time", length=10)
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




}

