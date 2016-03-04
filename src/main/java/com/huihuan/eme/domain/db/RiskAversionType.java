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
 * RiskAversionType generated by hbm2java
 */
@Entity
@Table(name="risk_aversion_type"
    ,catalog="eme"
)
public class RiskAversionType  implements java.io.Serializable {


     private Long id;
     private String riskAversionType;
     private Set<RiskAversion> riskAversions = new HashSet<RiskAversion>(0);

    public RiskAversionType() {
    }

    public RiskAversionType(String riskAversionType, Set<RiskAversion> riskAversions) {
       this.riskAversionType = riskAversionType;
       this.riskAversions = riskAversions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="risk_aversion_type", length=20)
    public String getRiskAversionType() {
        return this.riskAversionType;
    }
    
    public void setRiskAversionType(String riskAversionType) {
        this.riskAversionType = riskAversionType;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="riskAversionType")
    public Set<RiskAversion> getRiskAversions() {
        return this.riskAversions;
    }
    
    public void setRiskAversions(Set<RiskAversion> riskAversions) {
        this.riskAversions = riskAversions;
    }




}


