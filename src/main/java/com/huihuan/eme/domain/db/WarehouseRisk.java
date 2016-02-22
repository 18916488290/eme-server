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
 * WarehouseRisk generated by hbm2java
 */
@Entity
@Table(name="warehouse_risk"
    ,catalog="eme"
)
public class WarehouseRisk  implements java.io.Serializable {


     private Long id;
     private Company company;
     private StorageMethod storageMethod;
     private String warehouseName;
     private Float area;
     private String lat;
     private String lng;
     private Float volume;
     private String materialName;
     private Float materialVolume;
     private Date lastModified;
     private String fileName;

    public WarehouseRisk() {
    }

    public WarehouseRisk(Company company, StorageMethod storageMethod, String warehouseName, Float area, String lat, String lng, Float volume, String materialName, Float materialVolume, Date lastModified, String fileName) {
       this.company = company;
       this.storageMethod = storageMethod;
       this.warehouseName = warehouseName;
       this.area = area;
       this.lat = lat;
       this.lng = lng;
       this.volume = volume;
       this.materialName = materialName;
       this.materialVolume = materialVolume;
       this.lastModified = lastModified;
       this.fileName = fileName;
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
    @JoinColumn(name="id_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_storage_method")
    public StorageMethod getStorageMethod() {
        return this.storageMethod;
    }
    
    public void setStorageMethod(StorageMethod storageMethod) {
        this.storageMethod = storageMethod;
    }
    
    @Column(name="warehouse_name", length=64)
    public String getWarehouseName() {
        return this.warehouseName;
    }
    
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
    
    @Column(name="area", precision=12, scale=0)
    public Float getArea() {
        return this.area;
    }
    
    public void setArea(Float area) {
        this.area = area;
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
    
    @Column(name="volume", precision=12, scale=0)
    public Float getVolume() {
        return this.volume;
    }
    
    public void setVolume(Float volume) {
        this.volume = volume;
    }
    
    @Column(name="material_name", length=64)
    public String getMaterialName() {
        return this.materialName;
    }
    
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    
    @Column(name="material_volume", precision=12, scale=0)
    public Float getMaterialVolume() {
        return this.materialVolume;
    }
    
    public void setMaterialVolume(Float materialVolume) {
        this.materialVolume = materialVolume;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="last_modified", length=10)
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
    @Column(name="file_name", length=64)
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }




}


