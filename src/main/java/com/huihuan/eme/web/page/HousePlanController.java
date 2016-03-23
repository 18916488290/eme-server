package com.huihuan.eme.web.page;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

@Controller
public class HousePlanController {
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private HousePlanRepository housePlanRepository;
	@Autowired private FileUploadServiceImpl fileUploadServiceImpl;
	
	private static final Log logger = LogFactory.getLog(HousePlanController.class);
	 @RequestMapping(value="/uploadHousePlan", method = RequestMethod.POST)
	    @Transactional
	    public String uploadHousePlan(MultipartHttpServletRequest request, HttpServletResponse response, @RequestParam("companyId") Long companyId,@RequestParam(required=true) Long riskSourceId, Map<String, Object> model,RedirectAttributes attr) {
	 
		 FileMeta  fileMeta = fileUploadServiceImpl.upload(request, response);
	    	if(fileMeta!=null)
	    	{
	    	  	HousePlan housePlan = new HousePlan();
             	housePlan.setFileName(fileMeta.getFileName());
             	housePlanRepository.save(housePlan);
             	
             	Company company =companyRepository.findOne(companyId);
             	company.setHousePlan(housePlan);
             	companyRepository.save(company);
	    	}
	    
	    	attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab2");
			return "redirect:/auditSourceTab";
	    }


}
