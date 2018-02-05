package com.amdocs.kenzan.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class FizzBuzzServiceTest {
	
	private FizzBuzzService fizzBuzzService = new FizzBuzzService();	
	
	@Test
	public void testFizzBuzz() {
		Map<String,List<Integer>> result = fizzBuzzService.fizzBuzz(15);
		Assert.assertTrue(result.containsKey("FizzBuzz"));
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(15));
		Assert.assertEquals(result.get("FizzBuzz"), expectedResult);
	}
	
	@Test
	public void testFizz() {
		Map<String,List<Integer>> result = fizzBuzzService.fizzBuzz(15);
		Assert.assertTrue(result.containsKey("Fizz"));
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(3,6,9,12));
		Assert.assertEquals(result.get("Fizz"), expectedResult);
	}

	@Test
	public void testBuzz() {
		Map<String,List<Integer>> result = fizzBuzzService.fizzBuzz(15);
		Assert.assertTrue(result.containsKey("Buzz"));
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(5,10));
		Assert.assertEquals(result.get("Buzz"), expectedResult);
	}
	
	@Test
	public void testEmpty() {
		Map<String,List<Integer>> result = fizzBuzzService.fizzBuzz(2);
		Assert.assertTrue(result.isEmpty());
	}
	
	
}
