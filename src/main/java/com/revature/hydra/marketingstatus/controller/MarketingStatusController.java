package com.revature.hydra.marketingstatus.controller;

import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class MarketingStatusController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    //@ResponseBody
    public String test() {
		return "hiho!";
    }
}
