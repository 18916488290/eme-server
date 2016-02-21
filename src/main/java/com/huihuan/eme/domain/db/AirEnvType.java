package com.huihuan.eme.domain.db;
// Generated 2016-2-21 10:11:30 by Hibernate Tools 3.2.2.GA


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
 * AirEnvType generated by hbm2java
 */
@Entity
@Table(name="air_env_type"
    ,catalog="eme"
)
public class AirEnvType  implements java.io.Serializable {


     private Long id;
     private String airEnvType;
     private Set<AirEnv> airEnvs = new HashSet<AirEnv>(0);

    public AirEnvType() {
    }

	
    public AirEnvType(String airEnvType) {
        this.airEnvType = airEnvType;
    }
    public AirEnvType(String airEnvType, Set<AirEnv> airEnvs) {
       this.airEnvType = airEnvType;
       this.airEnvs = airEnvs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="air_env_type", nullable=false, length=64)
    public String getAirEnvType() {
        return this.airEnvType;
    }
    
    public void setAirEnvType(String airEnvType) {
        this.airEnvType = airEnvType;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="airEnvType")
    public Set<AirEnv> getAirEnvs() {
        return this.airEnvs;
    }
    
    public void setAirEnvs(Set<AirEnv> airEnvs) {
        this.airEnvs = airEnvs;
    }




}


