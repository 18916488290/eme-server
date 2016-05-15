package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CompanyWaterEnvId generated by hbm2java
 */
@Embeddable
public class CompanyWaterEnvId  implements java.io.Serializable {


     private Long idWaterEnv;
     private Long idCompany;

    public CompanyWaterEnvId() {
    }

    public CompanyWaterEnvId(Long idWaterEnv, Long idCompany) {
       this.idWaterEnv = idWaterEnv;
       this.idCompany = idCompany;
    }
   

    @Column(name="id_water_env", nullable=false)
    public Long getIdWaterEnv() {
        return this.idWaterEnv;
    }
    
    public void setIdWaterEnv(Long idWaterEnv) {
        this.idWaterEnv = idWaterEnv;
    }

    @Column(name="id_company", nullable=false)
    public Long getIdCompany() {
        return this.idCompany;
    }
    
    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CompanyWaterEnvId) ) return false;
		 CompanyWaterEnvId castOther = ( CompanyWaterEnvId ) other; 
         
		 return ( (this.getIdWaterEnv()==castOther.getIdWaterEnv()) || ( this.getIdWaterEnv()!=null && castOther.getIdWaterEnv()!=null && this.getIdWaterEnv().equals(castOther.getIdWaterEnv()) ) )
 && ( (this.getIdCompany()==castOther.getIdCompany()) || ( this.getIdCompany()!=null && castOther.getIdCompany()!=null && this.getIdCompany().equals(castOther.getIdCompany()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdWaterEnv() == null ? 0 : this.getIdWaterEnv().hashCode() );
         result = 37 * result + ( getIdCompany() == null ? 0 : this.getIdCompany().hashCode() );
         return result;
   }   


}


