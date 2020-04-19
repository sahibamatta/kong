package com.example.kong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kong.service.IpCheckService;

@RestController
@RequestMapping("ipcheck")
public class IpCheckController {
	
	@Autowired
	private IpCheckService ipCheckService;
	
	@GetMapping("/get")
	public boolean getKong(HttpServletRequest httpServletRequest) {
		return ipCheckService.isValid(httpServletRequest, "10.0.0.0/8, 127.0.0.0/8, 172.0.0.0/8,192.0.0.0/8,52.55.56.120,180.179.186.19,10.248.7.133");
	}
    
    
}
