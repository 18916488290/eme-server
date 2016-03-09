package com.huihuan.eme.web.page;


import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.huihuan.eme.repository.CompanyRepository;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */

@Controller
public class VocsController {
	
	@Autowired private CompanyRepository companyRepository;
	
	private static final Log logger = LogFactory.getLog(VocsController.class);

	@RequestMapping(value="/vocsInfo",method=RequestMethod.GET)
	public String populateVocsInfo(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		return "vocsInfo";
	}
	
	@RequestMapping(value="/vocsBasicInfo",method=RequestMethod.GET)
	public String populateVocsBasicInfo(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		return "vocsBasicInfo";
	}


}
