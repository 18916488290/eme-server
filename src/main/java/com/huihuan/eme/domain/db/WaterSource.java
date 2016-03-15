package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:08:08 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WaterSource generated by hbm2java
 */
@Entity
@Table(name="water_source"
    ,catalog="eme"
)
public class WaterSource  implements java.io.Serializable {


     private Long id;
     private String waterName;
     private String lng;
     private String lat;
     private Date creationTime;
     private Set<DetectWater> detectWaters = new HashSet<DetectWater>(0);

    public WaterSource() {
    }

    public WaterSource(String waterName, String lng, String lat, Date creationTime, Set<DetectWater> detectWaters) {
       this.waterName = waterName;
       this.lng = lng;
       this.lat = lat;
       this.creationTime = creationTime;
       this.detectWaters = detectWaters;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="water_name", length=20)
    public String getWaterName() {
        return this.waterName;
    }
    
    public void setWaterName(String waterName) {
        this.waterName = waterName;
    }
    
    @Column(name="lng", length=20)
    public String getLng() {
        return this.lng;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }
    
    @Column(name="lat", length=20)
    public String getLat() {
        return this.lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="creation_time", length=10)
    public Date getCreationTime() {
        return this.creationTime;
    }
    
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="waterSource")
    public Set<DetectWater> getDetectWaters() {
        return this.detectWaters;
    }
    
    public void setDetectWaters(Set<DetectWater> detectWaters) {
        this.detectWaters = detectWaters;
    }




}

