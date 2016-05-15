package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


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
 * DetectFactorValues generated by hbm2java
 */
@Entity
@Table(name="detect_factor_values"
    ,catalog="eme"
)
public class DetectFactorValues  implements java.io.Serializable {


     private Long id;
     private DataCollectionDevice dataCollectionDevice;
     private DetectFactor detectFactor;
     private Date uploadTime;
     private Date detectTime;
     private Float minVal;
     private String default_;
     private Float maxVal;
     private Float avgVal;
     private Float zsAvgVal;
     private Float zsMinVal;
     private Float zsMaxVal;
     private Float couVal;
     private Float zsCouVal;
     private Float lowVal;
     private Float upVal;
     private Long type;

    public DetectFactorValues() {
    }

    public DetectFactorValues(DataCollectionDevice dataCollectionDevice, DetectFactor detectFactor, Date uploadTime, Date detectTime, Float minVal, String default_, Float maxVal, Float avgVal, Float zsAvgVal, Float zsMinVal, Float zsMaxVal, Float couVal, Float zsCouVal, Float lowVal, Float upVal, Long type) {
       this.dataCollectionDevice = dataCollectionDevice;
       this.detectFactor = detectFactor;
       this.uploadTime = uploadTime;
       this.detectTime = detectTime;
       this.minVal = minVal;
       this.default_ = default_;
       this.maxVal = maxVal;
       this.avgVal = avgVal;
       this.zsAvgVal = zsAvgVal;
       this.zsMinVal = zsMinVal;
       this.zsMaxVal = zsMaxVal;
       this.couVal = couVal;
       this.zsCouVal = zsCouVal;
       this.lowVal = lowVal;
       this.upVal = upVal;
       this.type = type;
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
    @JoinColumn(name="id_factor")
    public DetectFactor getDetectFactor() {
        return this.detectFactor;
    }
    
    public void setDetectFactor(DetectFactor detectFactor) {
        this.detectFactor = detectFactor;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="upload_time", length=19)
    public Date getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="detect_time", length=19)
    public Date getDetectTime() {
        return this.detectTime;
    }
    
    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }
    
    @Column(name="min_val", precision=12, scale=0)
    public Float getMinVal() {
        return this.minVal;
    }
    
    public void setMinVal(Float minVal) {
        this.minVal = minVal;
    }
    
    @Column(name="_default_", length=18)
    public String getDefault_() {
        return this.default_;
    }
    
    public void setDefault_(String default_) {
        this.default_ = default_;
    }
    
    @Column(name="max_val", precision=12, scale=0)
    public Float getMaxVal() {
        return this.maxVal;
    }
    
    public void setMaxVal(Float maxVal) {
        this.maxVal = maxVal;
    }
    
    @Column(name="avg_val", precision=12, scale=0)
    public Float getAvgVal() {
        return this.avgVal;
    }
    
    public void setAvgVal(Float avgVal) {
        this.avgVal = avgVal;
    }
    
    @Column(name="zs_avg_val", precision=12, scale=0)
    public Float getZsAvgVal() {
        return this.zsAvgVal;
    }
    
    public void setZsAvgVal(Float zsAvgVal) {
        this.zsAvgVal = zsAvgVal;
    }
    
    @Column(name="zs_min_val", precision=12, scale=0)
    public Float getZsMinVal() {
        return this.zsMinVal;
    }
    
    public void setZsMinVal(Float zsMinVal) {
        this.zsMinVal = zsMinVal;
    }
    
    @Column(name="zs_max_val", precision=12, scale=0)
    public Float getZsMaxVal() {
        return this.zsMaxVal;
    }
    
    public void setZsMaxVal(Float zsMaxVal) {
        this.zsMaxVal = zsMaxVal;
    }
    
    @Column(name="cou_val", precision=12, scale=0)
    public Float getCouVal() {
        return this.couVal;
    }
    
    public void setCouVal(Float couVal) {
        this.couVal = couVal;
    }
    
    @Column(name="zs_cou_val", precision=12, scale=0)
    public Float getZsCouVal() {
        return this.zsCouVal;
    }
    
    public void setZsCouVal(Float zsCouVal) {
        this.zsCouVal = zsCouVal;
    }
    
    @Column(name="low_val", precision=12, scale=0)
    public Float getLowVal() {
        return this.lowVal;
    }
    
    public void setLowVal(Float lowVal) {
        this.lowVal = lowVal;
    }
    
    @Column(name="up_val", precision=12, scale=0)
    public Float getUpVal() {
        return this.upVal;
    }
    
    public void setUpVal(Float upVal) {
        this.upVal = upVal;
    }
    
    @Column(name="type")
    public Long getType() {
        return this.type;
    }
    
    public void setType(Long type) {
        this.type = type;
    }




}


