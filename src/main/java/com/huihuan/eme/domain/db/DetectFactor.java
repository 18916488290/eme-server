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
 * DetectFactor generated by hbm2java
 */
@Entity
@Table(name="detect_factor"
    ,catalog="eme"
)
public class DetectFactor  implements java.io.Serializable {


     private Long id;
     private DetectCategory detectCategory;
     private DetectContentDic detectContentDic;
     private String factorName;
     private String chemicalName;
     private float minVal;
     private Float maxVal;
     private Float minXVal;
     private Float maxXVal;
     private String unit;
     private Long frequency;
     private Set<DetectWater> detectWaters = new HashSet<DetectWater>(0);
     private Set<DetectHistory> detectHistories = new HashSet<DetectHistory>(0);
     private Set<DetectPullant> detectPullants = new HashSet<DetectPullant>(0);
     private Set<DetectRiveRcross> detectRiveRcrosses = new HashSet<DetectRiveRcross>(0);
     private Set<IaqiInfo> iaqiInfos = new HashSet<IaqiInfo>(0);
     private Set<DetectAir> detectAirs = new HashSet<DetectAir>(0);
     private Set<Detect> detects = new HashSet<Detect>(0);

    public DetectFactor() {
    }

	
    public DetectFactor(float minVal) {
        this.minVal = minVal;
    }
    public DetectFactor(DetectCategory detectCategory, DetectContentDic detectContentDic, String factorName, String chemicalName, float minVal, Float maxVal, Float minXVal, Float maxXVal, String unit, Long frequency, Set<DetectWater> detectWaters, Set<DetectHistory> detectHistories, Set<DetectPullant> detectPullants, Set<DetectRiveRcross> detectRiveRcrosses, Set<IaqiInfo> iaqiInfos, Set<DetectAir> detectAirs, Set<Detect> detects) {
       this.detectCategory = detectCategory;
       this.detectContentDic = detectContentDic;
       this.factorName = factorName;
       this.chemicalName = chemicalName;
       this.minVal = minVal;
       this.maxVal = maxVal;
       this.minXVal = minXVal;
       this.maxXVal = maxXVal;
       this.unit = unit;
       this.frequency = frequency;
       this.detectWaters = detectWaters;
       this.detectHistories = detectHistories;
       this.detectPullants = detectPullants;
       this.detectRiveRcrosses = detectRiveRcrosses;
       this.iaqiInfos = iaqiInfos;
       this.detectAirs = detectAirs;
       this.detects = detects;
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
    @JoinColumn(name="id_detect_category")
    public DetectCategory getDetectCategory() {
        return this.detectCategory;
    }
    
    public void setDetectCategory(DetectCategory detectCategory) {
        this.detectCategory = detectCategory;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_detect_content")
    public DetectContentDic getDetectContentDic() {
        return this.detectContentDic;
    }
    
    public void setDetectContentDic(DetectContentDic detectContentDic) {
        this.detectContentDic = detectContentDic;
    }
    
    @Column(name="factor_name", length=64)
    public String getFactorName() {
        return this.factorName;
    }
    
    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }
    
    @Column(name="chemical_name", length=64)
    public String getChemicalName() {
        return this.chemicalName;
    }
    
    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }
    
    @Column(name="min_val", nullable=false, precision=12, scale=0)
    public float getMinVal() {
        return this.minVal;
    }
    
    public void setMinVal(float minVal) {
        this.minVal = minVal;
    }
    
    @Column(name="max_val", precision=12, scale=0)
    public Float getMaxVal() {
        return this.maxVal;
    }
    
    public void setMaxVal(Float maxVal) {
        this.maxVal = maxVal;
    }
    
    @Column(name="min_x_val", precision=12, scale=0)
    public Float getMinXVal() {
        return this.minXVal;
    }
    
    public void setMinXVal(Float minXVal) {
        this.minXVal = minXVal;
    }
    
    @Column(name="max_x_val", precision=12, scale=0)
    public Float getMaxXVal() {
        return this.maxXVal;
    }
    
    public void setMaxXVal(Float maxXVal) {
        this.maxXVal = maxXVal;
    }
    
    @Column(name="unit", length=20)
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    @Column(name="frequency")
    public Long getFrequency() {
        return this.frequency;
    }
    
    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<DetectWater> getDetectWaters() {
        return this.detectWaters;
    }
    
    public void setDetectWaters(Set<DetectWater> detectWaters) {
        this.detectWaters = detectWaters;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<DetectHistory> getDetectHistories() {
        return this.detectHistories;
    }
    
    public void setDetectHistories(Set<DetectHistory> detectHistories) {
        this.detectHistories = detectHistories;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<DetectPullant> getDetectPullants() {
        return this.detectPullants;
    }
    
    public void setDetectPullants(Set<DetectPullant> detectPullants) {
        this.detectPullants = detectPullants;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<DetectRiveRcross> getDetectRiveRcrosses() {
        return this.detectRiveRcrosses;
    }
    
    public void setDetectRiveRcrosses(Set<DetectRiveRcross> detectRiveRcrosses) {
        this.detectRiveRcrosses = detectRiveRcrosses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<IaqiInfo> getIaqiInfos() {
        return this.iaqiInfos;
    }
    
    public void setIaqiInfos(Set<IaqiInfo> iaqiInfos) {
        this.iaqiInfos = iaqiInfos;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<DetectAir> getDetectAirs() {
        return this.detectAirs;
    }
    
    public void setDetectAirs(Set<DetectAir> detectAirs) {
        this.detectAirs = detectAirs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectFactor")
    public Set<Detect> getDetects() {
        return this.detects;
    }
    
    public void setDetects(Set<Detect> detects) {
        this.detects = detects;
    }




}


