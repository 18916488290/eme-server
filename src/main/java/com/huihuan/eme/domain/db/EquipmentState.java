package com.huihuan.eme.domain.db;
// Generated 2016-2-22 12:27:37 by Hibernate Tools 3.2.2.GA


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
 * EquipmentState generated by hbm2java
 */
@Entity
@Table(name="equipment_state"
    ,catalog="eme"
)
public class EquipmentState  implements java.io.Serializable {


     private Long id;
     private String equipmentState;
     private Set<ChemicalMaterial> chemicalMaterials = new HashSet<ChemicalMaterial>(0);

    public EquipmentState() {
    }

	
    public EquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }
    public EquipmentState(String equipmentState, Set<ChemicalMaterial> chemicalMaterials) {
       this.equipmentState = equipmentState;
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
    
    @Column(name="equipment_state", nullable=false, length=20)
    public String getEquipmentState() {
        return this.equipmentState;
    }
    
    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="equipmentState")
    public Set<ChemicalMaterial> getChemicalMaterials() {
        return this.chemicalMaterials;
    }
    
    public void setChemicalMaterials(Set<ChemicalMaterial> chemicalMaterials) {
        this.chemicalMaterials = chemicalMaterials;
    }




}


