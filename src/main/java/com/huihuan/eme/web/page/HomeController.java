package com.huihuan.eme.web.page;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huihuan.eme.SecurityUtil;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
@Controller
public class HomeController {
	@Autowired private SecurityUtil securityUtil;
	
	private static final Log logger = LogFactory.getLog(HomeController.class);
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		
		//return "index";
		securityUtil.getUsername();
		
		return "redirect:/mapRiskSource";
	}
	
}
