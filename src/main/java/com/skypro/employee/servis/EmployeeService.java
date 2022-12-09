package com.skypro.employee.servis;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();


    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }//получить всех сотрудников

    public Employee addEmployee(EmployeeRequest employeeRequest) {//добавление сотрудника
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);//положить
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum();//Получение суммы зарплат сотрудников
    }

    public Employee getMinSalary() {//Получение сотрудника с минимальной зарплатой
        Employee result = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : getAllEmployees())
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        return result;
    }

    public Employee getMaxSalary() {
        Employee result = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : getAllEmployees())
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        return result;
    }

    public Object getSalaryAverage() {
        return employees.values().stream().mapToInt(Employee::getSalary).average();//средняя ЗП
    }

    public List<Employee> getHighSalary() {
        double average = (double) getSalaryAverage();
        return (List<Employee>) employees.values().stream().filter(e -> e.getSalary() > average);
    }

}
