package com.semanticlab;

import com.semanticlab.Character.Character;
import com.semanticlab.Models.Member;
import com.semanticlab.Models.User;

public class Main {

	public static void main(String[] args) {
		
		staticExample();
		
		classExample();
		
		// 一個比較實際的類別例子 :
		System.out.println();
		Character player = new Character("位子");
		player.showCharacterInfo();
		player.getMp();
		player.getSp();
		player.beAttacked(10.0);
		player.showCharacterInfo();
		System.out.println();
	}

	public static void staticExample () {
		// 首先，我們先還看看靜態變數/方法的例子:
		// 01. 先印出 STATIC_PROPERTY
		System.out.println("STATIC_PROPERTY: " + ExampleClass.STATIC_PROPERTY);
		
		// 02. STATIC_PROPERTY 重新賦值
		ExampleClass.STATIC_PROPERTY = "重新賦值了";
		
		// 03. 再重新印出 STATIC_PROPERTY
		System.out.println("STATIC_PROPERTY: " + ExampleClass.STATIC_PROPERTY);
		
		// 04. 使用了 SAY_HI
		ExampleClass.SAY_HI();
	}
	
	public static void classExample () {
		// 接下來，開始看看實作類別用法
		
		// 01. 先宣告兩個 ExampleClass 的變數:
		ExampleClass ex0 = null;
		ExampleClass ex1 = null;
		
		// 02. 我們接著實作、產生 ExampleClass 的實例 (instance (也可以說是物件 object))
		// 		透過 new 保留字，我們就可以產生出來了，
		//		再來產生物件的時候，第一步會去掉用建構子。
		//		當然，由於，我們的建構子是多載的設計，
		//		所以調用建構子的時候，程式自動會根據給定的參數，
		//		找到符合的建構子
		ex0 = new ExampleClass();
		ex1 = new ExampleClass("firstProperty初始化的值");
		
		// 03. private 的屬性和方法都不可以在類別外調用，
		//		因此我們只能透過 accessor & mutator存取
		// System.out.println(ex0.firstProperty);
		System.out.println("firstProperty: " + ex0.getFirstProperty());
		ex0.setFirstProperty("我是第一個property");
		System.out.println("firstProperty: " + ex0.getFirstProperty());
		ex0.toString();
	}

	//------------------------------------------------------------------------------
	/*
	 * 如何使用 class (以 User 為例)
	 */
	private static void userClassExample() {
		// 新增一個人員:
		// 因為"類別是一個抽象概念"，所以要將概念實體化，
		// 換句話說，我們要將定義的概念，先產出一個全新並以"類別"為基礎的物件
		User albert = new User();

		// 設定 albert 物件資料的值:
		// 由於在 User 中，所有資料都設定為公開，因此可以直接存取物件的資料
		albert.id = 0;
		albert.name = "Albert Lin";
		albert.phoneNumber = "0928000000";
		albert.email = "albert.lin@domain.com.tw";
		albert.image = "https://stickershop.line-scdn.net/stickershop/v1/product/1287660/LINEStorePC/main.png;compress=true";
	}

	private static void userInsertExample() {
		// 新增一個人員:
		User albert = new User();

		// 設定 albert 物件資料的值:
		albert.id = 0;
		albert.name = "Albert Lin";
		albert.phoneNumber = "0928000000";
		albert.email = "albert.lin@domain.com.tw";
		albert.image = "https://stickershop.line-scdn.net/stickershop/v1/product/1287660/LINEStorePC/main.png;compress=true";

		// 透過 albert 的方法，將 albert 資料存入 DB
		albert.insert();
	}

	private static void userSelectExample() {
		// 假設已經有 albert 在 DB 了
		// 新增一個人員:
		User albert = new User();

		// 透過 albert 的方法，將 DB 裡面的值綁至 albert 物件上
		albert.select("id", 0);
	}

	private static void userUpdateExample() {
		// 假設已經有 albert 在 DB 了
		// 新增一個人員:
		User albert = new User();

		// 透過 albert 的方法，將 DB 裡面的值綁至 albert 物件上
		albert.select("id", 0);

		// 更新 albert 資料
		albert.email = "741@741963.com";

		// 透過 albert 的方法，更新 DB 裡面的 albert 那筆記錄的資料
		albert.update();
	}

	private static void userDeleteExample() {
		// 假設已經有 albert 在 DB 了
		// 新增一個人員:
		User albert = new User();

		// 透過 albert 的方法，將 DB 裡面的值綁至 albert 物件上
		albert.select("id", 0);

		// 透過 albert 的方法，將 DB 裡面 albert 那筆紀錄刪除
		albert.delete();
	}

	//------------------------------------------------------------------------------
	/*
	 * 如何使用 class (以 Member 為例)
	 */
	private static void memberClassExample() {
		// 新增一個 Member 物件:
		Member albert = new Member(
				0,
				"Albert Lin",
				"0928000000",
				"albert.lin@domain.com.tw",
				"Taichung,Taiwan",
				"https://stickershop.line-scdn.net/stickershop/v1/product/1287660/LINEStorePC/main.png;compress=true"
		);
	}

	private static void memberInsertExample() {
		// 新增一個 Member 物件:
		Member albert = new Member(
				0,
				"Albert Lin",
				"0928000000",
				"albert.lin@domain.com.tw",
				"Taichung,Taiwan",
				"https://stickershop.line-scdn.net/stickershop/v1/product/1287660/LINEStorePC/main.png;compress=true"
		);

		// 透過 albert 的方法，將 albert 資料存入 DB
		albert.insert();
	}

	private static void memberSelectExample() {
		// 假設已經有 albert 在 DB 了
		// 透過 Member 的靜態方法，取得帶有 albert 在 DB 資料的 Member 物件
		Member albert = Member.select("id", 0);
	}

	private static void memberUpdateExample() {
		// 假設已經有 albert 在 DB 了
		Member albert = Member.select("id", 0);

		// 透過 albert 的方法更新地址資料
		albert.setAddress("Taipei,Taiwan");
		// 透過 albert 的方法，更新 DB 裡面的 albert 那筆記錄的資料
		albert.update();
	}

	private static void memberDeleteExample() {
		// 假設已經有 albert 在 DB 了
		Member albert = Member.select("id", 0);

		// 透過 albert 的方法，將 DB 裡面 albert 那筆紀錄刪除
		albert.delete();
	}
}
