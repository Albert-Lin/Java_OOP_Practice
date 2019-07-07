package com.semanticlab;

/*
 * 基本上，我們會一個 file 建立一個 class。
 * 
 * public	: 使用權限
 * 		public		: 公共，所有這個類別的實例(instance)都可以調用(invoke)，也可以被繼承(繼承這件事，之後會說明) 
 * 		protected	: 保護，只有在類別中的其他方法可以用，以及也可以被繼承
 * 		private		: 私人，只有在類別中的其他方法可以用，無法被繼承
 * class	: 保留字，代表定義了一個類別
 * ExampleClass : 類別名稱，自行定義
 */
public class ExampleClass {
	
	//==============================================================
	/*
	 * 在開始之前，先介紹保留字: static，
	 * 對於一個類別而言，自身的變數(屬性)以及方法(function)
	 * 我們可以分為兩個級別:
	 * 01. 靜態變數/方法 (帶有 static 保留字)
	 * 		這種變數/方法，是數與類別級的，意思是說他不是類別的實例所調用的，而是類別直接調用。
	 * 		[Note]: 靜態方法裡面，用的外部方法和變數，都也要是靜態的。
	 * 
	 * 02. 一般變數/方法 (不帶有 static 保留字)
	 * 		這種變數/方法，是類別的實例所調用的。
	 */
	//==============================================================
	
	
	//==============================================================
	/*
	 * 變數:
	 * 	我們通常會在類別的最上方定義所有的變數，
	 * 	一般我們會說這些變數是"屬性"。
	 * 	另外，為了安全起見，多數的情況我們把屬性設為 private
	 */
	// 靜態屬性:
	public static String STATIC_PROPERTY = "";
	
	// 一般屬性:
	private String firstProperty = "";
	public int secondProperty = 40;
	//==============================================================
	
	
	//==============================================================
	/*
	 * 方法:
	 */
	/*
	 * 建構子 (constructor) 條件:
	 *  01. 是一個  function 
	 * 	01. 沒有型別
	 *  02. 不是 void 
	 *  03. function名稱跟類別名稱相同
	 * 
	 * 建構子是一種特別的function，他是當我們產生(new)一個
	 * 實例(instance)的時候，自動調用方法。
	 */
	public ExampleClass () {
		System.out.println("當產生一個 ExampleClass 的實例時，\n建構子會自動被調用，所以您才看到這串訊息");
	}
	
	/*
	 * Overloading (多載):
	 *	對於任何 function (包括建構子)，
	 *	在程式的世界中，相同名稱的 function，
	 *	只要帶入的變數不同(數量 or 型別)，
	 *	程式自動會認為成不同的 function，
	 *	而這種設計模式，我們就叫做"多載"
	 */
	public ExampleClass (String someMessage) {
		System.out.println("當產生一個 ExampleClass 的實例時，\n"
				+ "建構子會自動被調用，所以您才看到這串訊息，\n"
				+ "另外，因為帶入了訊息，所以呼叫了可以帶入字串訊息的建構子，"
				+ "這就是 Overloading (多載)");
	}
	
	/*
	 * 前面有提到，一般來說，會把屬性設為 private，
	 * 那為了要做到對屬性變數的存取，
	 * 我們會建立存取方法，一般稱為 getter & setter，
	 * 也有人會說是 accessor & mutator，
	 * 然後這類的方法命名，習慣上也適用 "get" & "set" + 屬性名稱
	 */
	public void setFirstProperty (String firstProperty) {
		// this: 代表了這個"實例"本身
		// 這裡稍微補充一下，因為參數名稱和屬性名一樣，
		// 所以才用 this 區分
		// 如果今天參數和屬性的名稱不一樣，
		// 這個時候其實就不用 this，因為預定就是 this
		// 例如: firstProperty = argForFirstProperty;
		this.firstProperty = firstProperty;
	}
	
	public String getFirstProperty () {
		return firstProperty;
	}
	
	private void addOne() {
		secondProperty++;
	}
	
	/*
	 * toString() 這個方法，是許多類別設計時常有(不是必要)
	 */
	@Override // Override 是覆寫父類別 Object 的 toString() function (這個繼承的時候會再說明)
	public String toString() {
		// private function 只有在類別中的其他方法可以用
		addOne();
		
		return "這是一個實作 ExampleClass 的 instance，\n"
				+ "我有一個 firstProperty (" + firstProperty + ")\n"
				+ "secondProperty (" + Integer.toString(secondProperty) + ")";
	}
	
	public static void SAY_HI () {
		System.out.println("靜態方法，SAY_HI()，是類別可以直接調用的方法");
	}
	
	
	//==============================================================
}
