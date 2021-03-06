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
 * DetectPullant generated by hbm2java
 */
@Entity
@Table(name="detect_pullant"
    ,catalog="eme"
)
public class DetectPullant  implements java.io.Serializable {


     private Long id;
     private DetectFactor detectFactor;
     private PullantSource pullantSource;
     private Date reportTime;
     private Float val;
     private Long avgVal;
     private Boolean idDaily;

    public DetectPullant() {
    }

    public DetectPullant(DetectFactor detectFactor, PullantSource pullantSource, Date reportTime, Float val, Long avgVal, Boolean idDaily) {
       this.detectFactor = detectFactor;
       this.pullantSource = pullantSource;
       this.reportTime = reportTime;
       this.val = val;
       this.avgVal = avgVal;
       this.idDaily = idDaily;
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
    @JoinColumn(name="id_pullant_source")
    public PullantSource getPullantSource() {
        return this.pullantSource;
    }
    
    public void setPullantSource(PullantSource pullantSource) {
        this.pullantSource = pullantSource;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="report_time", length=10)
    public Date getReportTime() {
        return this.reportTime;
    }
    
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
    
    @Column(name="val", precision=12, scale=0)
    public Float getVal() {
        return this.val;
    }
    
    public void setVal(Float val) {
        this.val = val;
    }
    
    @Column(name="avg_val")
    public Long getAvgVal() {
        return this.avgVal;
    }
    
    public void setAvgVal(Long avgVal) {
        this.avgVal = avgVal;
    }
    
    @Column(name="id_daily")
    public Boolean getIdDaily() {
        return this.idDaily;
    }
    
    public void setIdDaily(Boolean idDaily) {
        this.idDaily = idDaily;
    }




}


