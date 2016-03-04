package com.huihuan.eme.domain.db;
// Generated 2016-3-3 16:33:56 by Hibernate Tools 3.2.2.GA


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
import javax.persistence.UniqueConstraint;

/**
 * AclObjectIdentity generated by hbm2java
 */
@Entity
@Table(name="acl_object_identity"
    ,catalog="eme"
    , uniqueConstraints = @UniqueConstraint(columnNames={"object_id_class", "object_id_identity"}) 
)
public class AclObjectIdentity  implements java.io.Serializable {


     private Long id;
     private AclClass aclClass;
     private AclObjectIdentity aclObjectIdentity;
     private AclSid aclSid;
     private long objectIdIdentity;
     private boolean entriesInheriting;
     private Set<AclObjectIdentity> aclObjectIdentities = new HashSet<AclObjectIdentity>(0);
     private Set<AclEntry> aclEntries = new HashSet<AclEntry>(0);

    public AclObjectIdentity() {
    }

	
    public AclObjectIdentity(AclClass aclClass, long objectIdIdentity, boolean entriesInheriting) {
        this.aclClass = aclClass;
        this.objectIdIdentity = objectIdIdentity;
        this.entriesInheriting = entriesInheriting;
    }
    public AclObjectIdentity(AclClass aclClass, AclObjectIdentity aclObjectIdentity, AclSid aclSid, long objectIdIdentity, boolean entriesInheriting, Set<AclObjectIdentity> aclObjectIdentities, Set<AclEntry> aclEntries) {
       this.aclClass = aclClass;
       this.aclObjectIdentity = aclObjectIdentity;
       this.aclSid = aclSid;
       this.objectIdIdentity = objectIdIdentity;
       this.entriesInheriting = entriesInheriting;
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
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="object_id_class", nullable=false)
    public AclClass getAclClass() {
        return this.aclClass;
    }
    
    public void setAclClass(AclClass aclClass) {
        this.aclClass = aclClass;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_object")
    public AclObjectIdentity getAclObjectIdentity() {
        return this.aclObjectIdentity;
    }
    
    public void setAclObjectIdentity(AclObjectIdentity aclObjectIdentity) {
        this.aclObjectIdentity = aclObjectIdentity;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner_sid")
    public AclSid getAclSid() {
        return this.aclSid;
    }
    
    public void setAclSid(AclSid aclSid) {
        this.aclSid = aclSid;
    }
    
    @Column(name="object_id_identity", nullable=false)
    public long getObjectIdIdentity() {
        return this.objectIdIdentity;
    }
    
    public void setObjectIdIdentity(long objectIdIdentity) {
        this.objectIdIdentity = objectIdIdentity;
    }
    
    @Column(name="entries_inheriting", nullable=false)
    public boolean isEntriesInheriting() {
        return this.entriesInheriting;
    }
    
    public void setEntriesInheriting(boolean entriesInheriting) {
        this.entriesInheriting = entriesInheriting;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="aclObjectIdentity")
    public Set<AclObjectIdentity> getAclObjectIdentities() {
        return this.aclObjectIdentities;
    }
    
    public void setAclObjectIdentities(Set<AclObjectIdentity> aclObjectIdentities) {
        this.aclObjectIdentities = aclObjectIdentities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="aclObjectIdentity")
    public Set<AclEntry> getAclEntries() {
        return this.aclEntries;
    }
    
    public void setAclEntries(Set<AclEntry> aclEntries) {
        this.aclEntries = aclEntries;
    }




}


