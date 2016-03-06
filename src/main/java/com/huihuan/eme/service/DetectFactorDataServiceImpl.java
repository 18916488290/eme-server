package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;
import com.huihuan.eme.domain.db.AdministrativeDivision;
import com.huihuan.eme.domain.db.AqiInfo;
import com.huihuan.eme.domain.db.DataCollectionDevice;
import com.huihuan.eme.domain.db.DetectCategory;
import com.huihuan.eme.domain.db.DetectContentDic;
import com.huihuan.eme.domain.db.DetectFactor;
import com.huihuan.eme.domain.db.DetectStation;
import com.huihuan.eme.domain.db.DetectStationContent;
import com.huihuan.eme.domain.db.DetectStationContentId;
import com.huihuan.eme.domain.db.IaqiInfo;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.AqiInfoRepository;
import com.huihuan.eme.repository.DataCollectionDeviceRepository;
import com.huihuan.eme.repository.DetectCategoryRepository;
import com.huihuan.eme.repository.DetectContentDicRepository;
import com.huihuan.eme.repository.DetectFactorRepository;
import com.huihuan.eme.repository.DetectStationContentRepository;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.EpbRepository;
import com.huihuan.eme.repository.IaqiInfoRepository;

@Service("detectFactorDataServiceImpl")
public class DetectFactorDataServiceImpl {
	
	
	@Autowired private DetectCategoryRepository detectCategoryRepository;
	private String[] detectCategories = new String[] { "废水", "废气", "重金属","空气质量"};
	
	@Autowired private DetectContentDicRepository detectContentDicRepository;
	private String[] detectContentDics = new String[] { "空气质量", "地表水", "在线检测"};
	
	@Autowired private AdministrativeDivisionRepository administrativeDivisionRepository;
	@Autowired private EpbRepository epbRepository;
	@Autowired private DetectStationRepository detectStationRepository;
	@Autowired private DetectStationContentRepository detectStationContentRepository;
	@Autowired private DataCollectionDeviceRepository dataCollectionDeviceRepository;
	@Autowired private AqiInfoRepository aqiInfoRepository;
	@Autowired private DetectFactorRepository detectFactorRepository;
	@Autowired private IaqiInfoRepository iaqiInfoRepository;
	
	private static final Log logger = LogFactory.getLog(DetectFactorDataServiceImpl.class);

