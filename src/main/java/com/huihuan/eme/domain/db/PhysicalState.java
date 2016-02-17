package com.huihuan.eme.domain.db;
// Generated 2016-2-17 22:23:55 by Hibernate Tools 3.2.2.GA


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
 * PhysicalState generated by hbm2java
 */
@Entity
@Table(name="physical_state"
    ,catalog="eme"
)
public class PhysicalState  implements java.io.Serializable {


     private Long id;
     private String physicalState;
     private Set<ChemicalMaterial> chemicalMaterials = new HashSet<ChemicalMaterial>(0);

    public PhysicalState() {
    }

	
    public PhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }
    public PhysicalState(String physicalState, Set<ChemicalMaterial> chemicalMaterials) {
       this.physicalState = physicalState;
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
    
    @Column(name="physical_state", nullable=false, length=20)
    public String getPhysicalState() {
        return this.physicalState;
    }
    
    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="physicalState")
    public Set<ChemicalMaterial> getChemicalMaterials() {
        return this.chemicalMaterials;
    }
    
    public void setChemicalMaterials(Set<ChemicalMaterial> chemicalMaterials) {
        this.chemicalMaterials = chemicalMaterials;
    }




}


