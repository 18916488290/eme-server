package com.huihuan.eme.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huihuan.eme.domain.db.GroupAuthorities;
import com.huihuan.eme.domain.db.GroupAuthoritiesId;
import com.huihuan.eme.domain.db.GroupMembers;
import com.huihuan.eme.domain.db.Groups;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午2:14:53
 *
 */
@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Long> {
	
}