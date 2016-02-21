package com.huihuan.eme.domain.db;
// Generated 2016-2-21 10:11:30 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PersistentLogins generated by hbm2java
 */
@Entity
@Table(name="persistent_logins"
    ,catalog="eme"
)
public class PersistentLogins  implements java.io.Serializable {


     private String series;
     private Users users;
     private String token;
     private Date lastUsed;

    public PersistentLogins() {
    }

    public PersistentLogins(String series, Users users, String token, Date lastUsed) {
       this.series = series;
       this.users = users;
       this.token = token;
       this.lastUsed = lastUsed;
    }
   
     @Id 
    
    @Column(name="series", unique=true, nullable=false, length=64)
    public String getSeries() {
        return this.series;
    }
    
    public void setSeries(String series) {
        this.series = series;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Column(name="token", nullable=false, length=64)
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_used", nullable=false, length=19)
    public Date getLastUsed() {
        return this.lastUsed;
    }
    
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }




}


