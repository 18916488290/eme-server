/**
 * 
 */
package com.huihuan.eme.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.huihuan.eme.domain.db.Company;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Override
	public Collection<String> getItemsByCategory(Company cat) {
		  Collection<String> items = new ArrayList<String>();
          return items;
	}

}
