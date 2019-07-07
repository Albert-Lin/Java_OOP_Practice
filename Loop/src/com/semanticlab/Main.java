package com.semanticlab;

import java.io.*;

public class Main {

	public static void main(String[] args) {
//		ifLoop();
//		switchLoop();
//		forLoop();
//		whileLoop();
//		recursive();
	}

	private static void ifLoop () {
		/*
		 * 01. 當我們需要進行一些判斷的時候，我們會用 
		 * 		if, else if, else 進行判斷，完整結構如下:
		 * 		
		 * 		if (判斷1) {
		 * 			// 要處理的邏輯 1
		 * 		} else if (判斷2) {
		 * 			// 要處理的邏輯 2
		 * 		} else {
		 * 			// 不符合 "判斷1" 和 "判斷2" 其他所有情況
		 * 		}
		 * 
		 * 		其中， if 是必要的，而 else if () 沒有限制數量，
		 * 		所以假設有 100 個狀態，扣除第一個 if 判斷，
		 * 		也是可以寫下 99個 else if ()。
		 * 		(ifExample0)
		 * 
		 * 		要注意的是，所有判斷式，都必須要回傳 boolean 值，
		 * 		另外，如果判斷式是一個 boolean 變數，
		 * 		可以不需要寫成 if(state == true)，
		 * 		寫成 if(state) 就可以了。
		 * 
		 */
		
		ifExample0();
		ifExample1();
	}
	
