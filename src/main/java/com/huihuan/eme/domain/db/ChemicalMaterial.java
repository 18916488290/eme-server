package com.huihuan.eme.domain.db;
// Generated 2016-4-12 13:28:14 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChemicalMaterial generated by hbm2java
 */
@Entity
@Table(name="chemical_material"
    ,catalog="eme"
)
public class ChemicalMaterial  implements java.io.Serializable {


     private Long id;
     private Company company;
     private EquipmentState equipmentState;
     private MaterialCategory materialCategory;
     private ProductionMode productionMode;
     private PhysicalState physicalState;
     private MaterialType materialType;
     private StorageMode storageMode;
     private String materialName;
     private String chemicalName;
     private String cas;
     private Float quantity;
     private Float annualOutput;
     private String purpose;
     private Boolean isHazardous;

    public ChemicalMaterial() {
    }

    public ChemicalMaterial(Company company, EquipmentState equipmentState, MaterialCategory materialCategory, ProductionMode productionMode, PhysicalState physicalState, MaterialType materialType, StorageMode storageMode, String materialName, String chemicalName, String cas, Float quantity, Float annualOutput, String purpose, Boolean isHazardous) {
       this.company = company;
       this.equipmentState = equipmentState;
       this.materialCategory = materialCategory;
       this.productionMode = productionMode;
       this.physicalState = physicalState;
       this.materialType = materialType;
       this.storageMode = storageMode;
       this.materialName = materialName;
       this.chemicalName = chemicalName;
       this.cas = cas;
       this.quantity = quantity;
       this.annualOutput = annualOutput;
       this.purpose = purpose;
       this.isHazardous = isHazardous;
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
    @JoinColumn(name="id_equipment_state")
    public EquipmentState getEquipmentState() {
        return this.equipmentState;
    }
    
    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_material_category")
    public MaterialCategory getMaterialCategory() {
        return this.materialCategory;
    }
    
    public void setMaterialCategory(MaterialCategory materialCategory) {
        this.materialCategory = materialCategory;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_production_mode")
    public ProductionMode getProductionMode() {
        return this.productionMode;
    }
    
    public void setProductionMode(ProductionMode productionMode) {
        this.productionMode = productionMode;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_physical_state")
    public PhysicalState getPhysicalState() {
        return this.physicalState;
    }
    
    public void setPhysicalState(PhysicalState physicalState) {
        this.physicalState = physicalState;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_material_type")
    public MaterialType getMaterialType() {
        return this.materialType;
    }
    
    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_storage_mode")
    public StorageMode getStorageMode() {
        return this.storageMode;
    }
    
    public void setStorageMode(StorageMode storageMode) {
        this.storageMode = storageMode;
    }
    
    @Column(name="material_name", length=64)
    public String getMaterialName() {
        return this.materialName;
    }
    
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    
    @Column(name="chemical_name", length=64)
    public String getChemicalName() {
        return this.chemicalName;
    }
    
    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }
    
    @Column(name="cas", length=64)
    public String getCas() {
        return this.cas;
    }
    
    public void setCas(String cas) {
        this.cas = cas;
    }
    
    @Column(name="quantity", precision=12, scale=0)
    public Float getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
    
    @Column(name="annual_output", precision=12, scale=0)
    public Float getAnnualOutput() {
        return this.annualOutput;
    }
    
    public void setAnnualOutput(Float annualOutput) {
        this.annualOutput = annualOutput;
    }
    
    @Column(name="purpose", length=64)
    public String getPurpose() {
        return this.purpose;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    @Column(name="is_hazardous")
    public Boolean getIsHazardous() {
        return this.isHazardous;
    }
    
    public void setIsHazardous(Boolean isHazardous) {
        this.isHazardous = isHazardous;
    }




}


