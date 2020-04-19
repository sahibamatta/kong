package com.example.kong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kong.dto.KongDto;

@RestController
@RequestMapping("public")
public class PublicController {

	List<KongDto> kongDtos = new ArrayList<>();

	@GetMapping("/get")
	public List<KongDto> getKong(String paymentId,HttpServletRequest request, HttpServletResponse response) {
		System.out.println("paymentId::"+paymentId+"request:"+request.getHeader("rest"));
		return kongDtos;
	}
	
	@PostMapping("/post")
	public void postKong(@RequestBody KongDto kongDto) {
		System.out.println("kongDto ["+kongDto+"]");
		kongDtos.add(kongDto);
	}
	

}
