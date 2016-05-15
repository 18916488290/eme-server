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
 * LocationDic generated by hbm2java
 */
@Entity
@Table(name="location_dic"
    ,catalog="eme"
)
public class LocationDic  implements java.io.Serializable {


     private Long id;
     private String location;
     private Set<CompanyAirEnv> companyAirEnvs = new HashSet<CompanyAirEnv>(0);

    public LocationDic() {
    }

	
    public LocationDic(String location) {
        this.location = location;
    }
    public LocationDic(String location, Set<CompanyAirEnv> companyAirEnvs) {
       this.location = location;
       this.companyAirEnvs = companyAirEnvs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="location", nullable=false, length=20)
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="locationDic")
    public Set<CompanyAirEnv> getCompanyAirEnvs() {
        return this.companyAirEnvs;
    }
    
    public void setCompanyAirEnvs(Set<CompanyAirEnv> companyAirEnvs) {
        this.companyAirEnvs = companyAirEnvs;
    }




}


