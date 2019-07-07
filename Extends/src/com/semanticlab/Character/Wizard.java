package com.semanticlab.Character;

public class Wizard extends CharacterImpl {
	// override:
	static String CHARACTER_TYPE = "魔法師";
	double mp = 100;
	double sp = 20;
	double attackCostRate = 0.6;
	
	public Wizard(String name) {
		super(name);
	}
	
	@Override
	public void majorAttack() {
		super.majorAttack();
		System.out.println("魔法大絕!!");
	}
}
