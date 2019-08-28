package com.tw.apistackbase.controller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.modules.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	private static List<Employee> employees=new ArrayList<Employee>() {{
		add(new Employee(1,"xiaohong",12,"female"));
		add(new Employee(2,"xiaolu",13,"male"));
		add(new Employee(3,"xiaoliu",15,"female"));
		
	}};
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		return ResponseEntity.ok(employees);
	}
//	@GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
//		
//		for (Employee employee : employees) {
//			if(employee.getId()==id) {
//				return ResponseEntity.ok(employee);
//			}
//		}
//		return null;
//	}
//	@GetMapping
//	public ResponseEntity<List<Employee>> getEmployeeByname(@RequestParam("name") String nameLike){
//		List<Employee> employeeResult = new ArrayList<Employee>();
//		for (Employee employee : employees) {
//			if(employee.getName().contains(nameLike)) {
//				employeeResult .add(employee);	
//			}
//		}
//		return ResponseEntity.ok(employeeResult);
//	}
	@PostMapping(consumes="application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employees.add(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping(consumes="application/json")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employeeUpdate){
		for (Employee employee : employees) {
			if(employee.getId()==employeeUpdate.getId()) {
			employee.setAge(employeeUpdate.getAge());
			employee.setName(employeeUpdate.getName());
			employee.setGender(employeeUpdate.getGender());
			}
			
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@DeleteMapping("/{id}")
		public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		    employees.remove(id);
		   return ResponseEntity.status(HttpStatus.OK).build();
		}

}
