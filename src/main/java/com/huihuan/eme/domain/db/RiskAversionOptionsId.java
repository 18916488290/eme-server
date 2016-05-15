package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RiskAversionOptionsId generated by hbm2java
 */
@Embeddable
public class RiskAversionOptionsId  implements java.io.Serializable {


     private Long idRiskAversion;
     private Long idRiskAversionOption;

    public RiskAversionOptionsId() {
    }

    public RiskAversionOptionsId(Long idRiskAversion, Long idRiskAversionOption) {
       this.idRiskAversion = idRiskAversion;
       this.idRiskAversionOption = idRiskAversionOption;
    }
   

    @Column(name="id_risk_aversion", nullable=false)
    public Long getIdRiskAversion() {
        return this.idRiskAversion;
    }
    
    public void setIdRiskAversion(Long idRiskAversion) {
        this.idRiskAversion = idRiskAversion;
    }

    @Column(name="id_risk_aversion_option", nullable=false)
    public Long getIdRiskAversionOption() {
        return this.idRiskAversionOption;
    }
    
    public void setIdRiskAversionOption(Long idRiskAversionOption) {
        this.idRiskAversionOption = idRiskAversionOption;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RiskAversionOptionsId) ) return false;
		 RiskAversionOptionsId castOther = ( RiskAversionOptionsId ) other; 
         
		 return ( (this.getIdRiskAversion()==castOther.getIdRiskAversion()) || ( this.getIdRiskAversion()!=null && castOther.getIdRiskAversion()!=null && this.getIdRiskAversion().equals(castOther.getIdRiskAversion()) ) )
 && ( (this.getIdRiskAversionOption()==castOther.getIdRiskAversionOption()) || ( this.getIdRiskAversionOption()!=null && castOther.getIdRiskAversionOption()!=null && this.getIdRiskAversionOption().equals(castOther.getIdRiskAversionOption()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdRiskAversion() == null ? 0 : this.getIdRiskAversion().hashCode() );
         result = 37 * result + ( getIdRiskAversionOption() == null ? 0 : this.getIdRiskAversionOption().hashCode() );
         return result;
   }   


}


