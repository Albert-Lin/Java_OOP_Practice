package com.semanticlab;

import com.semanticlab.Character.Archer;
import com.semanticlab.Character.Wizard;
import com.semanticlab.implementation.playerExample.Player;
import com.semanticlab.implementation.playerExample.RealPlayer;
import com.semanticlab.inheritance.tennisExample.TennisCoach;
import com.semanticlab.inheritance.tennisExample.TennisPlayer01;

public class Main {

	public static void main(String[] args) {		
		/*
		 * 在 Class 的部分，我們最後有看到一個 Character 的例子，
		 * 然而我們設想一下，有哪個遊戲只有一種角色? 理論上是沒有。
		 * 接著，我們在思考，不同角色之間不論是可以使用的"能力"(function)
		 * ，或是一些"屬性"(property)，多少會有一些共同的特性。
		 * 為了更簡易的維護以及減少開發重複功能，我們會透過"繼承"(inheritance)
		 * 和"實做"(implementation)來實現 OOP的精神。
		 * 
		 * 接下來我們會先介紹繼承與實作的精神，最後再以 Character例子進一步了解用法
		 */
		
		// 01. 繼承:
		inheritance();
		
		System.out.println("-------我是分隔線--------");
		
		// 02. 實做:
		implementation();
		
		System.out.println("-------我是分隔線--------");
		
		// 03. Character 進階修改:
		characterExample();

	}

	public static void inheritance () {
		TennisPlayer01 player = new TennisPlayer01();
		// 只有在父類別定義的方法:
		player.forehand();
		player.slice();
		
		// 子類別覆寫的方法
		player.backhand();
		
		// 子類別自己的方法
		player.volley();
		
		System.out.println("-------我是分隔線--------");
		/*
		 * 轉型:
		 * 子類別可以轉型成父類別，畢竟父類別有的功能，子類別都有，
		 * 反之，父類別無法轉型成子類別。
		 */
		TennisCoach coach = (TennisCoach)player;
		// 雖然說是轉型，但是調用的方法還是被覆寫過的
		coach.backhand();
		// 雖然本質上是子類別，但是父類別沒有的方法還是不能調用:
		// coach.volley();
	}

	public static void implementation () {
		RealPlayer player = new RealPlayer();
		player.backhand();
		
		// 因為 Player 的方法，Player 都實做了，因此轉型也沒問題!
		Player p = (Player)player;
		p.forehand();
	}

	public static void characterExample () {
		/*
		 * 在開始之前，我們重新想想遊戲角色的設計:
		 * 任何角色，無論法師、弓箭手 ... 等，都有
		 * 一些共同的屬性或方法，例如說:
		 * MP, HP 或是走、跑、跳 & 大絕招，
		 * 不過不同角色之間的大絕招都有些不同，因此我們可以重新這樣設計:
		 * 
		 * 介面: Character : 定義不管哪一種角色都該有的方法
		 * 父類別: CharacterImpl : 實做方法基本邏輯，並做為基底膜組
		 * 子類別: Wizard, Archer ... : 真正角色，除了有基本的功能之外，
		 * 			也擴增一些屬於角色自己的方法
		 * 物件: 個別獨立的實例，各個物件之間都不相互依賴
		 */
		
		Wizard player1 = new Wizard("Albert");
		Archer player2 = new Archer("聖家");
		
		player1.majorAttack();
		System.out.println(player1.toString());
		System.out.println("-----我是分隔線-----");
		player2.majorAttack();
		System.out.println(player2.toString());
	}
}
