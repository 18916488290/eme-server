package com.huihuan.eme.domain.db;
// Generated 2016-3-3 16:33:56 by Hibernate Tools 3.2.2.GA


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
 * DetectStation generated by hbm2java
 */
@Entity
@Table(name="detect_station"
    ,catalog="eme"
)
public class DetectStation  implements java.io.Serializable {


     private Long id;
     private AdministrativeDivision administrativeDivision;
     private Epb epb;
     private String detectStationName;
     private String lat;
     private String lng;
     private Set<DataCollectionDevice> dataCollectionDevices = new HashSet<DataCollectionDevice>(0);
     private Set<DetectAirReport> detectAirReports = new HashSet<DetectAirReport>(0);
     private Set<DetectAir> detectAirs = new HashSet<DetectAir>(0);
     private Set<DetectStationContent> detectStationContents = new HashSet<DetectStationContent>(0);
     private Set<Detect> detects = new HashSet<Detect>(0);
     private Set<DetectHistory> detectHistories = new HashSet<DetectHistory>(0);

    public DetectStation() {
    }

    public DetectStation(AdministrativeDivision administrativeDivision, Epb epb, String detectStationName, String lat, String lng, Set<DataCollectionDevice> dataCollectionDevices, Set<DetectAirReport> detectAirReports, Set<DetectAir> detectAirs, Set<DetectStationContent> detectStationContents, Set<Detect> detects, Set<DetectHistory> detectHistories) {
       this.administrativeDivision = administrativeDivision;
       this.epb = epb;
       this.detectStationName = detectStationName;
       this.lat = lat;
       this.lng = lng;
       this.dataCollectionDevices = dataCollectionDevices;
       this.detectAirReports = detectAirReports;
       this.detectAirs = detectAirs;
       this.detectStationContents = detectStationContents;
       this.detects = detects;
       this.detectHistories = detectHistories;
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
    @JoinColumn(name="id_divsion")
    public AdministrativeDivision getAdministrativeDivision() {
        return this.administrativeDivision;
    }
    
    public void setAdministrativeDivision(AdministrativeDivision administrativeDivision) {
        this.administrativeDivision = administrativeDivision;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_epb")
    public Epb getEpb() {
        return this.epb;
    }
    
    public void setEpb(Epb epb) {
        this.epb = epb;
    }
    
    @Column(name="detect_station_name", length=64)
    public String getDetectStationName() {
        return this.detectStationName;
    }
    
    public void setDetectStationName(String detectStationName) {
        this.detectStationName = detectStationName;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectStation")
    public Set<DataCollectionDevice> getDataCollectionDevices() {
        return this.dataCollectionDevices;
    }
    
    public void setDataCollectionDevices(Set<DataCollectionDevice> dataCollectionDevices) {
        this.dataCollectionDevices = dataCollectionDevices;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectStation")
    public Set<DetectAirReport> getDetectAirReports() {
        return this.detectAirReports;
    }
    
    public void setDetectAirReports(Set<DetectAirReport> detectAirReports) {
        this.detectAirReports = detectAirReports;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectStation")
    public Set<DetectAir> getDetectAirs() {
        return this.detectAirs;
    }
    
    public void setDetectAirs(Set<DetectAir> detectAirs) {
        this.detectAirs = detectAirs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectStation")
    public Set<DetectStationContent> getDetectStationContents() {
        return this.detectStationContents;
    }
    
    public void setDetectStationContents(Set<DetectStationContent> detectStationContents) {
        this.detectStationContents = detectStationContents;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectStation")
    public Set<Detect> getDetects() {
        return this.detects;
    }
    
    public void setDetects(Set<Detect> detects) {
        this.detects = detects;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="detectStation")
    public Set<DetectHistory> getDetectHistories() {
        return this.detectHistories;
    }
    
    public void setDetectHistories(Set<DetectHistory> detectHistories) {
        this.detectHistories = detectHistories;
    }




}


