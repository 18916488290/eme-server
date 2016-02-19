package com.huihuan.eme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huihuan.eme.domain.db.GroupMembers;
import com.huihuan.eme.domain.db.Groups;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.repository.GroupMembersRepository;
import com.huihuan.eme.repository.GroupsRepository;
import com.huihuan.eme.repository.UsersRepository;
/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	
	@Autowired private UsersRepository usersRepository;
	@Autowired private GroupsRepository groupsRepository;
	@Autowired private GroupMembersRepository groupMembersRepository;

	@Override
	@Transactional(readOnly=false)
	public boolean register(Users users,boolean isCompanyUser) {
		String username = users.getUsername(); 
		if(isRegisted(username))
			return false;  //已经被注册
		else
		{
			String password = users.getPassword();
			users.setPassword(new StandardPasswordEncoder().encode(password));
			users.setUserType(1l);
			usersRepository.save(users);
			
			String groupName =isCompanyUser?"User":"Administrator"; //User  企业用户， Administrator：环保局用户
			Groups group = groupsRepository.findByGroupName(groupName); 
			GroupMembers gm = new GroupMembers(users,group);
			groupMembersRepository.save(gm);
			
			return true;
		}

	}

	@Override
	public boolean isRegisted(String username) {
		Users users = usersRepository.findOne(username);
		if(users!=null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional(readOnly=false)
	public void loadDefaultUsers() {
		Users admin = new Users("admin", 0l); //0l 环保局用户
		admin.setPassword("admin");
		admin.setEnabled(true);
		register(admin,false);
	
		
	}

}
