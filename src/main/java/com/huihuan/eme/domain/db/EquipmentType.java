package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


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
 * EquipmentType generated by hbm2java
 */
@Entity
@Table(name="equipment_type"
    ,catalog="eme"
)
public class EquipmentType  implements java.io.Serializable {


     private Long id;
     private String equipmentType;
     private Set<EmergencyMaterial> emergencyMaterials = new HashSet<EmergencyMaterial>(0);

    public EquipmentType() {
    }

    public EquipmentType(String equipmentType, Set<EmergencyMaterial> emergencyMaterials) {
       this.equipmentType = equipmentType;
       this.emergencyMaterials = emergencyMaterials;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="equipment_type", length=20)
    public String getEquipmentType() {
        return this.equipmentType;
    }
    
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="equipmentType")
    public Set<EmergencyMaterial> getEmergencyMaterials() {
        return this.emergencyMaterials;
    }
    
    public void setEmergencyMaterials(Set<EmergencyMaterial> emergencyMaterials) {
        this.emergencyMaterials = emergencyMaterials;
    }




}


