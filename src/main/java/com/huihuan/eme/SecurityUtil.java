package com.huihuan.eme;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huihuan.eme.domain.db.GroupMembers;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.web.page.AirEnvController;



@Service
public class SecurityUtil {
	//@Autowired
	//private  UsersRepository usersRepository;
	private static final Log logger = LogFactory.getLog(SecurityUtil.class);
	
	public String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       for( GrantedAuthority g :auth.getAuthorities())
       {
    	   logger.warn("auth: " + g.getAuthority());
       }

        if (auth.getPrincipal() instanceof UserDetails) {
        	UserDetails u = (UserDetails) auth.getPrincipal();
        	logger.warn("u1: " + u.getUsername());
            return  auth.getPrincipal().toString();
        } else {
        	// logger.warn("u1: " + auth.getPrincipal().toString());
            return auth.getPrincipal().toString();
        }
    }


	/*
	@Transactional(readOnly=true)
	public  Collection<GrantedAuthority> getAuthorities(Long idUser) {
		
		List<GrantedAuthority> l = new ArrayList<GrantedAuthority>();
		Users user = usersRepository.findOne(idUser);
		if(user == null) {
			return l;
		}
		
		Map<String,String> roles = new HashMap<String,String>();
		Map<Long,String> groups = new HashMap<Long,String>();
		//todo:
	   for(final GroupMembers gm : user.getGroupMemberses()) {
		   
		   System.out.println("gm: " + gm.getGroups().getGroupName());
		   
		   if(groups.containsKey(gm.getId().getIdGroup()))
			   continue;
		   groups.put(gm.getId().getIdGroup(), ""+gm.getId().getIdGroup());
			l.add( new GrantedAuthority() {
				private static final long serialVersionUID = 1L;
				
				@Override
				public String getAuthority() {
					return ""+gm.getId().getIdGroup();
				}
				
				@Override
				public String toString() {
					return getAuthority();
				}
			});
			final String role = gm.getRoles().getRole();
			if(!roles.containsKey(role))
			{
				roles.put(role, role);
				l.add( new GrantedAuthority() {
					private static final long serialVersionUID = 1L;
					
					@Override
					public String getAuthority() {
						return role;
					}
					
					@Override
					public String toString() {
						return getAuthority();
					}
				});
			}
		
		}
		
		return l;		
	}	
	*/
	
    
}