package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


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
 * GroupAuthorities generated by hbm2java
 */
@Entity
@Table(name="group_authorities"
    ,catalog="eme"
)
public class GroupAuthorities  implements java.io.Serializable {


     private GroupAuthoritiesId id;
     private Groups groups;

    public GroupAuthorities() {
    }

    public GroupAuthorities(GroupAuthoritiesId id, Groups groups) {
       this.id = id;
       this.groups = groups;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="authority", column=@Column(name="authority", nullable=false, length=64) ), 
        @AttributeOverride(name="groupId", column=@Column(name="group_id", nullable=false) ) } )
    public GroupAuthoritiesId getId() {
        return this.id;
    }
    
    public void setId(GroupAuthoritiesId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="group_id", nullable=false, insertable=false, updatable=false)
    public Groups getGroups() {
        return this.groups;
    }
    
    public void setGroups(Groups groups) {
        this.groups = groups;
    }




}


