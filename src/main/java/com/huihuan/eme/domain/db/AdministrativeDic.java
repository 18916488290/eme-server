package com.huihuan.eme.domain.db;
// Generated 2016-4-12 13:28:14 by Hibernate Tools 3.2.2.GA


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
 * AdministrativeDic generated by hbm2java
 */
@Entity
@Table(name="administrative_dic"
    ,catalog="eme"
)
public class AdministrativeDic  implements java.io.Serializable {


     private Long id;
     private String administrative;
     private Set<Company> companies = new HashSet<Company>(0);

    public AdministrativeDic() {
    }

	
    public AdministrativeDic(String administrative) {
        this.administrative = administrative;
    }
    public AdministrativeDic(String administrative, Set<Company> companies) {
       this.administrative = administrative;
       this.companies = companies;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="administrative", nullable=false, length=64)
    public String getAdministrative() {
        return this.administrative;
    }
    
    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="administrativeDic")
    public Set<Company> getCompanies() {
        return this.companies;
    }
    
    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }




}


