package com.semanticlab.inheritance.tennisExample;

// extends 是保留字，後面接的是要繼承的類別，
// 以此範例來說，就是當前類別 TennisPlayer01 繼承 TennisCoach
public class TennisPlayer01 extends TennisCoach {
	/*
	 * 當繼承一個類別，父類別(被繼承的類別)的所有 public & protected 
	 * 的屬性/方法，都會被繼承，不需要重新編寫與設計
	 */
	
	/*
	 * 子類別中，我們也可以隨意覆寫方法，作為子類別自己刻製方法
	 */
	public void backhand () {
		// super 代表父類別本身
		// 所以這行代表，會先調用父類別的 backhand()
		// 然而在實際覆寫時，不一定要調用父類別方法，端看需求設計
		super.backhand();
		System.out.println("除此之外，我還會單手反拍!"); // 接著在使用其他自訂的方法 & 邏輯
	}
	
	// 除了繼承父類別的方法之外，當然也可以創建一些屬於自己的方法
	public void volley () {
		System.out.println("教練不會截擊，但是我會!");
	}
}
