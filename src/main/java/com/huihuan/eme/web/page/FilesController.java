package com.huihuan.eme.web.page;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.io.ByteStreams;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.HousePlan;
import com.huihuan.eme.domain.page.FileMeta;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.HousePlanRepository;
import com.huihuan.eme.service.FileUploadServiceImpl;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */

@RestController
public class FilesController {
	
	private static final Log logger = LogFactory.getLog(FilesController.class);
	private String filePath ="/Users/renhongtao/eme_files/";
	//private String filePath ="D:/eme_files/";
	@Autowired private FileUploadServiceImpl fileUploadServiceImpl;

	    @RequestMapping(value="/uploadFile", method = RequestMethod.POST)
	    public FileMeta uploadHousePlan(MultipartHttpServletRequest request, HttpServletResponse response) {
	 
		 return fileUploadServiceImpl.upload(request, response);
	    
	    }
	
	
	@RequestMapping(value = "/getimage/{img}/", method = RequestMethod.GET)
	public void getImage(@PathVariable("img") String img,HttpServletResponse response ) throws IOException
	{
		FileInputStream fs = new FileInputStream(new File(filePath+img));
	    ByteStreams.copy(fs,response.getOutputStream() );
	}

}
