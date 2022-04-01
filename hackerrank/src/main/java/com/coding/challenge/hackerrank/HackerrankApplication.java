package com.coding.challenge.hackerrank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HackerrankApplication {

	public static void main(String[] args) {
		//waiter -> result = 4,4,9,3,3
		System.out.println(Waiter.waiter(Arrays.asList(3,3,4,4,9), 2));
		//largest rectangle -> 9
		System.out.println(LargestRectangle.largestRectangle(Arrays.asList(1,2,3,4,5)));
		//stock maximize -> 0
		System.out.println(StockMaximize.stockmax(Arrays.asList(5,3,2)));
		//stock maximize -> 197
		System.out.println(StockMaximize.stockmax(Arrays.asList(1,2,100)));
		//stock maximize -> 3
		System.out.println(StockMaximize.stockmax(Arrays.asList(1,3,1,2)));
		//Equal stacks -> 5
		System.out.println(EqualStacks.equalStacks(Arrays.asList(3,2,1,1,1), Arrays.asList(4,3,2), Arrays.asList(1,1,4,1)));
		SpringApplication.run(HackerrankApplication.class, args);
	}

}
