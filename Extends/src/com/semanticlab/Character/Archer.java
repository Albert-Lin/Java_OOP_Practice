package com.semanticlab.Character;

public class Archer extends CharacterImpl {

	// override:
	static String CHARACTER_TYPE = "弓箭手";
	double mp = 20;
	double sp = 80;
	double attackCostRate = 0.75;
	
	public Archer(String name) {
		super(name);
	}

	@Override
	public void majorAttack() {
		super.majorAttack();
		System.out.println("弓箭手大絕!!");
	}
}
