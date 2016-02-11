package com.huihuan.eme;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huihuan.eme.domain.db.AdministrativeDic;
import com.huihuan.eme.domain.db.AirEnvType;
import com.huihuan.eme.domain.db.ConcernDegreeDic;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AirEnvTypeRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.GroupsRepository;
import com.huihuan.eme.service.AdministrativeDivisionServiceImpl;
import com.huihuan.eme.service.GroupsService;
import com.huihuan.eme.service.UserService;

@Service
@Transactional
public class DatabaseInit {
	private static final Log logger = LogFactory.getLog(DatabaseInit.class);
	@Autowired
	private GroupsService groupsService;
	@Autowired
	private UserService userService;
	@Autowired
	private GroupsRepository groupsRepository;

	@Autowired
	private AdministrativeDicRepository administrativeDicRepository;
	private String[] administratives = new String[] { "中央", "省", "市", "地区、县", "街道、乡镇", "居民村委会" };

	@Autowired
	private AdministrativeDivisionServiceImpl administrativeDivisionServiceImpl;

	@Autowired
	private AirEnvTypeRepository airEnvTypeRepository;
	private String[] airEnvTypes = new String[] { "自然保护区", "风景名胜区", "森林公园", "世界遗产地", "国家重点文物保护单位", "历史文化保护地", "农田种植",
			"珍稀动物栖息地", "特殊生态系统", "居民点", "自然村", "学校", "机关", "医院", "城镇", "县城", "居民聚集区", "其他" };

	@Autowired
	private ConcernDegreeDicRepository concernDegreeDicRepository;
	private String[] concernDegrees = new String[] { "国控", "省控", "县控" };

	public void init(ConfigurableApplicationContext ctx) throws IOException
	{
		//if(!groupsRepository.findAll().isEmpty())
		//	return;
		//groupsService.loadDefaultGroups();
		//userService.loadDefaultUsers();
		//loadAdministratives();
		//loadAdministrativeDivisions(ctx);
		//loadAirEnvTypes();
		//loadConcernDegrees();
	}

	private void loadAdministratives() {
		for (String administrative : administratives) {
			AdministrativeDic ad = new AdministrativeDic(administrative);
			administrativeDicRepository.save(ad);
		}
	}

	private void loadAdministrativeDivisions(ConfigurableApplicationContext ctx) throws IOException {
		Resource res = ctx.getResource("classpath:data/administrativeDivision.csv");
		administrativeDivisionServiceImpl.loadAdministrativeDivisionsFromCSV(res.getInputStream());
	}

	private void loadAirEnvTypes() {
		for (String airEnvType : airEnvTypes) {
			AirEnvType envType = new AirEnvType(airEnvType);
			airEnvTypeRepository.save(envType);
			logger.debug("导入气环境类型： " + envType.getAirEnvType());
		}
	}

	private void loadConcernDegrees() {
		for (String concernDegree : concernDegrees) {
			concernDegreeDicRepository.save(new ConcernDegreeDic(concernDegree));
		}
	}
}
