package com.tap.InversionOfControl2.classes;

import com.tap.InversionOfControl2.interfaces.Trainer;

public class WebTrainer implements Trainer{

	@Override
	public void giveTask() {
		System.out.println("Create web-pages Daily");
	}

}
