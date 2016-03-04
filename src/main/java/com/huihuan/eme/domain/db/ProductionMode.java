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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductionMode generated by hbm2java
 */
@Entity
@Table(name="production_mode"
    ,catalog="eme"
)
public class ProductionMode  implements java.io.Serializable {


     private Long id;
     private String productionMode;
     private Set<ChemicalMaterial> chemicalMaterials = new HashSet<ChemicalMaterial>(0);

    public ProductionMode() {
    }

	
    public ProductionMode(String productionMode) {
        this.productionMode = productionMode;
    }
    public ProductionMode(String productionMode, Set<ChemicalMaterial> chemicalMaterials) {
       this.productionMode = productionMode;
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
    
    @Column(name="production_mode", nullable=false, length=20)
    public String getProductionMode() {
        return this.productionMode;
    }
    
    public void setProductionMode(String productionMode) {
        this.productionMode = productionMode;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productionMode")
    public Set<ChemicalMaterial> getChemicalMaterials() {
        return this.chemicalMaterials;
    }
    
    public void setChemicalMaterials(Set<ChemicalMaterial> chemicalMaterials) {
        this.chemicalMaterials = chemicalMaterials;
    }




}


