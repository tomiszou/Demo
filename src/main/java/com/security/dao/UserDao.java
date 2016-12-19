package com.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.security.model.DbUser;

/**
 * 
 * @ClassName: UserDao 
 * @Description: 用户dao
 * @author: 
 * @date: 2016年12月14日 下午2:30:54
 */
public class UserDao {
	
	 protected static Logger logger = Logger.getLogger("dao");  
	     
	 
	  //模拟数据库查找用户 成功返回User
	    public DbUser getDatabase(String username) {  
	       
	    	//调用初始化方法
	        List<DbUser> users = internalDatabase();  
	  
	        for (DbUser dbUser : users) {  
	            if (dbUser.getUsername().equals(username) == true) {  
	                logger.debug("User found");  
	                return dbUser;  
	            }  
	        }  
	        logger.error("User does not exist!");  
	        throw new RuntimeException("User does not exist!");  
	    }
	        
	        /** 
	         * 初始化数据 声明2个用户  admin  user
	         */  
	        private List<DbUser> internalDatabase() {  
	      
	            List<DbUser> users = new ArrayList<DbUser>();  
	            DbUser user = null;  
	      
	            user = new DbUser();  
	            user.setUsername("admin");  
	      
	            // "admin"经过MD5加密后  
	            user.setPassword("21232f297a57a5a743894a0e4a801fc3");  
	            user.setAccess(DbUser.ACCESS_ADMIN);  
	      
	            users.add(user);  
	      
	            user = new DbUser();  
	            user.setUsername("user");  
	      
	            // "user"经过MD5加密后  
	            user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");  
	            user.setAccess(DbUser.ACCESS_USER);  
	      
	            users.add(user);  
	      
	            return users;  
	      
	        }  
}
