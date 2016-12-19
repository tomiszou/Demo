package com.security.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @ClassName: MainController 
 * @Description: 登录页面控制
 * @author: 
 * @date: 2016年12月14日 下午3:02:52
 */
@Controller
@RequestMapping("main")
public class MainController {
	
	 protected static Logger logger = Logger.getLogger("controller"); 
	 
	 /** 
	     * 跳转到commonpage页面 
	     *  
	     * @return 
	     */  
	    @RequestMapping(value = "/common", method = RequestMethod.GET)  
	    public String getCommonPage() {  
	        logger.debug("Received request to show common page");  
	        return "commonpage";  
	    } 
	    
	    @RequestMapping(value = "/login", method = RequestMethod.GET)  
	    public String login() {  
	        return "login";  
	    } 
	    
	    /** 
	     * 跳转到admin页面 
	     *  
	     * @return 
	     */  
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)  
	    public String getAadminPage() {  
	        logger.debug("Received request to show admin page");  
	        return "admin";  
	  
	    } 
	    
	    /** 
	     * 跳转到User页面 
	     *  
	     * @return 
	     */  
	    @RequestMapping(value = "/user", method = RequestMethod.GET)  
	    public String getUserPage() {  
	        logger.debug("Received request to show user page");  
	        return "user";  
	  
	    } 
}
