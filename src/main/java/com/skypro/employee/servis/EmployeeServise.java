package com.skypro.employee.servis;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();


    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }//получить всех сотрудников

    public Employee addEmployee(EmployeeRequest employeeRequest) {//добавление сотрудника
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null){
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

    public OptionalInt getMinSalary() {
        return employees.values().stream().mapToInt(Employee::getSalary).min();//Получение сотрудника с минимальной зарплатой
    }
    public OptionalInt getMaxSalary() {
        return employees.values().stream().mapToInt(Employee::getSalary).max();//Получение сотрудника с максимальной зарплатой
    }

    public OptionalDouble getSalaryAverage() {
        return employees.values().stream().mapToInt(Employee::getSalary).average();//средняя ЗП
    }

    public OptionalDouble getHighSalary() {
        return employees.values().stream().mapToInt(Employee::getSalary).filter(e -> e.employeeRequest.getSalary() >
                getSalaryAverage()).collect(Collectors.toList());
    }

}
