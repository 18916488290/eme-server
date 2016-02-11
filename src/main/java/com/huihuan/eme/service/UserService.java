package com.huihuan.eme.service;

import com.huihuan.eme.domain.db.Users;
/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
public interface UserService {
	public boolean register(Users users);
	public boolean isRegisted(String username);
	public void loadDefaultUsers();

}
