package com.huihuan.eme.web.page;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
@Controller
public class MapController {
	
	private static final Log logger = LogFactory.getLog(MapController.class);
	
	@RequestMapping("/mapRiskSource")
	public String mapRiskSource(Map<String, Object> model) {
		model.put("centerLng", 120.94912);
		model.put("centerLat",31.905);
		return "mapRiskSource";
	}
	
	@RequestMapping("/mapAir")
	public String mapAir(Map<String, Object> model) {
		model.put("centerLng", 120.94912);
		model.put("centerLat",31.905);
		return "mapAir";
	}
	@RequestMapping("/mapOnline")
	public String mapOnline(Map<String, Object> model) {
		model.put("centerLng", 120.94912);
		model.put("centerLat",31.905);
		return "mapOnline";
	}
	
	@RequestMapping("/mapMoniter")
	public String mapMoniter(Map<String, Object> model) {
		return "mapMoniter";
	}
	
	@RequestMapping("/mapAlert")
	public String mapAlert(Map<String, Object> model) {
		return "mapAlert";
	}
	@RequestMapping("/mapPopu")
	public String mapPopu(Map<String, Object> model) {
		return "mapPopu";
	}
	@RequestMapping("/mapRiver")
	public String mapRiver(Map<String, Object> model) {
		return "mapRiver";
	}
	@RequestMapping("/mapWater")
	public String mapWater(Map<String, Object> model) {
		return "mapWater";
	}
	@RequestMapping("/mapRadio")
	public String mapRadio(Map<String, Object> model) {
		return "mapRadio";
	}
	@RequestMapping("/mapStats")
	public String mapStats(Map<String, Object> model) {
		return "mapStats";
	}
}
