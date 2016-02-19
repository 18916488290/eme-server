package com.huihuan.eme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huihuan.eme.domain.db.GroupAuthorities;
import com.huihuan.eme.domain.db.GroupAuthoritiesId;
import com.huihuan.eme.domain.db.Groups;
import com.huihuan.eme.domain.page.AuthorityEnum;
import com.huihuan.eme.repository.GroupAuthorityRepository;
import com.huihuan.eme.repository.GroupMembersRepository;
import com.huihuan.eme.repository.GroupsRepository;

@Service("groupsService")
@Transactional(readOnly=true)
public class GroupsServiceImpl implements GroupsService {
	
	@Autowired private GroupsRepository groupsRepository;
	@Autowired private GroupAuthorityRepository groupAuthorityRepository;
	

	@Override
	@Transactional(readOnly=false)
	public void loadDefaultGroups() {
		Groups userGroup = new Groups();
		userGroup.setGroupName("User");
		userGroup.setDescription("企业用户组");
		groupsRepository.save(userGroup);
		GroupAuthoritiesId id = new GroupAuthoritiesId(AuthorityEnum.ROLE_USER.toString(), userGroup.getId());
		GroupAuthorities userGroupAuthorities = new GroupAuthorities(id, userGroup);
		groupAuthorityRepository.save(userGroupAuthorities);
		
		Groups adminGroup = new Groups();
		adminGroup.setGroupName("Administrator");
		adminGroup.setDescription("环保局用户组");
		groupsRepository.save(adminGroup);
		GroupAuthoritiesId id1 = new GroupAuthoritiesId(AuthorityEnum.ROLE_USER.toString(), adminGroup.getId());
		GroupAuthorities userGroupAuthorities1 = new GroupAuthorities(id1, adminGroup);
		groupAuthorityRepository.save(userGroupAuthorities1);
		GroupAuthoritiesId id2 = new GroupAuthoritiesId(AuthorityEnum.ROLE_ADMIN.toString(), adminGroup.getId());
		GroupAuthorities userGroupAuthorities2 = new GroupAuthorities(id2, adminGroup);
		groupAuthorityRepository.save(userGroupAuthorities2);
	}

}
