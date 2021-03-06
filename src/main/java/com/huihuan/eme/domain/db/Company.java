package com.huihuan.eme.domain.db;
// Generated 2016-5-4 11:02:30 by Hibernate Tools 3.2.2.GA


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="company"
    ,catalog="eme"
)
public class Company  implements java.io.Serializable {


     private Long id;
     private AdministrativeDic administrativeDic;
     private AdministrativeDivision administrativeDivision;
     private HousePlan housePlan;
     private OperationMaintanceCompany operationMaintanceCompany;
     private Users usersByCreator;
     private Users usersByAuditor;
     private ConcernDegreeDic concernDegreeDic;
     private IndustrySectorDic industrySectorDic;
     private Date creationDate;
     private String companyName;
     private String lat;
     private String lng;
     private String address;
     private Date auditDate;
     private String comment;
     private Long status;
     private String registrationCode;
     private String licenseCode;
     private String corporation;
     private String corporationFax;
     private String url360;
     private Set<ChemicalMaterial> chemicalMaterials = new HashSet<ChemicalMaterial>(0);
     private Set<WarehouseRisk> warehouseRisks = new HashSet<WarehouseRisk>(0);
     private Set<CompanyAirEnv> companyAirEnvs = new HashSet<CompanyAirEnv>(0);
     private Set<EnvProtPerson> envProtPersons = new HashSet<EnvProtPerson>(0);
     private Set<RiskAversion> riskAversions = new HashSet<RiskAversion>(0);
     private Set<EmergencyResponsePlan> emergencyResponsePlans = new HashSet<EmergencyResponsePlan>(0);
     private Set<Workmanship> workmanships = new HashSet<Workmanship>(0);
     private Set<DataCollectionDevice> dataCollectionDevices = new HashSet<DataCollectionDevice>(0);
     private Set<RiskBasicInfo> riskBasicInfos = new HashSet<RiskBasicInfo>(0);
     private Set<PullantSource> pullantSources = new HashSet<PullantSource>(0);
     private Set<EquipmentRisk> equipmentRisks = new HashSet<EquipmentRisk>(0);
     private Set<CompanyWaterEnv> companyWaterEnvs = new HashSet<CompanyWaterEnv>(0);
     private Set<EmergencyMaterial> emergencyMaterials = new HashSet<EmergencyMaterial>(0);

