package com.semanticlab.Generics;

import java.lang.reflect.Array;
import java.util.Random;

/* 
 * 泛型類別最重要的是，雖然型別不同，但具有相同邏輯，
 * 所以泛型類別最常見的會是:
 * 01. "容器"
 * 02. "資料結構模型"
 * 因為這兩者其實大多數不牽涉資料本身，主要在邏輯層面。
 * 
 * 首先 <T> 就是代表此類別是一個了泛型類別，
 * 其中 T 只是代表一個虛擬的型別，意思是任何型別都可以用，
 * 你也可以換成任何字
 * 
 * 以下是一個簡單抽獎箱類別，對於抽獎箱而言，其實不管裡面存放的是
 * "字串"，"數字"或是自訂的"彩球"都無所謂，
 * 因為他實際的功能是:
 * 01. 加入項目
 * 02. 從所有項目中隨機取出一個
 */
public class DrawingBox <T> {

	/*
	 * 我們先設計一個用來存放所有項目的陣列，
	 * 如果還記得資料結構中的鏈結串列，
	 * 那先說明，因為 ArrayList 還沒講解
	 * 所以會用比不彈性的陣列處理
	 */
	private T[] itemArrayList;
	
	/*
	 * 這只是因為我們用 Array 所以才建立的虛擬屬性
	 * 他的功能只是在 initialize array 的時候用的，
	 * 基本上可以忽略
	 */
	private static Class<?> virtualClass = null;
	
	// 抽出來後要丟掉還是放回
	private boolean deleteWhenPopOut;
	
	/*
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public DrawingBox (Class<T> tClass, int size, boolean deleteWhenPopOut) {
		// 這只因為我們用 Array 所以搞得這麼複雜，
		// 其實他就是代表宣告一個型別為 T 的陣列
		virtualClass = tClass;
		itemArrayList = (T[]) Array.newInstance(virtualClass, size);
		for (T t : itemArrayList) {
			t = null;
		}
		
		this.deleteWhenPopOut = deleteWhenPopOut;
	}
	
	/*
	 * 加入型別為 T 的項目
	 */
	public void push(T item) {
		for (int i = 0; i < itemArrayList.length; i++) {
			if (itemArrayList[i] == null) {
				itemArrayList[i] = item;
				break;
			}
		}
	}
	
	/*
	 * 隨機取一個項目出來，這裡的細項邏輯可以不用了解
	 * 主要要看的是，return 的型別可以是動態的 ，
	 * 端看初始的設定
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		// 取亂數(每次都將抽獎箱搖一搖)
		Random rand = new Random();
		int  index = rand.nextInt(itemNumber());
		
		if (itemArrayList[index] == null) {
			return this.pop();
		} else {
			// 這裡稍微注意一下，因為有可能抽出不放回，所以先把結果拉出來
			T result = itemArrayList[index];
			if (deleteWhenPopOut) {
				// 因為是沒有彈性的 array 所以如果抽出不放回，
				// 就要產生一新的 array 去記錄剩餘的項目，
				// 這可以省略，反正就只是抽出不放回而已
				T[] newItemArrayList = (T[]) Array.newInstance(virtualClass, itemNumber() - 1);
				if (itemNumber() > 1) {
					int j = 0;
					for (int i = 0; i < itemArrayList.length; i++) {
						if (i != index) {
							newItemArrayList[j] = itemArrayList[i];
							j++;
						}
					}
					itemArrayList = newItemArrayList;					
				}
			}
			return result;
		}
	}
	
	/*
	 * 檢查箱子中所剩的項目個數
	 */
	public int itemNumber () {
		return itemArrayList.length;
	}
	
	/*
	 * 檢查箱子裡面是否空了
	 */
	public boolean isEmpty () {
		return itemNumber() == 0;
	}
}
