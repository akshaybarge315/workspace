package com.ak.InversionOfControl4.impl;

import com.ak.InversionOfControl4.classes.StandardPractice;
import com.ak.InversionOfControl4.interfaces.Trainer;

public class SQLTrainer implements Trainer {
	
	StandardPractice spt;
	String trainerName;
	String message;
	
	public SQLTrainer(StandardPractice spt, String trainerName, String message) {
		this.spt = spt;
		this.trainerName = trainerName;
		this.message = message;
	}

	@Override
	public String giveTask() {
		return trainerName + " says " + message;
	}

	@Override
	public void giveTime() {
		System.out.println(spt.getPracticeTime());
	}

}
