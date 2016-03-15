package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:34:42 by Hibernate Tools 3.2.2.GA


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
 * MaterialCategory generated by hbm2java
 */
@Entity
@Table(name="material_category"
    ,catalog="eme"
)
public class MaterialCategory  implements java.io.Serializable {


     private Long id;
     private String materialCategory;
     private Set<ChemicalMaterial> chemicalMaterials = new HashSet<ChemicalMaterial>(0);

    public MaterialCategory() {
    }

	
    public MaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }
    public MaterialCategory(String materialCategory, Set<ChemicalMaterial> chemicalMaterials) {
       this.materialCategory = materialCategory;
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
    
    @Column(name="material_category", nullable=false, length=64)
    public String getMaterialCategory() {
        return this.materialCategory;
    }
    
    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="materialCategory")
    public Set<ChemicalMaterial> getChemicalMaterials() {
        return this.chemicalMaterials;
    }
    
    public void setChemicalMaterials(Set<ChemicalMaterial> chemicalMaterials) {
        this.chemicalMaterials = chemicalMaterials;
    }




}


