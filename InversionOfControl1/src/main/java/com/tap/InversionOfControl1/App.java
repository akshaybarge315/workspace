package com.tap.InversionOfControl1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.InversionOfControl1.impl.IndianAirForce;
import com.tap.InversionOfControl1.impl.IndianArmy;
import com.tap.InversionOfControl1.impl.IndianNavy;

public class App {
  public static void main(String[] args) {
	   ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	   
	   IndianArmy ia = new IndianArmy(ac);
	   IndianNavy in = new IndianNavy(ac);
	   IndianAirForce iaf = new IndianAirForce(ac);
	   
	   ia.addressPresident();
	   in.addressPresident();
	   iaf.addressPresident();
  }
}
