package com.huihuan.eme.domain.db;
// Generated 2016-2-6 13:14:08 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RiskAversion generated by hbm2java
 */
@Entity
@Table(name="risk_aversion"
    ,catalog="eme"
)
public class RiskAversion  implements java.io.Serializable {


     private Long id;
     private Company company;
     private RiskAversionType riskAversionType;
     private String remark;
     private String auditor;
     private String auditOrg;
     private String fileName;
     private Set<RiskAversionOptions> riskAversionOptionses = new HashSet<RiskAversionOptions>(0);

    public RiskAversion() {
    }

    public RiskAversion(Company company, RiskAversionType riskAversionType, String remark, String auditor, String auditOrg, String fileName, Set<RiskAversionOptions> riskAversionOptionses) {
       this.company = company;
       this.riskAversionType = riskAversionType;
       this.remark = remark;
       this.auditor = auditor;
       this.auditOrg = auditOrg;
       this.fileName = fileName;
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
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_risk_aversion_type")
    public RiskAversionType getRiskAversionType() {
        return this.riskAversionType;
    }
    
    public void setRiskAversionType(RiskAversionType riskAversionType) {
        this.riskAversionType = riskAversionType;
    }
    
    @Column(name="remark", length=256)
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="auditor", length=20)
    public String getAuditor() {
        return this.auditor;
    }
    
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
    
    @Column(name="audit_org", length=64)
    public String getAuditOrg() {
        return this.auditOrg;
    }
    
    public void setAuditOrg(String auditOrg) {
        this.auditOrg = auditOrg;
    }
    
    @Column(name="file_name", length=64)
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="riskAversion")
    public Set<RiskAversionOptions> getRiskAversionOptionses() {
        return this.riskAversionOptionses;
    }
    
    public void setRiskAversionOptionses(Set<RiskAversionOptions> riskAversionOptionses) {
        this.riskAversionOptionses = riskAversionOptionses;
    }




}


