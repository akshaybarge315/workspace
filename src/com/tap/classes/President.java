package com.tap.classes;

public class President {
	public static String name = "Draupadi Mormu";
	
	private static President p = new President();
	
	static public President getPresident() {
		return p;
	}

	private President() {}
}
