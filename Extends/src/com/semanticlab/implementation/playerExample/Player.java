package com.semanticlab.implementation.playerExample;

/*
 * 對於一個介面而言，他的主要職責在於定義該擁有的方法，
 * 方法的實做邏輯不是在這裡考慮，此外介面也不可以被 new 成一個物件
 */
public interface Player {

	void run ();
	
	void jump ();
	
	void forehand ();
	
	void backhand ();
	
	void volley ();
	
	void slide ();
	
	double rateOfAce ();
}