	/*
	 * 這是一個從 cmd 輸入值的方法，請不需要去理解其中的寫法，
	 * 有機會會另外說明。
	 */
	private static String inputStr () {
		String inputStr = null;
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputStr = bin.readLine();
		} catch (Exception ex) {
			// ignore
			System.out.println(ex.getMessage());
		}
		
		
		return inputStr;
	}
	
	private static void ifExample0 () {
		System.out.print("請輸入一個數值: ");
		int inputNum = Integer.parseInt(inputStr());
		
		if (inputNum == 0) {
			System.out.println("state 0");
		} else if (inputNum == 1) {
			System.out.println("state 1");
		} else if (inputNum == 2) {
			System.out.println("state 2");
		} else {
			System.out.println("state 3");
		}
		
	}
	
	private static void ifExample1 () {
		boolean albertHasNoLife = false;
		
		if (albertHasNoLife) {
			System.out.println("寫法同等於 if(albertHasNoLife == true)");
		} else if (!albertHasNoLife) {
			System.out.println("寫法同等於 if(albertHasNoLife != true)");
		}
		
	}
	
	private static void switchLoop () {
		/*
		 * 02. 雖然我們有 if...else 可以根據條件切換
		 * 		真正要執行的邏輯，但許多時候我們沒有複雜的邏輯，
		 * 		我們只是要針對一個變數的狀態(其實就是變數的值)，
		 * 		進行判斷，這時候我們就可以用 switch...case，
		 * 		同樣判斷， switch...case 會比 if...else更快。
		 * 		switch...case 的結構如下:
		 * 
		 * 		switch (變數) {
		 * 			case 判斷值0:
		 * 				// 要執行的邏輯
		 * 				break;
		 * 			case 判斷值1:
		 * 				// 要執行的邏輯
		 * 				break;
		 * 			case 判斷值2:
		 * 				// 要執行的邏輯
		 * 				break;
		 * 			...
		 * 			default:  (和 else 的概念一樣，可以不一定要有)
		 * 				// 要執行的邏輯
		 * 				break;
		 * 		}
		 * 
		 * 		(switchExample0)
		 */
		
		switchExample0();
	}
	
	private static void switchExample0 () {
		System.out.print("請輸入一個數值: ");
		int inputNum = Integer.parseInt(inputStr());
		
		switch (inputNum) {
			case 0:
				System.out.println("滿足第一個判斷");
				break;
			case 41:
				System.out.println("滿足第二個判斷");
				break;
			default:
				System.out.println("輸入的不是 0 或 41");
				break;
		}
	}
	
	
	private static void forLoop () {
		/*
		 * 03. for 迴圈是用來將一個陣列、列表或任何可以迭代的物件(之後會提到)，
		 * 		中的每一個元素，依序"取出"，或者就只是單純同樣的邏輯執行數次。在這裡先以最基礎的陣列作為範例說明:
		 * 
		 * 		for 有兩種寫法:
		 * 			第一種:
		 * 			for (int i = 0; i < intArray.length; i++) {
		 * 			}
		 * 			第一種寫法是最基礎的寫法，他主要強調可以根據自行定義的規則，
		 * 			從陣列(或所有可迭代的物件，為方便解釋後面都以陣列說明)
		 * 			中取出元素。解釋如下:
		 * 			int i = 0;
		 * 				一開始我們會給定一個索引值，通常是作為代表陣列的索引值(也就是房號)
		 * 			i < intArray.length;
		 * 				這是一個停止判斷的"中止"條件，只要符合這個條件，for 裡面的邏輯就不會再被執行
		 * 			i++:
		 * 				這是用來代表一開始設定的索引值，在執行完 for 裡面邏輯之後，要怎麼改變的方法
		 * 			(forExample0,forExample1)
		 * 
		 * 
		 * 			第二種:
		 * 			for (String str : strArray) {
		 * 			}
		 * 			第二種寫法，通常是不考慮取值順序問題，就是一個一個依序從陣列拿出元素來。
		 * 			解釋如下:
		 * 			String str
		 * 				因為不像第一種方法有索引值可以取出元素，
		 * 				所以一開始我們就會宣告一個變數，這個變數每次回權執行時都會將陣列中的元素
		 * 				賦值給他，簡單來說這裡的 str 就是陣列中的一個元素。
		 * 			:
		 * 				特定寫法，(應該)代表是從右邊的陣列中來的元素
		 * 			strArray
		 * 				陣列，或是其他所有可迭代的物件
		 * 			(forExample2,forExample3)
		 * 			
		 */
		forExample0();
		forExample1();
		forExample2();
		forExample3();
	}
	
	private static void forExample0 () {
		int excuteTime = 5;
		for (int i = 0; i < excuteTime; i++) {
			System.out.println("執行第 " + i + " 次");
		}
		System.out.println("======================");
	}
	
	private static void forExample1 () {
		int excuteTime = 10;
		int index = 0;
		for (int i = 0; i < excuteTime; i+=2) {
			System.out.println("執行第 " + index + " 次，序號 i 為" + i);
			index++;
		}
		System.out.println("======================");
	}
	
	private static void forExample2 () {
		String[] strArray = {"Roger", "Federer", "05", "04", "12", "27", "Albert"};
		for (int i = 0; i < strArray.length; i++) {
			String str = strArray[i];
			System.out.println(str);
		}
		System.out.println("======================");
	}
	
	private static void forExample3 () {
		String[] strArray = {"Roger", "Federer", "05", "04", "12", "27", "Albert"};
		for (String str : strArray) {
			System.out.println(str);
		}
		System.out.println("======================");
	}
	
	
	private static void whileLoop () {
		/*
		 * 04. while 跟 for 要做的事情極為類似，
		 * 		但 while 的核心概念，應該是:
		 * 		在"符合條件"的情況下重複執行，那一定會問說，
		 * 		那甚麼時候停止? 不論 for 或是 while，
		 * 		都可以用 "break"保留字跳出迴圈，
		 * 		至於甚麼時候該用 break，端看邏輯設計和需求。
		 * 		while 結構如下:
		 * 
		 * 		while (執行所需要符合的條件) {
		 * 			// 邏輯
		 * 			// 遇到要停止、跳出迴圈的條件使用:
		 * 			break;
		 * 		}
		 * 		
		 * 		(whileExample0)
		 */
		
		whileExample0();
		whileExample1();
	}
	
	private static void whileExample0 () {
		while (true) {
			System.out.print("請輸入一個數值: ");
			int inputNum = Integer.parseInt(inputStr());
			if (inputNum == 0) {
				break;
			} else {
				System.out.println("出非輸入0，不然會纏著你到天荒地老");
			}
		}
		System.out.println("=====================");
	}

	private static void whileExample1 () {
		int inputNum = 0;
		while (inputNum < 10) {
			System.out.print("請輸入一個數值: ");
			inputNum = Integer.parseInt(inputStr());
			System.out.println("出非輸入大於 9 的數值，不然會纏著你到天荒地老");
		}
		System.out.println("=====================");
	}
	
	
	private static void recursive () {
		/*
		 * 05. Recursive 遞迴，在程式的世界裡，自己可以呼叫自己，
		 * 		遞迴在設計上要格外小心，因為他稍微複雜一些，一個不注意，
		 * 		沒有將跳出的邏輯寫清楚會造成跟 while 一樣的無窮迴圈。
		 * 		基本架構:
		 * 		
		 * 		void recurseFun() {
		 * 			// 邏輯 
		 * 			recursiveFun();
		 * 			// 邏輯 
		 * 		}
		 */
		recursiveExample0();
	}
	
	private static void recursiveExample0 () {
		System.out.println("序位 04: " + fibonacci(4));
		System.out.println("序位 06: " + fibonacci(6));
		System.out.println("序位 10: " + fibonacci(10));
	}
	
	/**
	 * 經典例子---費氏數列
	 * @param indexOfList 數列序號
	 * @return
	 */
	private static int fibonacci (int indexOfList) {
		int result;
		
		if (indexOfList == 0 || indexOfList == 1) {
			result = indexOfList;
		} else {
			result = fibonacci(indexOfList - 2) + fibonacci(indexOfList - 1);
			
		}
		
		return result;
	}
}
