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
 * WaterEnvType generated by hbm2java
 */
@Entity
@Table(name="water_env_type"
    ,catalog="eme"
)
public class WaterEnvType  implements java.io.Serializable {


     private Long id;
     private String waterEnvType;
     private Set<WaterEnv> waterEnvs = new HashSet<WaterEnv>(0);

    public WaterEnvType() {
    }

	
    public WaterEnvType(String waterEnvType) {
        this.waterEnvType = waterEnvType;
    }
    public WaterEnvType(String waterEnvType, Set<WaterEnv> waterEnvs) {
       this.waterEnvType = waterEnvType;
       this.waterEnvs = waterEnvs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="water_env_type", nullable=false, length=64)
    public String getWaterEnvType() {
        return this.waterEnvType;
    }
    
    public void setWaterEnvType(String waterEnvType) {
        this.waterEnvType = waterEnvType;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="waterEnvType")
    public Set<WaterEnv> getWaterEnvs() {
        return this.waterEnvs;
    }
    
    public void setWaterEnvs(Set<WaterEnv> waterEnvs) {
        this.waterEnvs = waterEnvs;
    }




}


