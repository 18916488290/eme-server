package com.huihuan.eme.domain.db;
// Generated 2016-3-15 21:08:08 by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RiskAversionOptions generated by hbm2java
 */
@Entity
@Table(name="risk_aversion_options"
    ,catalog="eme"
)
public class RiskAversionOptions  implements java.io.Serializable {


     private RiskAversionOptionsId id;
     private RiskAversion riskAversion;
     private RiskAversionOptionsDic riskAversionOptionsDic;
     private boolean checked;

    public RiskAversionOptions() {
    }

    public RiskAversionOptions(RiskAversionOptionsId id, RiskAversion riskAversion, RiskAversionOptionsDic riskAversionOptionsDic, boolean checked) {
       this.id = id;
       this.riskAversion = riskAversion;
       this.riskAversionOptionsDic = riskAversionOptionsDic;
       this.checked = checked;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idRiskAversion", column=@Column(name="id_risk_aversion", nullable=false) ), 
        @AttributeOverride(name="idRiskAversionOption", column=@Column(name="id_risk_aversion_option", nullable=false) ) } )
    public RiskAversionOptionsId getId() {
        return this.id;
    }
    
    public void setId(RiskAversionOptionsId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_risk_aversion", nullable=false, insertable=false, updatable=false)
    public RiskAversion getRiskAversion() {
        return this.riskAversion;
    }
    
    public void setRiskAversion(RiskAversion riskAversion) {
        this.riskAversion = riskAversion;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_risk_aversion_option", nullable=false, insertable=false, updatable=false)
    public RiskAversionOptionsDic getRiskAversionOptionsDic() {
        return this.riskAversionOptionsDic;
    }
    
    public void setRiskAversionOptionsDic(RiskAversionOptionsDic riskAversionOptionsDic) {
        this.riskAversionOptionsDic = riskAversionOptionsDic;
    }
    
    @Column(name="checked", nullable=false)
    public boolean isChecked() {
        return this.checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }




}


