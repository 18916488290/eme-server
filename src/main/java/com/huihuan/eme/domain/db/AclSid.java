package com.huihuan.eme.domain.db;
// Generated 2016-2-22 12:27:37 by Hibernate Tools 3.2.2.GA


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
import javax.persistence.UniqueConstraint;

/**
 * AclSid generated by hbm2java
 */
@Entity
@Table(name="acl_sid"
    ,catalog="eme"
    , uniqueConstraints = @UniqueConstraint(columnNames={"sid", "principal"}) 
)
public class AclSid  implements java.io.Serializable {


     private Long id;
     private boolean principal;
     private String sid;
     private Set<AclObjectIdentity> aclObjectIdentities = new HashSet<AclObjectIdentity>(0);
     private Set<AclEntry> aclEntries = new HashSet<AclEntry>(0);

    public AclSid() {
    }

	
    public AclSid(boolean principal, String sid) {
        this.principal = principal;
        this.sid = sid;
    }
    public AclSid(boolean principal, String sid, Set<AclObjectIdentity> aclObjectIdentities, Set<AclEntry> aclEntries) {
       this.principal = principal;
       this.sid = sid;
       this.aclObjectIdentities = aclObjectIdentities;
       this.aclEntries = aclEntries;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="principal", nullable=false)
    public boolean isPrincipal() {
        return this.principal;
    }
    
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    
    @Column(name="sid", nullable=false, length=100)
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="aclSid")
    public Set<AclObjectIdentity> getAclObjectIdentities() {
        return this.aclObjectIdentities;
    }
    
    public void setAclObjectIdentities(Set<AclObjectIdentity> aclObjectIdentities) {
        this.aclObjectIdentities = aclObjectIdentities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="aclSid")
    public Set<AclEntry> getAclEntries() {
        return this.aclEntries;
    }
    
    public void setAclEntries(Set<AclEntry> aclEntries) {
        this.aclEntries = aclEntries;
    }




}