	@Transactional(readOnly=false)
	public void loadData(ConfigurableApplicationContext ctx) throws IOException
	{
		/**检测因子分类： 废水，废气，重金属*/
		for(String s:detectCategories)
		{
			DetectCategory dc = new DetectCategory();
			dc.setDetectCategory(s);
			detectCategoryRepository.save(dc);
		}
		
		/**检测内容： 空气质量，在线检测，等*/
		for(String s:detectContentDics)
		{
			DetectContentDic dc = new DetectContentDic();
			dc.setDetectContent(s);
			detectContentDicRepository.save(dc);
		}
		
		/**检测站点*/
		DetectStation ds = new DetectStation();
		ds.setEpb(epbRepository.findOne(1l));
		ds.setAdministrativeDivision(administrativeDivisionRepository.findOne(1l));
		ds.setDetectStationName("开发区空气质量检测站");
		ds.setLng("120.946752");
		ds.setLat("31.899659");
		detectStationRepository.save(ds);
		
		DetectStation ds1 = new DetectStation();
		ds1.setEpb(epbRepository.findOne(1l));
		ds1.setAdministrativeDivision(administrativeDivisionRepository.findOne(1l));
		ds1.setDetectStationName("东文空气质量检测站");
		ds1.setLng("120.945479");
		ds1.setLat("31.9614665");
		detectStationRepository.save(ds1);
		
		
		/**检测站点检测的内容，目前只添加检测空气质量*/
	    DetectStationContent dsc = new DetectStationContent();
	    DetectStationContentId dscId = new DetectStationContentId(1l, 1l);
	    dsc.setId(dscId);
	    dsc.setSeq(1l);
	    detectStationContentRepository.save(dsc);
	    
	    DetectStationContent dsc1 = new DetectStationContent();
	    DetectStationContentId dscId1 = new DetectStationContentId(2l, 1l);
	    dsc1.setId(dscId1);
	    dsc1.setSeq(1l);
	    detectStationContentRepository.save(dsc1);
		
	    
	    /**数采仪*/
	    DataCollectionDevice dcd = new DataCollectionDevice("20050708S00001");
	    dcd.setDeviceName("万维盈创空气质量数采仪");
	    dcd.setDetectStation(detectStationRepository.findOne(1l));
	    dataCollectionDeviceRepository.save(dcd);
	    
	    DataCollectionDevice dcd1 = new DataCollectionDevice("20050708S00002");
	    dcd1.setDeviceName("万维盈创空气质量数采仪");
	    dcd1.setDetectStation(detectStationRepository.findOne(2l));
	    dataCollectionDeviceRepository.save(dcd1);
	    
	    
		/**空气质量信息 0,50,一级,第一级别,优,绿色,#0000FF,空气质量令人满意，基本无空气污染,各类人群可正常活动*/
		Resource aqiRes = ctx.getResource("classpath:data/aqiInfo.csv");
		CsvReader aqiReader = new CsvReader(aqiRes.getInputStream(), Charset.forName("UTF-8"));
		while(aqiReader.readRecord())
		{
			AqiInfo a = new AqiInfo();
			a.setIlow(Float.parseFloat(aqiReader.get(0).trim()));
			a.setIhigh(Float.parseFloat(aqiReader.get(1).trim()));
			a.setLvl(aqiReader.get(2).trim());
			a.setDescription(aqiReader.get(4).trim());
			a.setColorDescription(aqiReader.get(5).trim());
			a.setColor(aqiReader.get(6).trim());
			a.setHealthDescription(aqiReader.get(7).trim());
			a.setAdvice(aqiReader.get(8).trim());
			aqiInfoRepository.save(a);
		}
	    
		
		/**检测因子 二氧化硫,0,2620,20,2000,ug/m3*/
		Resource factorRes = ctx.getResource("classpath:data/factors.csv");
		CsvReader factorReader = new CsvReader(factorRes.getInputStream(), Charset.forName("UTF-8"));
		while(factorReader.readRecord())
		{
			DetectFactor df = new DetectFactor();
			df.setFactorName(factorReader.get(0).trim());
			df.setNadir(Float.parseFloat(factorReader.get(1).trim()));
			df.setUtopia(Float.parseFloat(factorReader.get(2).trim()));
			df.setReservation(Float.parseFloat(factorReader.get(3).trim()));
			df.setAspiration(Float.parseFloat(factorReader.get(4).trim()));
			df.setUnit(factorReader.get(5).trim());
			df.setFrequency(60l);
			String content =factorReader.get(6).trim();
			String category =factorReader.get(7).trim();
			df.setDetectCategory(detectCategoryRepository.getByDetectCategory(category));
			df.setDetectContentDic(detectContentDicRepository.getByDetectContent(content));
			detectFactorRepository.save(df);
		}
	 
		/*空气质量分指数*/
		Resource iaqiRes = ctx.getResource("classpath:data/iaqiInfo.csv");
		CsvReader iaqiReader = new CsvReader(iaqiRes.getInputStream(), Charset.forName("UTF-8"));
		while(iaqiReader.readRecord())
		{
			IaqiInfo ii = new IaqiInfo();
			ii.setDetectFactor(detectFactorRepository.findOne(Long.parseLong(iaqiReader.get(0).trim())));
			ii.setAqiInfo(aqiInfoRepository.findOne(Long.parseLong(iaqiReader.get(1).trim())));
			ii.setClow(Float.parseFloat(iaqiReader.get(2).trim()));
			ii.setChigh(Float.parseFloat(iaqiReader.get(3).trim()));
			iaqiInfoRepository.save(ii);
		}
		
	}

}
