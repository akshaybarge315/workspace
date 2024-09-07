package com.tap.InversionOfControl2.classes;

import com.tap.InversionOfControl2.interfaces.Trainer;

public class SQLTrainer implements Trainer {

	@Override
	public void giveTask() {
		System.out.println("Complete SQL queries daily");
	}

}