    public Company() {
    }

	
    public Company(Users usersByCreator, String companyName, Long status) {
        this.usersByCreator = usersByCreator;
        this.companyName = companyName;
        this.status = status;
    }
    public Company(AdministrativeDic administrativeDic, AdministrativeDivision administrativeDivision, HousePlan housePlan, OperationMaintanceCompany operationMaintanceCompany, Users usersByCreator, Users usersByAuditor, ConcernDegreeDic concernDegreeDic, IndustrySectorDic industrySectorDic, Date creationDate, String companyName, String lat, String lng, String address, Date auditDate, String comment, Long status, String registrationCode, String licenseCode, String corporation, String corporationFax, String url360, Set<ChemicalMaterial> chemicalMaterials, Set<WarehouseRisk> warehouseRisks, Set<CompanyAirEnv> companyAirEnvs, Set<EnvProtPerson> envProtPersons, Set<RiskAversion> riskAversions, Set<EmergencyResponsePlan> emergencyResponsePlans, Set<Workmanship> workmanships, Set<DataCollectionDevice> dataCollectionDevices, Set<RiskBasicInfo> riskBasicInfos, Set<PullantSource> pullantSources, Set<EquipmentRisk> equipmentRisks, Set<CompanyWaterEnv> companyWaterEnvs, Set<EmergencyMaterial> emergencyMaterials) {
       this.administrativeDic = administrativeDic;
       this.administrativeDivision = administrativeDivision;
       this.housePlan = housePlan;
       this.operationMaintanceCompany = operationMaintanceCompany;
       this.usersByCreator = usersByCreator;
       this.usersByAuditor = usersByAuditor;
       this.concernDegreeDic = concernDegreeDic;
       this.industrySectorDic = industrySectorDic;
       this.creationDate = creationDate;
       this.companyName = companyName;
       this.lat = lat;
       this.lng = lng;
       this.address = address;
       this.auditDate = auditDate;
       this.comment = comment;
       this.status = status;
       this.registrationCode = registrationCode;
       this.licenseCode = licenseCode;
       this.corporation = corporation;
       this.corporationFax = corporationFax;
       this.url360 = url360;
       this.chemicalMaterials = chemicalMaterials;
       this.warehouseRisks = warehouseRisks;
       this.companyAirEnvs = companyAirEnvs;
       this.envProtPersons = envProtPersons;
       this.riskAversions = riskAversions;
       this.emergencyResponsePlans = emergencyResponsePlans;
       this.workmanships = workmanships;
       this.dataCollectionDevices = dataCollectionDevices;
       this.riskBasicInfos = riskBasicInfos;
       this.pullantSources = pullantSources;
       this.equipmentRisks = equipmentRisks;
       this.companyWaterEnvs = companyWaterEnvs;
       this.emergencyMaterials = emergencyMaterials;
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
    @JoinColumn(name="id_administrative")
    public AdministrativeDic getAdministrativeDic() {
        return this.administrativeDic;
    }
    
    public void setAdministrativeDic(AdministrativeDic administrativeDic) {
        this.administrativeDic = administrativeDic;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_administrative_division")
    public AdministrativeDivision getAdministrativeDivision() {
        return this.administrativeDivision;
    }
    
    public void setAdministrativeDivision(AdministrativeDivision administrativeDivision) {
        this.administrativeDivision = administrativeDivision;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_house_plan")
    public HousePlan getHousePlan() {
        return this.housePlan;
    }
    
    public void setHousePlan(HousePlan housePlan) {
        this.housePlan = housePlan;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_operation_maintance_company")
    public OperationMaintanceCompany getOperationMaintanceCompany() {
        return this.operationMaintanceCompany;
    }
    
    public void setOperationMaintanceCompany(OperationMaintanceCompany operationMaintanceCompany) {
        this.operationMaintanceCompany = operationMaintanceCompany;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creator", nullable=false)
    public Users getUsersByCreator() {
        return this.usersByCreator;
    }
    
    public void setUsersByCreator(Users usersByCreator) {
        this.usersByCreator = usersByCreator;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="auditor")
    public Users getUsersByAuditor() {
        return this.usersByAuditor;
    }
    
    public void setUsersByAuditor(Users usersByAuditor) {
        this.usersByAuditor = usersByAuditor;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_concern_degree")
    public ConcernDegreeDic getConcernDegreeDic() {
        return this.concernDegreeDic;
    }
    
    public void setConcernDegreeDic(ConcernDegreeDic concernDegreeDic) {
        this.concernDegreeDic = concernDegreeDic;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_industry_sector")
    public IndustrySectorDic getIndustrySectorDic() {
        return this.industrySectorDic;
    }
    
    public void setIndustrySectorDic(IndustrySectorDic industrySectorDic) {
        this.industrySectorDic = industrySectorDic;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", length=10)
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    @Column(name="company_name", nullable=false, length=128)
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    @Column(name="lat", length=20)
    public String getLat() {
        return this.lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }
    
    @Column(name="lng", length=20)
    public String getLng() {
        return this.lng;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }
    
    @Column(name="address", length=256)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="audit_date", length=10)
    public Date getAuditDate() {
        return this.auditDate;
    }
    
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
    
    @Column(name="comment", length=128)
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Column(name="status", nullable=false)
    public Long getStatus() {
        return this.status;
    }
    
    public void setStatus(Long status) {
        this.status = status;
    }
    
    @Column(name="registration_code", length=64)
    public String getRegistrationCode() {
        return this.registrationCode;
    }
    
    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }
    
    @Column(name="license_code", length=64)
    public String getLicenseCode() {
        return this.licenseCode;
    }
    
    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }
    
    @Column(name="corporation", length=20)
    public String getCorporation() {
        return this.corporation;
    }
    
    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }
    
    @Column(name="corporation_fax", length=20)
    public String getCorporationFax() {
        return this.corporationFax;
    }
    
    public void setCorporationFax(String corporationFax) {
        this.corporationFax = corporationFax;
    }
    
    @Column(name="url_360", length=256)
    public String getUrl360() {
        return this.url360;
    }
    
    public void setUrl360(String url360) {
        this.url360 = url360;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<ChemicalMaterial> getChemicalMaterials() {
        return this.chemicalMaterials;
    }
    
    public void setChemicalMaterials(Set<ChemicalMaterial> chemicalMaterials) {
        this.chemicalMaterials = chemicalMaterials;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<WarehouseRisk> getWarehouseRisks() {
        return this.warehouseRisks;
    }
    
    public void setWarehouseRisks(Set<WarehouseRisk> warehouseRisks) {
        this.warehouseRisks = warehouseRisks;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<CompanyAirEnv> getCompanyAirEnvs() {
        return this.companyAirEnvs;
    }
    
    public void setCompanyAirEnvs(Set<CompanyAirEnv> companyAirEnvs) {
        this.companyAirEnvs = companyAirEnvs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<EnvProtPerson> getEnvProtPersons() {
        return this.envProtPersons;
    }
    
    public void setEnvProtPersons(Set<EnvProtPerson> envProtPersons) {
        this.envProtPersons = envProtPersons;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<RiskAversion> getRiskAversions() {
        return this.riskAversions;
    }
    
    public void setRiskAversions(Set<RiskAversion> riskAversions) {
        this.riskAversions = riskAversions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<EmergencyResponsePlan> getEmergencyResponsePlans() {
        return this.emergencyResponsePlans;
    }
    
    public void setEmergencyResponsePlans(Set<EmergencyResponsePlan> emergencyResponsePlans) {
        this.emergencyResponsePlans = emergencyResponsePlans;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<Workmanship> getWorkmanships() {
        return this.workmanships;
    }
    
    public void setWorkmanships(Set<Workmanship> workmanships) {
        this.workmanships = workmanships;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<DataCollectionDevice> getDataCollectionDevices() {
        return this.dataCollectionDevices;
    }
    
    public void setDataCollectionDevices(Set<DataCollectionDevice> dataCollectionDevices) {
        this.dataCollectionDevices = dataCollectionDevices;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<RiskBasicInfo> getRiskBasicInfos() {
        return this.riskBasicInfos;
    }
    
    public void setRiskBasicInfos(Set<RiskBasicInfo> riskBasicInfos) {
        this.riskBasicInfos = riskBasicInfos;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<PullantSource> getPullantSources() {
        return this.pullantSources;
    }
    
    public void setPullantSources(Set<PullantSource> pullantSources) {
        this.pullantSources = pullantSources;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<EquipmentRisk> getEquipmentRisks() {
        return this.equipmentRisks;
    }
    
    public void setEquipmentRisks(Set<EquipmentRisk> equipmentRisks) {
        this.equipmentRisks = equipmentRisks;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<CompanyWaterEnv> getCompanyWaterEnvs() {
        return this.companyWaterEnvs;
    }
    
    public void setCompanyWaterEnvs(Set<CompanyWaterEnv> companyWaterEnvs) {
        this.companyWaterEnvs = companyWaterEnvs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="company")
    public Set<EmergencyMaterial> getEmergencyMaterials() {
        return this.emergencyMaterials;
    }
    
    public void setEmergencyMaterials(Set<EmergencyMaterial> emergencyMaterials) {
        this.emergencyMaterials = emergencyMaterials;
    }




}


