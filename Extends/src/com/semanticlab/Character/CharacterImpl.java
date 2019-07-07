package com.semanticlab.Character;

public class CharacterImpl implements Character {
	// 角色類型
	protected static String CHARACTER_TYPE = "基底角色 (原型)";
	// 玩家名稱
	protected String name = "";
	// 生命值
	protected double hp = 100;
	// 魔力值
	protected double mp = 70;
	// 物理攻擊值
	protected double sp = 30;
	// 受到攻擊時，HP扣損比例
	protected double attackCostRate = 1.0;

	// Constructor
	public CharacterImpl (String name) {
		this.name = name;
	}
	
	@Override
	// 使用魔法攻擊
	public double getMp () {
		System.out.println(name + "使用了魔法攻擊");
		return mp;
	}
	
	@Override
	// 使用物理攻擊
	public double getSp () {
		System.out.println(name + "使用了物理攻擊");
		return sp;
	}
	
	@Override
	// 受到攻擊
	public void beAttacked (double attack) {
		double hpCost = attack * attackCostRate;
		hp -= hpCost;
		System.out.println(name + "受到攻擊，生命值扣損: " + Double.toString(hpCost) );
	}
	
	@Override
	public String toString () {
		return "玩家: " + name + "\n"
				+ "HP: " + hp + "\n"
				+ "MP: " + mp + "\n"
				+ "SP: " + sp; 
	}
	
	@Override
	// 顯示角色當前資訊
	public void showCharacterInfo () {
		System.out.println(toString());
	}
	
	// 顯示角色類型
	public static void SHOW_CHARACTER_TYPE () {
		System.out.println(CHARACTER_TYPE);
	}

	
	@Override
	public void majorAttack() {
		System.out.println("(使用者按下AB上BA上BC下右旋一圈)放大絕招啦: ");
	}
}
