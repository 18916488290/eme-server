package com.huihuan.eme.domain.db;
// Generated 2016-2-16 22:08:48 by Hibernate Tools 3.2.2.GA


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
 * RiskAversionOptionsDic generated by hbm2java
 */
@Entity
@Table(name="risk_aversion_options_dic"
    ,catalog="eme"
)
public class RiskAversionOptionsDic  implements java.io.Serializable {


     private Long id;
     private String riskAversionOptions;
     private Set<RiskAversionOptions> riskAversionOptionses = new HashSet<RiskAversionOptions>(0);

    public RiskAversionOptionsDic() {
    }

	
    public RiskAversionOptionsDic(String riskAversionOptions) {
        this.riskAversionOptions = riskAversionOptions;
    }
    public RiskAversionOptionsDic(String riskAversionOptions, Set<RiskAversionOptions> riskAversionOptionses) {
       this.riskAversionOptions = riskAversionOptions;
       this.riskAversionOptionses = riskAversionOptionses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="risk_aversion_options", nullable=false, length=64)
    public String getRiskAversionOptions() {
        return this.riskAversionOptions;
    }
    
    public void setRiskAversionOptions(String riskAversionOptions) {
        this.riskAversionOptions = riskAversionOptions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="riskAversionOptionsDic")
    public Set<RiskAversionOptions> getRiskAversionOptionses() {
        return this.riskAversionOptionses;
    }
    
    public void setRiskAversionOptionses(Set<RiskAversionOptions> riskAversionOptionses) {
        this.riskAversionOptionses = riskAversionOptionses;
    }




}


