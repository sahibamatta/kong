package com.example.kong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kong.dto.KongDto;

@RestController
@RequestMapping("buyerCare")
public class BuyerCareController {

	private List<KongDto> kongDtos = new ArrayList<>();
	private String buyercareString = "buyercare";
	
	@PostMapping("/post")
	public void postBuyerCare(@RequestBody KongDto kongDto) {
		System.out.println("kongDto ["+kongDto+"]");
		kongDtos.add(kongDto);
	}
	
	
	@GetMapping("/get")
	public String getString() {
		
		return buyercareString;
	}

}
