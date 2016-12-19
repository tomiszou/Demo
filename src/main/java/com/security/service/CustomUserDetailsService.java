package com.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.dao.UserDao;
import com.security.model.DbUser;


public class CustomUserDetailsService implements UserDetailsService{
	
	 protected static Logger logger = Logger.getLogger("service");  
	  
	   
	    private UserDao userDAO = new UserDao();
	  
	    
	    public UserDetails loadUserByUsername(String username)  
	            throws UsernameNotFoundException, DataAccessException {  
	  
	        UserDetails user = null;  
	  
	        try {  
	  
	            // 搜索数据库以匹配用户登录名.  
	            // 我们可以通过dao使用JDBC来访问数据库  
	            DbUser dbuser = userDAO.getDatabase(username);  
	  
	            user = new User(dbuser.getUsername(), dbuser.getPassword()  
	                    .toLowerCase(), true, true, true, true,  
	                    getAuthorities(dbuser.getAccess()));  
	  
	        } catch (Exception e) {  
	            logger.error("Error in retrieving user");  
	            throw new UsernameNotFoundException("Error in retrieving user");  
	        }  
	  
	        return user;  
	    }  
	  
	    /** 
	     * 获得访问角色权限 
	     *  
	     * @param access 
	     * @return 
	     */  
	    @SuppressWarnings("deprecation")
		public Collection<GrantedAuthority> getAuthorities(Integer access) {  
	  
	        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);  
	  
	        // 所有的用户默认拥有ROLE_USER权限  
	        logger.debug("Grant ROLE_USER to this user");  
	        authList.add(new GrantedAuthorityImpl("ROLE_USER"));  
	  
	        // 如果参数access为1.则拥有ROLE_ADMIN权限  
	        if (access.compareTo(DbUser.ACCESS_ADMIN) == 0) {  
	            logger.debug("Grant ROLE_ADMIN to this user");  
	            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));  
	        }  
	  
	        return authList;  
	    }  
}
