package com.huihuan.eme.domain.db;
// Generated 2016-2-21 10:11:30 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EmergencyReponsePlanType generated by hbm2java
 */
@Entity
@Table(name="emergency_reponse_plan_type"
    ,catalog="eme"
)
public class EmergencyReponsePlanType  implements java.io.Serializable {


     private Long id;
     private String emergencyResponsePlanType;
     private Set<EmergencyResponsePlan> emergencyResponsePlans = new HashSet<EmergencyResponsePlan>(0);

    public EmergencyReponsePlanType() {
    }

	
    public EmergencyReponsePlanType(Long id) {
        this.id = id;
    }
    public EmergencyReponsePlanType(Long id, String emergencyResponsePlanType, Set<EmergencyResponsePlan> emergencyResponsePlans) {
       this.id = id;
       this.emergencyResponsePlanType = emergencyResponsePlanType;
       this.emergencyResponsePlans = emergencyResponsePlans;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="emergency_response_plan_type", length=20)
    public String getEmergencyResponsePlanType() {
        return this.emergencyResponsePlanType;
    }
    
    public void setEmergencyResponsePlanType(String emergencyResponsePlanType) {
        this.emergencyResponsePlanType = emergencyResponsePlanType;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="emergencyReponsePlanType")
    public Set<EmergencyResponsePlan> getEmergencyResponsePlans() {
        return this.emergencyResponsePlans;
    }
    
    public void setEmergencyResponsePlans(Set<EmergencyResponsePlan> emergencyResponsePlans) {
        this.emergencyResponsePlans = emergencyResponsePlans;
    }




}


