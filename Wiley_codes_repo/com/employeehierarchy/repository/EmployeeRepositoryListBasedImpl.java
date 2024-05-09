package com.employeehierarchy.repository;

import com.employeehierarchy.exception.InvalidEmployeeInfoException;
import com.employeehierarchy.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryListBasedImpl implements EmployeeRepository {


    List<Employee> employees;

    public EmployeeRepositoryListBasedImpl(){
        employees = new ArrayList<>();
    }

    public void saveEmployee(Employee employee) {
        if (employee.getId() <= 0 || employee.getSalary() <= 0 ||
                employee.getName() == null || employee.getName().isBlank() ||
                employee.getEmail() == null || employee.getEmail().isBlank()) {
            throw new InvalidEmployeeInfoException("Can't Store the Data , Please enter valid inputs!");
        }
        employees.add(employee);
    }


    public Employee findEmployee(int id) {
        return employees.stream().filter(e->e.getId()==id).findFirst().get();
    }


    public void deleteEmployee(int id) {
        Employee employee = findEmployee(id);
        employees.remove(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
