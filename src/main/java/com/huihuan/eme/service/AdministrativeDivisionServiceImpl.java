package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;
import com.huihuan.eme.domain.db.AdministrativeDivision;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;

@Service("administrativeDivisionServiceImpl")
public class AdministrativeDivisionServiceImpl {
	
	@Autowired private AdministrativeDivisionRepository administrativeDivisionRepository;
	private static final Log logger = LogFactory.getLog(AdministrativeDivisionServiceImpl.class);

	@Transactional(readOnly=false)
	public void loadAdministrativeDivisionsFromCSV(InputStream inputStream) throws IOException{
		CsvReader reader = new CsvReader(inputStream,',', Charset.forName("UTF-8"));
		while(reader.readRecord())
		{
			AdministrativeDivision ad = new AdministrativeDivision();  
		    ad.setDivision(reader.get(0).trim());
		    administrativeDivisionRepository.save(ad); 
		    //logger.debug("添加行政区域： " + ad.getDivision());
		}
	}

}
