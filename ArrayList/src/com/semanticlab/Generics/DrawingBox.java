package com.semanticlab.Generics;

import java.util.ArrayList;
import java.util.Random;

/* 
 * 改寫時間到了，Array 實在太不彈性了，
 * 讓我們改成 ArrayList
 */
public class DrawingBox <T> {

	/*
	 * 我們先設計一個用來存放所有項目的陣列，
	 * 如果還記得資料結構中的鏈結串列，
	 * 那先說明，因為 ArrayList 還沒講解
	 * 所以會用比不彈性的陣列處理
	 */
	private ArrayList<T> itemArrayList;
		
	// 抽出來後要丟掉還是放回
	private boolean deleteWhenPopOut;
	
	/*
	 * Constructor
	 */
	public DrawingBox (boolean deleteWhenPopOut) {
		itemArrayList = new ArrayList<T>();
		this.deleteWhenPopOut = deleteWhenPopOut;
	}
	
	/*
	 * 加入型別為 T 的項目
	 */
	public void push(T item) {
		itemArrayList.add(item);
	}
	
	/*
	 * 隨機取一個項目出來，這裡的細項邏輯可以不用了解
	 * 主要要看的是，return 的型別可以是動態的 ，
	 * 端看初始的設定
	 */
	public T pop() {
		// 取亂數(每次都將抽獎箱搖一搖)
		Random rand = new Random();
		int  index = rand.nextInt(itemNumber());
		
		if (itemArrayList.get(index) == null) {
			return this.pop();
		} else {
			T result = itemArrayList.get(index);
			if (deleteWhenPopOut) {
				itemArrayList.remove(index);
			}
			return result;
		}
	}
	
	/*
	 * 檢查箱子中所剩的項目個數
	 */
	public int itemNumber () {
		return itemArrayList.size();
	}
	
	/*
	 * 檢查箱子裡面是否空了
	 */
	public boolean isEmpty () {
		return itemNumber() == 0;
	}
}
