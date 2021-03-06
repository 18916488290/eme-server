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
 * DetectFactorCurrentValues generated by hbm2java
 */
@Entity
@Table(name="detect_factor_current_values"
    ,catalog="eme"
)
public class DetectFactorCurrentValues  implements java.io.Serializable {


     private Long id;
     private DataCollectionDevice dataCollectionDevice;
     private DetectFactor detectFactor;
     private Float val;
     private Date detectTime;
     private Date uploadTime;
     private String opt1;
     private String opt2;
     private String opt3;
     private String opt4;
     private String opt5;

    public DetectFactorCurrentValues() {
    }

    public DetectFactorCurrentValues(DataCollectionDevice dataCollectionDevice, DetectFactor detectFactor, Float val, Date detectTime, Date uploadTime, String opt1, String opt2, String opt3, String opt4, String opt5) {
       this.dataCollectionDevice = dataCollectionDevice;
       this.detectFactor = detectFactor;
       this.val = val;
       this.detectTime = detectTime;
       this.uploadTime = uploadTime;
       this.opt1 = opt1;
       this.opt2 = opt2;
       this.opt3 = opt3;
       this.opt4 = opt4;
       this.opt5 = opt5;
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
    
    @Column(name="val", precision=12, scale=0)
    public Float getVal() {
        return this.val;
    }
    
    public void setVal(Float val) {
        this.val = val;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="detect_time", length=19)
    public Date getDetectTime() {
        return this.detectTime;
    }
    
    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="upload_time", length=19)
    public Date getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
    
    @Column(name="opt1", length=64)
    public String getOpt1() {
        return this.opt1;
    }
    
    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }
    
    @Column(name="opt2", length=64)
    public String getOpt2() {
        return this.opt2;
    }
    
    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }
    
    @Column(name="opt3", length=64)
    public String getOpt3() {
        return this.opt3;
    }
    
    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }
    
    @Column(name="opt4", length=64)
    public String getOpt4() {
        return this.opt4;
    }
    
    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }
    
    @Column(name="opt5", length=64)
    public String getOpt5() {
        return this.opt5;
    }
    
    public void setOpt5(String opt5) {
        this.opt5 = opt5;
    }




}


