package com.huihuan.eme.domain.db;
// Generated 2016-2-17 22:23:55 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CompanyAirEnvId generated by hbm2java
 */
@Embeddable
public class CompanyAirEnvId  implements java.io.Serializable {


     private Long idAirEnv;
     private Long idCompany;

    public CompanyAirEnvId() {
    }

    public CompanyAirEnvId(Long idAirEnv, Long idCompany) {
       this.idAirEnv = idAirEnv;
       this.idCompany = idCompany;
    }
   

    @Column(name="id_air_env", nullable=false)
    public Long getIdAirEnv() {
        return this.idAirEnv;
    }
    
    public void setIdAirEnv(Long idAirEnv) {
        this.idAirEnv = idAirEnv;
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
		 if ( !(other instanceof CompanyAirEnvId) ) return false;
		 CompanyAirEnvId castOther = ( CompanyAirEnvId ) other; 
         
		 return ( (this.getIdAirEnv()==castOther.getIdAirEnv()) || ( this.getIdAirEnv()!=null && castOther.getIdAirEnv()!=null && this.getIdAirEnv().equals(castOther.getIdAirEnv()) ) )
 && ( (this.getIdCompany()==castOther.getIdCompany()) || ( this.getIdCompany()!=null && castOther.getIdCompany()!=null && this.getIdCompany().equals(castOther.getIdCompany()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdAirEnv() == null ? 0 : this.getIdAirEnv().hashCode() );
         result = 37 * result + ( getIdCompany() == null ? 0 : this.getIdCompany().hashCode() );
         return result;
   }   


}


