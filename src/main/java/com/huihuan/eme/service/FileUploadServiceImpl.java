package com.huihuan.eme.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.huihuan.eme.domain.page.FileMeta;


@Service("fileUploadServiceImpl")
public class FileUploadServiceImpl {
	
    FileMeta fileMeta = null;
	//private String filePath ="/Users/renhongtao/eme_files/";
	private String filePath ="D:/eme_files/";
	
	    public  FileMeta upload(MultipartHttpServletRequest request, HttpServletResponse response) {
	 
	    	
	        //1. build an iterator
	         Iterator<String> itr =  request.getFileNames();
	         MultipartFile mpf = null;
	 
	         //2. get each file
	         if(itr.hasNext()){
	             //2.1 get next MultipartFile
	             mpf = request.getFile(itr.next()); 
	
	             //2.3 create new fileMeta
	             fileMeta = new FileMeta();
	             String extension="";
	             if(mpf.getOriginalFilename().lastIndexOf(".")!=-1)
	             {
	            	   extension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
	             }
	           
	             fileMeta.setFileName(""+new Date().getTime() +extension);
	             fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
	             fileMeta.setFileType(mpf.getContentType());
	             
	             try {
	                fileMeta.setBytes(mpf.getBytes());
	  
	                 // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)            
	                 FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(filePath+fileMeta.getFileName()));

	  
	             } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	          
	         }

	        return fileMeta;
	    }

}
