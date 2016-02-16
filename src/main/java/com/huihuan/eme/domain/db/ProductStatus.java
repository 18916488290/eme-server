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
 * ProductStatus generated by hbm2java
 */
@Entity
@Table(name="product_status"
    ,catalog="eme"
)
public class ProductStatus  implements java.io.Serializable {


     private Long id;
     private String productStatus;
     private Set<RiskBasicInfo> riskBasicInfos = new HashSet<RiskBasicInfo>(0);

    public ProductStatus() {
    }

	
    public ProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    public ProductStatus(String productStatus, Set<RiskBasicInfo> riskBasicInfos) {
       this.productStatus = productStatus;
       this.riskBasicInfos = riskBasicInfos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="product_status", nullable=false, length=20)
    public String getProductStatus() {
        return this.productStatus;
    }
    
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productStatus")
    public Set<RiskBasicInfo> getRiskBasicInfos() {
        return this.riskBasicInfos;
    }
    
    public void setRiskBasicInfos(Set<RiskBasicInfo> riskBasicInfos) {
        this.riskBasicInfos = riskBasicInfos;
    }




}


