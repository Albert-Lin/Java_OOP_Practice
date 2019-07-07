package com.semanticlab.Character;

public interface Character {
	// 使用魔法攻擊
	double getMp ();
	
	// 使用物理攻擊
	double getSp();
	
	// 受到攻擊
	void beAttacked (double attack);
	
	String toString ();
	
	// 顯示角色當前資訊
	void showCharacterInfo ();
	
	// 大絕招
	void majorAttack ();
}
