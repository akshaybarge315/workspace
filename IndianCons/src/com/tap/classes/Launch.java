package com.tap.classes;

import com.tap.impl.IndianAirForce;
import com.tap.impl.IndianArmy;
import com.tap.impl.IndianNavy;

public class Launch {

	public static void main(String[] args) {
		IndianArmy ia = new IndianArmy();
		IndianAirForce iaf = new IndianAirForce();
		IndianNavy in = new IndianNavy();
		
		ia.addressPresident();
		iaf.addressPresident();
		in.addressPresident();
		
	}

}
