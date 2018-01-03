package com.semanticlab;

public class Main {

	public static void main(String[] args) {
		array();
	}
	
	
	private static void array () {
		/*
		 * 01. 陣列，是同時存放大量相同型別資料的容器，
		 * 		它的特性為:
		 * 		A. 陣列中所有元素都必須是相同型別
		 * 		B. 陣列大小在初始化的時候就需要設定
		 * 		C. 陣列大小初始後無法再改變，意味陣列儲存的
		 * 			資料不能想加上去加上去，只有在陣列還有空
		 * 			間或是覆寫其他位置的資料。
		 * 		D. 陣列的編號永遠從 0 開始
		 * 
		 * 		簡單來說，陣列，可以想像是一間旅館，
		 * 		旅館每間房間都只能住人，同時，旅館的房間數
		 * 		是在飯店蓋好的一瞬間就決定了，所以當沒有空
		 * 		房間的時候就不能在入住新房客，最後比較特別的是，
		 * 		這間旅館的房號是從 0 開始。
		 * 
		 * 02. 陣列的宣告會是:
		 * 		A. 型別[] 變數名稱 = new 型別[陣列大小];
		 * 			切記! 陣列是一種特殊的物件，所以使用 "new" (new 的意涵之後會提到)保留字。
		 * 			此外，如果陣列的每個元素沒又賦值，一般型別的初始會是 null，
		 * 			數值型別會是 0。
		 * 
		 * 		B. 型別[] 變數名稱 = {元素0, 元素1, ...};
		 * 			這種宣告模式，是對一開始就已知陣列元素值得宣告方式，
		 * 			同時也比較靜態(意旨這些值不太會被更動)，另外，這種
		 * 			宣告方式，陣列大小等於元素個數。 
		 * 		(arrayExample0)
		 * 		
		 * 03. 多維陣列:
		 * 		在最基本的陣列中，是一維的。要比喻的話應該就是部隊裡的一個班，
		 * 		就是全部都存在一條線上，如果要從線變成面(班 --> 排)，
		 * 		代表要有很多條平行的線，因此在宣告上就會多加一個 []。
		 * 
		 * 		[示意圖]:
		 * 		一維:
		 * 		[0][1][2][3]
		 * 
		 * 		二維:
		 * 		[A0][A1][A2][A3]
		 * 		[B0][B1][B2][B3]
		 * 		[C0][c1][C2][C3]
		 * 
		 * 		值得一提的是，多維陣列取值得順序並沒有規範，單看你怎麼取，
		 * 		例如可以先把同數字的取出來，也可以先從同字母的取出來。
		 * 		(arrayExample1)
		 */
		
//		arrayExample0();
//		arrayExample1();
	}
	
	private static void arrayExample0 () {
		/*
		 * 存放10個String陣列的兩種宣告方式
		 */
		String[] strArrayAType = new String[10];
		for (int i = 0; i < strArrayAType.length; i++) {
			System.out.println("A type 元素" + i + ": " + strArrayAType[i]);
		}
		
		
		String[] strArrayBType = {"05", "04", "12", "27", "Albert", "Lin", "位子大大", "12", "22", "2017"};
		for (int i = 0; i < strArrayBType.length; i++) {
			System.out.println("B type 元素" + i + ": " + strArrayBType[i]);
		}
	}
	
	private static void arrayExample1 () {
		/*
		 * 一個二維的String陣列
		 */
		String[][] twoDArray = new String[3][4];
		
		// 初始
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				twoDArray[i][j] = "[" + Integer.toString(i) + "," +
									Integer.toString(j) + "]";
				
			}
		}
		
		// 取值: row major
		for (int i = 0; i < 3; i++) {
			System.out.print("twoDArray[" + i + "]-> \t");
			for (int j = 0; j < 4; j++) {
				System.out.print(twoDArray[i][j]);
			}
			System.out.print("\r\n");
		}
		
		System.out.print("\r\n\r\n");
		
		// 取值: column major
		for (int i = 0; i < 4; i++) {
			System.out.print("twoDArray[][" + i + "]-> \t");
			for (int j = 0; j < 3; j++) {
				System.out.print(twoDArray[j][i]);
			}
			System.out.print("\r\n");
		}
	}

}
