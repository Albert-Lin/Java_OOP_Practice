package com.semanticlab.inheritance.tennisExample;

import java.util.Random;

public class TennisCoach {
	/*
	 * 要用來繼承的屬性/方法，權限程級至少要是 protected，
	 * 在 Java 與多數 OOP 語言中，屬性/方法沒有宣告權限，
	 * 其預設就是 protected
	 */
	
	// properties:
	String brandName = "BMW";
	String type = "Classic";
	int status = 0;
	
	// constructor:
	public TennisCoach () {
		
	}
	
	// methods:
	public void forehand () {
		System.out.println("我會正拍");
	}
	
	public void backhand () {
		System.out.println("我會反拍，但我用雙手");
	}
	
	public void slice () {
		System.out.println("我會切球");
	}
	
	public double rateOfAce () {
		Random rand = new Random();
		int  n = rand.nextInt(70) + 50;
		double d = (double)n/100.0;
		System.out.println("我的 ACE 率: " + d);
		return d;
	}
}
