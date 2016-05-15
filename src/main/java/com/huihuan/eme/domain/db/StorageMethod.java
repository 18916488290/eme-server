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
 * StorageMethod generated by hbm2java
 */
@Entity
@Table(name="storage_method"
    ,catalog="eme"
)
public class StorageMethod  implements java.io.Serializable {


     private Long id;
     private String storageMethod;
     private Set<WarehouseRisk> warehouseRisks = new HashSet<WarehouseRisk>(0);

    public StorageMethod() {
    }

	
    public StorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }
    public StorageMethod(String storageMethod, Set<WarehouseRisk> warehouseRisks) {
       this.storageMethod = storageMethod;
       this.warehouseRisks = warehouseRisks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="storage_method", nullable=false, length=20)
    public String getStorageMethod() {
        return this.storageMethod;
    }
    
    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="storageMethod")
    public Set<WarehouseRisk> getWarehouseRisks() {
        return this.warehouseRisks;
    }
    
    public void setWarehouseRisks(Set<WarehouseRisk> warehouseRisks) {
        this.warehouseRisks = warehouseRisks;
    }




}


