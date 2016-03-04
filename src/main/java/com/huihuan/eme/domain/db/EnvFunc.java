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
 * EnvFunc generated by hbm2java
 */
@Entity
@Table(name="env_func"
    ,catalog="eme"
)
public class EnvFunc  implements java.io.Serializable {


     private Long id;
     private String envFunc;
     private Set<WaterEnv> waterEnvs = new HashSet<WaterEnv>(0);
     private Set<AirEnv> airEnvs = new HashSet<AirEnv>(0);

    public EnvFunc() {
    }

    public EnvFunc(String envFunc, Set<WaterEnv> waterEnvs, Set<AirEnv> airEnvs) {
       this.envFunc = envFunc;
       this.waterEnvs = waterEnvs;
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
    
    @Column(name="env_func", length=20)
    public String getEnvFunc() {
        return this.envFunc;
    }
    
    public void setEnvFunc(String envFunc) {
        this.envFunc = envFunc;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="envFunc")
    public Set<WaterEnv> getWaterEnvs() {
        return this.waterEnvs;
    }
    
    public void setWaterEnvs(Set<WaterEnv> waterEnvs) {
        this.waterEnvs = waterEnvs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="envFunc")
    public Set<AirEnv> getAirEnvs() {
        return this.airEnvs;
    }
    
    public void setAirEnvs(Set<AirEnv> airEnvs) {
        this.airEnvs = airEnvs;
    }




}


