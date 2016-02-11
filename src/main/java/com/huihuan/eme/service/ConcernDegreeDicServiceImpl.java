package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csvreader.CsvReader;
import com.huihuan.eme.domain.db.AdministrativeDivision;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;

@Service("concernDegreeDicServiceImpl")
public class ConcernDegreeDicServiceImpl {
	
	@Autowired private ConcernDegreeDicRepository concernDegreeDicRepository;
	private static final Log logger = LogFactory.getLog(ConcernDegreeDicServiceImpl.class);

	public void loadConcernDegreeDics() throws IOException{
		
	}

}
