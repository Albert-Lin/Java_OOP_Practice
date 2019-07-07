package com.semanticlab.implementation.playerExample;

/*
 * 一個實做介面的類別，他主要的職責就是在完成各種介面方法的邏輯，
 * 看到這裡，大概會想問，只是定義方法而已而且還沒有真正實做功能，
 * 怎麼不直接繼承一個基底的父類別就好?
 * 
 * 事實上，介面本身公用本來就只是在規範"應該擁有的方法"，再來，
 * 在強型別語言中，基本上都只能單一繼承，也就是一個類別最多只能繼承
 * 一個父類別，在這種情況下，假設我們想要同時擁有不同來源的方法，
 * 繼承就無法做到了。而介面可以多重實做，至少我們可以卻島擁有方法而不會報錯!
 * 
 * 最後，介面本身用來作為泛型或是資料轉型時很好用。
 * 
 */
public class RealPlayer implements Player {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 run() RealPlayer 實做");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 jump() RealPlayer 實做");
	}

	@Override
	public void forehand() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 forehand() RealPlayer 實做");
	}

	@Override
	public void backhand() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 backhand() RealPlayer 實做");
	}

	@Override
	public void volley() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 volley() RealPlayer 實做");
	}

	@Override
	public void slide() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 slide() RealPlayer 實做");
	}

	@Override
	public double rateOfAce() {
		// TODO Auto-generated method stub
		System.out.println("Player 定義 rateOfAce() RealPlayer 實做");
		return 0;
	}

}
