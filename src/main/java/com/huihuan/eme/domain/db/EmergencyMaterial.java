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
 * EmergencyMaterial generated by hbm2java
 */
@Entity
@Table(name="emergency_material"
    ,catalog="eme"
)
public class EmergencyMaterial  implements java.io.Serializable {


     private Long id;
     private Company company;
     private Users usersByCreator;
     private EquipmentType equipmentType;
     private Users usersByAuditor;
     private Date creationDate;
     private String materialName;
     private String quantity;
     private String materialCode;
     private String mobile;
     private String address;
     private String lat;
     private String lng;
     private String occasion;
     private String func;
     private String purpose;
     private String note;
     private Date auditDate;
     private String comment;
     private Long status;

    public EmergencyMaterial() {
    }

	
    public EmergencyMaterial(String materialName) {
        this.materialName = materialName;
    }
    public EmergencyMaterial(Company company, Users usersByCreator, EquipmentType equipmentType, Users usersByAuditor, Date creationDate, String materialName, String quantity, String materialCode, String mobile, String address, String lat, String lng, String occasion, String func, String purpose, String note, Date auditDate, String comment, Long status) {
       this.company = company;
       this.usersByCreator = usersByCreator;
       this.equipmentType = equipmentType;
       this.usersByAuditor = usersByAuditor;
       this.creationDate = creationDate;
       this.materialName = materialName;
       this.quantity = quantity;
       this.materialCode = materialCode;
       this.mobile = mobile;
       this.address = address;
       this.lat = lat;
       this.lng = lng;
       this.occasion = occasion;
       this.func = func;
       this.purpose = purpose;
       this.note = note;
       this.auditDate = auditDate;
       this.comment = comment;
       this.status = status;
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
    @JoinColumn(name="creator")
    public Users getUsersByCreator() {
        return this.usersByCreator;
    }
    
    public void setUsersByCreator(Users usersByCreator) {
        this.usersByCreator = usersByCreator;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_equipment_type")
    public EquipmentType getEquipmentType() {
        return this.equipmentType;
    }
    
    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="auditor")
    public Users getUsersByAuditor() {
        return this.usersByAuditor;
    }
    
    public void setUsersByAuditor(Users usersByAuditor) {
        this.usersByAuditor = usersByAuditor;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", length=10)
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    @Column(name="material_name", nullable=false, length=128)
    public String getMaterialName() {
        return this.materialName;
    }
    
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    
    @Column(name="quantity", length=20)
    public String getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    @Column(name="material_code", length=128)
    public String getMaterialCode() {
        return this.materialCode;
    }
    
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }
    
    @Column(name="mobile", length=64)
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="address", length=64)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
    
    @Column(name="occasion", length=64)
    public String getOccasion() {
        return this.occasion;
    }
    
    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }
    
    @Column(name="func", length=64)
    public String getFunc() {
        return this.func;
    }
    
    public void setFunc(String func) {
        this.func = func;
    }
    
    @Column(name="purpose", length=64)
    public String getPurpose() {
        return this.purpose;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    @Column(name="note", length=64)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="audit_date", length=10)
    public Date getAuditDate() {
        return this.auditDate;
    }
    
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
    
    @Column(name="comment", length=64)
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Column(name="status")
    public Long getStatus() {
        return this.status;
    }
    
    public void setStatus(Long status) {
        this.status = status;
    }




}


