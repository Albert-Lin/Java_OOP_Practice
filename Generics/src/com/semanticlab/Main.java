package com.semanticlab;

import com.semanticlab.Generics.DrawingBox;

public class Main {

	public static void main(String[] args) {
		/*
		 * 在多型、繼承、介面的介紹當中，我們已經可以創造出一些
		 * 具有部分相同的 methods 或是 properties 的 Classes，
		 * 就像遊戲角色一樣。
		 * 
		 * 接著我們從"抽獎箱"這個物件來想一個新的問題，
		 * 抽獎箱基本的功能就是:
		 * 01. 將號碼、抽獎連或是彩球任何相同(因為要公平)的項目，放入箱子
		 * 02. 隨機取出一個項目作為結果
		 * 
		 * 從敘述中我們可以明顯的看出，雖然號碼(int/String)、抽獎連或彩球，
		 * 他們的型別都不同，但對於抽獎箱本身而言，品項本身根本不重要，
		 * 重要的在於他的功能(即實際邏輯)。由於這些資料本身都沒有直接關聯，
		 * 很難去建立父類別，透過繼承減少重複邏輯的編寫。
		 * 
		 * 像這種時候，資料本身不是這麼重要，關注的在邏輯與功能，且不管甚麼資料都極為類似，
		 * 這時候我們就可以透過建立泛型類別，進行處理。
		 * 
		 * 接下來我們就以抽獎箱說明泛型類別的"基本"寫法，並從例子中了解它的功用。
		 */

		drawingBoxEg0();
	}
	
	@SuppressWarnings("unchecked")
	public static void drawingBoxEg0 () {
		/*
		 * 第一個獎箱的例子是，我們將全班 7 個人的人名，
		 * 放到箱子中，隨機挑選 2 位來當倒楣的班代 & 系學會聯絡人
		 * (因為一個人可以身兼多職，所以抽出來的人還要放回去箱子裡)
		 */
		
		String[] names = { "位子", "雅卉", "呂呂", "FISH", "青椒", "聖家", "媛婷"};
		DrawingBox<String> strBox = new DrawingBox(String.class, names.length, false);
		for (String name : names) {
			strBox.push(name);
		}
		
		System.out.println("=姓名箱=========");
		for (int i = 0; i < 2; i++) {
			System.out.println(strBox.pop());
		}
		System.out.println("==============");
		
		/*
		 * 第一個例子是用姓名，第二學期因為聖家太懶惰不想寫字，所以就用大家的學號當籤
		 * 這次我們可以看看誰是地域倒楣鬼
		 */
		int [] numbers = {0, 1, 2, 3, 4, 41, 54};
		DrawingBox<Integer> intBox = new DrawingBox(Integer.class, numbers.length, false);
		for (int number : numbers) {
			intBox.push(number);
		}
		
		System.out.println("=座號箱=========");
		for (int i = 0; i < 2; i++) {
			System.out.println(intBox.pop());
		}
		System.out.println("==============");
		
		/*
		 * 其實上面的例子沒有甚麼特別就只是一個隨機取亂數的一個功能，
		 * 但也就是因為邏輯一致，所以不論進入的資料是甚麼，
		 * 對泛型類別本身運作影響不大。
		 * 
		 * 這種泛型類別寫法，將邏輯提取出來的好處:
		 * 01. 好維護 (因為只要修改一個地方)
		 * 02. 減少強制轉型的寫法 code 可讀性更高
		 * 03. 相同系統中未來如果有擴充的型別，
		 * 		需要一樣的功能，可以不必再次編寫
		 * 
		 * 總的來說，不論是繼承、多型或是泛型，其實都是要將
		 * 共同的邏輯往外提取，降低維護成本，也讓 code 更清潔
		 */
	}

}
