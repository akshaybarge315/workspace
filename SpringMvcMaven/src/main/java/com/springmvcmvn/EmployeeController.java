package com.springmvcmvn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.Employee;
import com.daoImpl.EmployeeDAOImpl;

@Controller
public class EmployeeController {
	ApplicationContext ac;
	EmployeeDAOImpl ed;
	
	public EmployeeController(){
		ac = new ClassPathXmlApplicationContext("beans.xml");
		ed = (EmployeeDAOImpl) ac.getBean("edaoi");
	}
	
	@RequestMapping("/")
	public String indexPage(Model model) {
		List<Employee> employees = ed.getAllEmployees();
        model.addAttribute("employees", employees);
		return "home-page";
	}
	
	@RequestMapping("showFormForAdd")
    public String showFormForAdd() {
        return "add-page";
    }
	
	@RequestMapping("dataInsert")
	public String inertData(@RequestParam("empid") int empid, @RequestParam("ename") String ename, @RequestParam("jobrole") String jobrole, 
			@RequestParam("dept") String dept, @RequestParam("deptid") int deptid) {
		
		Employee e = new Employee(empid, ename, jobrole, dept, deptid);
		
		ed.insert(e);
		return "redirect:/";
	}
	
	@RequestMapping("deleteData")
	public String deleteData(@RequestParam("empid") int empid) {
		ed.delete(empid);
		
		return "redirect:/";
	}
	
	@RequestMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("empid") int empid, Model model) {
        Employee employee = ed.getEmployee(empid);
        model.addAttribute("employee", employee);
        return "update-page";
    }
	
	@RequestMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        
        ed.update(employee);
     
        return "redirect:/"; 
    }
}
