package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EnvProtPerson generated by hbm2java
 */
@Entity
@Table(name="env_prot_person"
    ,catalog="eme"
)
public class EnvProtPerson  implements java.io.Serializable {


     private Long id;
     private Company company;
     private String realName;
     private String gender;
     private String title;
     private String birth;
     private String mobile;
     private String tel;
     private String major;
     private String position;

    public EnvProtPerson() {
    }

    public EnvProtPerson(Company company, String realName, String gender, String title, String birth, String mobile, String tel, String major, String position) {
       this.company = company;
       this.realName = realName;
       this.gender = gender;
       this.title = title;
       this.birth = birth;
       this.mobile = mobile;
       this.tel = tel;
       this.major = major;
       this.position = position;
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
    
    @Column(name="real_name", length=20)
    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    @Column(name="gender", length=20)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Column(name="title", length=20)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="birth", length=20)
    public String getBirth() {
        return this.birth;
    }
    
    public void setBirth(String birth) {
        this.birth = birth;
    }
    
    @Column(name="mobile", length=20)
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="tel", length=20)
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    @Column(name="major", length=20)
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    @Column(name="position", length=20)
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }




}


