package com.example.kong.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.stereotype.Service;

@Service
public class IpCheckService {
    

    public boolean isValid(HttpServletRequest request, String ipAddressList) {

        Boolean isMatch = Boolean.FALSE;
        
        List<String> addresses = Arrays.asList(ipAddressList.split("\\s*,\\s*"));
        for (String ipAddress:addresses) {
            IpAddressMatcher ipAddressMatcher = new IpAddressMatcher(ipAddress);
            try {
            	System.out.println("request:"+request);
            	
            	System.out.println("remoteAddr:"+request.getRemoteAddr());
            	System.out.println("ipAddress :"+ipAddress);
            	System.out.println("forwarded:"+request.getHeader("X-Forwarded-For"));
                if (request.getHeader("X-Forwarded-For") != null) {
                	
                	String [] headers = request.getHeader("X-Forwarded-For").split(",");
                	
                	for (String header : headers) {
                		System.out.println("header :["+header+"]");
                		isMatch =  ipAddressMatcher.matches(header.trim());
                		System.out.println("isMatch::"+isMatch);
                		if(isMatch) {
                			return Boolean.TRUE; 
                		}
                	}
                } else {
                    isMatch =  ipAddressMatcher.matches(request);
                    System.out.println("isMatch:"+isMatch);
                    if(isMatch) {
            			return Boolean.TRUE; 
            		}
                }
                
            } catch (Exception ex) {
            	System.out.println("isValid exception:" + ex);
                return false;
            }
        }
        return isMatch;
    }
    
      
}
