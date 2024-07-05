package com.app.tester;

import java.time.LocalDate;

import com.app.entity.Employee;
import com.app.linkedlist.SinglyLinkedList;

public class TesterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		Employee emp1 = new Employee("John", "Doe", 30, 50000, LocalDate.of(2020, 1, 1));
        Employee emp2 = new Employee("Jane", "Doe", 28, 55000, LocalDate.of(2021, 2, 1));
        Employee emp3 = new Employee("Jim", "Beam", 35, 60000, LocalDate.of(2019, 3, 1));
        Employee emp4 = new Employee("Alice", "Smith", 25, 45000, LocalDate.of(2023, 5, 1));
        
        list.addEmployee(emp1);
        list.addEmployee(emp2);
        list.addEmployee(emp3);
        list.addEmployee(emp4);
        
        list.printEmployees();
        

		
		
	}

}
