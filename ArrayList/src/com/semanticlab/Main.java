package com.semanticlab;

import java.util.ArrayList;

import com.semanticlab.Generics.DrawingBox;

public class Main {

	public static void main(String[] args) {
		/*
		 * 01. ArrayList
		 * 		在說明泛型類別之後，我們可以看到，可以為共同邏輯
		 * 		建立泛型類別，透過初始化的時候給定型別，進行後續
		 * 		應用。
		 * 
		 * 		然後我們回過頭想想陣列，Array 在初始的時候就要
		 * 		給定大小了，可是像是抽獎箱的例子，我們有時候需要的
		 * 		是動態空間，隨意的在整個容器中增、刪、改容器中的項
		 * 		目，因此資料結構中的鏈結串列就派上用場了。
		 * 
		 * 		下面先說明 ArrayList 的方法，然後改寫 DrawingBox
		 * 
		 */
		arrayListEg();
		
		drawingBoxEg();
	}

	
	public static void arrayListEg() {
		// 宣告 & 初始化
		ArrayList<String> strList = new ArrayList<String>();
		
		// 新增: 永遠會新增於整個列表的最後面
		String[] strArray = { "位子", "雅卉", "呂呂", "青椒", "FISH", "媛婷", "聖家" };
		for (String name : strArray) {
			strList.add(name);
		}
		// 顯示一下
		showArrayList(strList);
		
		// 新增: 新增在某個特殊 index
		strList.add(6, "Albert");
		showArrayList(strList);
		
		// 修改: 透過 index 修改
		strList.set(0, "雅卉");
		strList.set(1, "位子");
		showArrayList(strList);
		
		// 刪除: 透過 index 刪除
		strList.remove(6);
		showArrayList(strList);
	}
	
	private static void showArrayList(ArrayList<String> list) {
		System.out.println("=顯示List============");
		for (String strData : list) {
			System.out.println(strData);
		}
		System.out.println("====================");
	}

	public static void drawingBoxEg(){
		String[] names = { "位子", "雅卉", "呂呂", "FISH", "青椒", "聖家", "媛婷"};
		DrawingBox<String> strBox = new DrawingBox<String>(false);
		for (String name : names) {
			strBox.push(name);
		}
		
		System.out.println("=姓名箱=========");
		for (int i = 0; i < 2; i++) {
			System.out.println(strBox.pop());
		}
		System.out.println("==============");
		
		int [] numbers = {0, 1, 2, 3, 4, 41, 54};
		DrawingBox<Integer> intBox = new DrawingBox<Integer>(false);
		for (int number : numbers) {
			intBox.push(number);
		}
		
		System.out.println("=座號箱=========");
		for (int i = 0; i < 2; i++) {
			System.out.println(intBox.pop());
		}
		System.out.println("==============");
	}
}
