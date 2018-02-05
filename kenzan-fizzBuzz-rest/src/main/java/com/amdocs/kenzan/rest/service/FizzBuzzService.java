package com.amdocs.kenzan.rest.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("fizzBuzzService")
public class FizzBuzzService{
	
	public Map<String,List<Integer>> fizzBuzz(int upperBound)
	{
		Map<String,List<Integer>> fizzBuzzResult = new LinkedHashMap<>();
		fizzBuzzResult = IntStream.rangeClosed(3, upperBound).
							filter(i-> i%3 ==0 || i%5==0).
							boxed().
							collect(Collectors.groupingBy(i->
							i%15 == 0 ? "FizzBuzz" :
								i%3 == 0 ? "Fizz" :
									"Buzz"));
		return fizzBuzzResult;
	}
}
