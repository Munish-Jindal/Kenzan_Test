package com.amdocs.kenzan.rest.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.kenzan.rest.service.FizzBuzzService;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzRestApiController {

	private Logger logger = LoggerFactory.getLogger(FizzBuzzRestApiController.class);
	@Autowired
	private FizzBuzzService fizzBuzzService;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class NotFoundException extends Exception{
		public NotFoundException(){
			
		}
	}
	@RequestMapping(method=RequestMethod.GET,value= "/{upperBound}",produces="application/json")
	public @ResponseBody Map<String, List<Integer>> getFizzBuzz(@PathVariable("upperBound") int upperBound)
			throws NotFoundException {
		logger.debug("Fizz Buzz Rest Api has been called");
		Map<String, List<Integer>> result = fizzBuzzService.fizzBuzz(upperBound);
		if (result == null) {
			throw new NotFoundException();
		}
		return result;
	}
}
