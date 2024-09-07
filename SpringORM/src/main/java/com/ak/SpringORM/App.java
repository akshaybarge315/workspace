package com.ak.SpringORM;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ak.SpringORM.daoImpl.EmployeeDAOImpl;
import com.ak.SpringORM.entity.Employee;

public class App {
  public static void main(String[] args) {
	  
	  ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	  SessionFactory sf = (SessionFactory) ac.getBean("sessionfactory");
	  
	  EmployeeDAOImpl edao = (EmployeeDAOImpl) ac.getBean("edao");
	  
	  Employee e = (Employee) ac.getBean("employee");
	  
	  edao.addEmployee(e, sf);
  }
}
