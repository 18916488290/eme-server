package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;
import com.huihuan.eme.domain.db.AdministrativeDivision;
import com.huihuan.eme.domain.db.Epb;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.EpbRepository;
import com.huihuan.eme.repository.UsersRepository;

@Service("epbService")
public class EpbServiceImpl {
	
	@Autowired private EpbRepository epbRepository;
	@Autowired private UsersRepository usersRepository;
	private static final Log logger = LogFactory.getLog(AdministrativeDivisionServiceImpl.class);

	@Transactional(readOnly=false)
	public void loadEpbsFromCSV(InputStream inputStream) throws IOException{
		CsvReader reader = new CsvReader(inputStream,',', Charset.forName("UTF-8"));
		while(reader.readRecord())
		{
			Epb e = new Epb();  
		    e.setEpbName(reader.get(0).trim());
		    e.setAddress(reader.get(1).trim());
		    e.setLng(Float.parseFloat(reader.get(2).trim()));
		    e.setLat(Float.parseFloat(reader.get(3).trim()));
		    e.setCreationDate(new Date());
		    e.setUsers(usersRepository.findByUsername("admin"));
		    epbRepository.save(e); 
		   
		}
	}

}
