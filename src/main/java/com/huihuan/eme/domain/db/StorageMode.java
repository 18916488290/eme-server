package com.huihuan.eme.domain.db;
// Generated 2016-4-12 13:28:14 by Hibernate Tools 3.2.2.GA


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

/**
 * StorageMode generated by hbm2java
 */
@Entity
@Table(name="storage_mode"
    ,catalog="eme"
)
public class StorageMode  implements java.io.Serializable {


     private Long id;
     private String storageMode;
     private Set<ChemicalMaterial> chemicalMaterials = new HashSet<ChemicalMaterial>(0);

    public StorageMode() {
    }

	
    public StorageMode(String storageMode) {
        this.storageMode = storageMode;
    }
    public StorageMode(String storageMode, Set<ChemicalMaterial> chemicalMaterials) {
       this.storageMode = storageMode;
       this.chemicalMaterials = chemicalMaterials;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="storage_mode", nullable=false, length=20)
    public String getStorageMode() {
        return this.storageMode;
    }
    
    public void setStorageMode(String storageMode) {
        this.storageMode = storageMode;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="storageMode")
    public Set<ChemicalMaterial> getChemicalMaterials() {
        return this.chemicalMaterials;
    }
    
    public void setChemicalMaterials(Set<ChemicalMaterial> chemicalMaterials) {
        this.chemicalMaterials = chemicalMaterials;
    }




}


