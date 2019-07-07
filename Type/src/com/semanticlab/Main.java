package com.semanticlab;

public class Main {

	public static void main(String[] args) {

		numberType();
		
		stringType();
		
		otherTypes();
				
	}
	
	/*
	 * 這裡可以先不用管 private static void 這三個保留字，
	 * 之後會提到，就先知道這邊是定義一個 名稱為 numberType 的
	 * function 就好
	 */
	//=[Types of Number]====================================================
	private static void numberType () {
		/*
		 *	常見錯誤:
		 *		在 Java 中，整數運算的結果，永遠是整數，即便在實際計算結果中
		 *		是有小數的部分，依然會被捨棄。 (numExample0)
		 *		解決方法是: 將"運算的數值"和"被賦值的變數"型別都轉成實數(float||double)。 (numExample1)
		 *		如果"運算的數值"本身是變數，且其型別為整數，可是需要實數的結果，
		 *		這時候，透過強制轉型將變數改成實數型別即可。(numExample2)
		 */
		
		/*
		 * 註解拿掉就可以執行範例:
		 */
//		numExample0();
//		numExample1();
//		numExample2();
	}
	
	private static void numExample0 () {
		int integerComputing = 126/10;
		System.out.println(integerComputing);
	}
	
	private static void numExample1 () {
		// 單純只有"運算的數值"或"被賦值的變數"
		// 其中一個轉型依然會報錯，因為等號(賦值)的兩邊型別必須相同:
		// int integerComputing2 = 126.6/10;
		
		double doubleComputing = 126.8/10; // 這裡的 10，其實是 10.0
		System.out.println(doubleComputing);
	}
	
	private static void numExample2 () {
		int integer = 126;
		double intToDouble = (double)integer/10.0; // 將變數 integer 轉型為 double 型別
		System.out.println("第一種轉型寫法: " + intToDouble);
		
		// 轉型的寫法要稍微留意，下面的方法代表: 整數運算結果轉型為實數，而非將被除數先轉型
		double intToDouble2 = (double)(integer/10);
		System.out.println("第二種轉型寫法: " + intToDouble2);
	}

	//=[Types of String]====================================================
	private static void stringType () {
		/*
		 *	常見錯誤:
		 * 		A. 字串比對
		 * 			字串比對分為新舊版本，在舊版的 Java 中，等於運算子(==)，並不是比較，兩者的值是否相同
		 * 			而是比較兩個是不是同一個變數，(即兩個變數在記憶體位置上是相同的)。
		 * 			所以早期下面的判斷結果是錯的:
		 * 			String firstStr = "value";
		 * 			String secondStr = "value";
		 * 			firstStr == secondStr; // 這個結果是 false，意思是 firstStr 跟 secondStr 不相同。
		 *
		 * 			在新版中，等於運算子(==)，已經是用來比較兩個字串的實際文字資料是否相同，
		 * 			因此在上述的例子就會是 true，但背後代表的是兩個字串變數的文字值是相同的。
		 *
		 * 			是否可以直接使用 == 作為等於的運算，端看 Java 版本，舊版本請使用 equals() 方法。(strExample0)
		 *
		 * 	常見轉換:
		 *		A. 其他型別 -> String
		 * 			在 Java 預設的型別中，要轉成 String， 通常會有 "類別方法" (後續再說明類別時會介紹)
		 * 			toString() 這個方法存在 。(strExample1)
		 * 		B. String -> 其他型別
		 * 			在 Java 預設的型別中，要轉成其他型別，通常其他型別會有"類別方法"
		 * 			parseXXX() 這個方法存在，且 XXX 通常是型別名稱。(strExample2)
		 */
		
		/*
		 * 註解拿掉就可以執行範例:
		 */
//		strExample0();
//		strExample1();
//		strExample2();
	}
	
	/*
	 * 這只是一個取得物件在記憶體中的位址，請忽略就好
	 */
	private static void getObjectMemoryAddress(Object object) {
		System.out.println(System.identityHashCode(object));
	}
	
	private static void strExample0 () {
		/*
		 * 正規 & 早期理論寫法，可以看出兩個物件即便值相同，
		 * 但因為是不同物件，所以並不代表相同
		 */
		String firstStr = new String("123");
		String secondStr = new String("123");
		getObjectMemoryAddress(firstStr);
		getObjectMemoryAddress(secondStr);
		System.out.println("相同物件? " + (firstStr == secondStr));
		System.out.println("相同值    ? " + firstStr.equals(secondStr));
		
		System.out.println("--- 我是分隔線  ---");
		
		/*
		 * 或許是後期之後，字串的宣告實作邏輯不同了，
		 * 但為了保險，建議使用 .equals()
		 */
		String thirdStr = "abc";
		String fourthStr = "abc";
		getObjectMemoryAddress(thirdStr);
		getObjectMemoryAddress(fourthStr);
		System.out.println("相同物件? " + (thirdStr == fourthStr));
		System.out.println("相同值    ? " + thirdStr.equals(fourthStr));
	}
	
	private static void strExample1 () {
		/*
		 * int 轉成 String
		 */
		int origInteger = 10;
		String strInteger = Integer.toString(origInteger); 
		System.out.println(strInteger.getClass().getSimpleName());
	}
	
	private static void strExample2 () {
		/*
		 * String 轉成 Double
		 */
		String origString = "94.87";
		double doubleString = Double.parseDouble(origString);
		System.out.println(((Double)doubleString).getClass().getSimpleName());
	}
	
	//=[Types of Boolean, null, 未定義]=======================================
	private static void otherTypes () {
		/*
		 * 	null 和 "未定義"
		 *		A. 宣告變數(無論是基本型態或是自訂型別)時，若沒有賦值，該變數代表是其記憶體位置，
		 * 		這是一個很糟的習慣(不過 Eclipse 看起來會檢查並報錯)。
		 *
		 * 		B. 宣告變數時，若不知道或是本來就沒有預設值，可以訂為 null，
		 *		這代表這個變數是空的，而程式也不會吃到記憶體位置，
		 *		但需要注意的是，null 代表記憶體位置上沒有任何資料，
		 *		既然沒有資料就不能執行任何操作，否則會報錯。(Eg_03_2)
		 */
		
		
		/*
		 * Boolean
		 *		A. boolean (Boolean) 主要是用來判斷"真"與"假"的狀態，
		 * 		所以，以 boolean 為型別的變數的值只會有 true 或是 false。
		 * 
		 * 		B. boolean 變數的運用時機最常是用在 if / else if 判斷試中。
		 * 		(boolExample0)
		 * 
		 * 	null;
		 * 		A. 在宣告變數(無論是哪一種型別)，初始的時候如果沒有賦值，
		 *		這樣變數在記憶體上確實有挖一個位址，但是裡面沒有值。
		 * 		這樣在後續運用的時候稍稍不注意，就會出現一些靈異現象，
		 * 		debug 的時候會很困擾。所以良好的習慣是，變數初始的時候，
		 * 		如果真的沒有初始值，設為 null。null 代表這個變數
		 * 		沒有資料，但是後續出錯的時候可以透過"例外處理"(之後會介紹)
		 * 		進行 debug。 (nullExample0)
		 */
		
		/*
		 * 註解拿掉就可以執行範例:
		 */
//		boolExample0();
//		nullExample0();
	}
	
	private static void boolExample0 () {
		boolean state = false;
		boolean exist = true;
		
		if (!state) {
			System.out.println("value of state: " + state);
		}
		
		if (exist) {
			System.out.println("value of exist: " + exist);
		}
	}
	
	private static void nullExample0 () {
		String nullStr = null;
		nullStr.contains("str");
	}
	
}
