/*
 * 這是多行註解，代表所有，在"斜線星號"內的文字都不會被執行
 */

// 這是單行註解，帶鰾這一行在"斜線"之後的文字都不會被執行

/*
 * package 代表是這個類別的套件名稱
 */
package com.semanticlab;

/*
 * 一個專案/應用，通常只會有，也只應該有一個"主要執行"的類別，
 * 這個進入類別會有唯一真正執行程式的地方，
 * 這個類別名稱一樣可以自訂名稱，
 * 常見的有 Application 或是  Main
 */
public class Main {

	/*
	 * main(String[] arg)
	 * 就是真正執行所有 code 的地方，
	 * 只有寫在這個區塊的 code 才會被執行
	 */
	public static void main(String[] args) {
		
		/*
		 * 要把文字或是變數輸出到 console (cmd)，
		 * 我們會用 System.out.println("要輸出的文字或變數") 這個方法，
		 * 在此請先忽略 "System.out.println" 的運作原理，講解完 Class 之後，
		 * 就可以清楚了解其概念。
		 *
		 * 現在只要知道打這串程式，並在括號內，打入要輸出的文字，
		 * 經過執行之後就可以看到該文字，此方法偶爾會用來 debug。
		 */
		System.out.println("Hello World! Welcome to Java!");
	}

}
