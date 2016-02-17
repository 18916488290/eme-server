package com.huihuan.eme.domain.db;
// Generated 2016-2-17 22:23:55 by Hibernate Tools 3.2.2.GA


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
 * DetectStationContent generated by hbm2java
 */
@Entity
@Table(name="detect_station_content"
    ,catalog="eme"
)
public class DetectStationContent  implements java.io.Serializable {


     private DetectStationContentId id;
     private DetectContentDic detectContentDic;
     private DetectStation detectStation;
     private Long seq;

    public DetectStationContent() {
    }

	
    public DetectStationContent(DetectStationContentId id, DetectContentDic detectContentDic, DetectStation detectStation) {
        this.id = id;
        this.detectContentDic = detectContentDic;
        this.detectStation = detectStation;
    }
    public DetectStationContent(DetectStationContentId id, DetectContentDic detectContentDic, DetectStation detectStation, Long seq) {
       this.id = id;
       this.detectContentDic = detectContentDic;
       this.detectStation = detectStation;
       this.seq = seq;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idDectectStation", column=@Column(name="id_dectect_station", nullable=false) ), 
        @AttributeOverride(name="idDetectContent", column=@Column(name="id_detect_content", nullable=false) ) } )
    public DetectStationContentId getId() {
        return this.id;
    }
    
    public void setId(DetectStationContentId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_detect_content", nullable=false, insertable=false, updatable=false)
    public DetectContentDic getDetectContentDic() {
        return this.detectContentDic;
    }
    
    public void setDetectContentDic(DetectContentDic detectContentDic) {
        this.detectContentDic = detectContentDic;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_dectect_station", nullable=false, insertable=false, updatable=false)
    public DetectStation getDetectStation() {
        return this.detectStation;
    }
    
    public void setDetectStation(DetectStation detectStation) {
        this.detectStation = detectStation;
    }
    
    @Column(name="seq")
    public Long getSeq() {
        return this.seq;
    }
    
    public void setSeq(Long seq) {
        this.seq = seq;
    }




}


