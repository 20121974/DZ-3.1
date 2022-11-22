package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.servis.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;//поле
    private final EmployeeService employeeServise;

    public EmployeeController(EmployeeService employeeService, EmployeeService employeeService1) {
        this.employeeService = employeeService1;
        this.employeeServise = employeeService;
    }//конструктор

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {//получить всех сотрудников из базы сотрудников с использованием метода сервиса получить
        return this.employeeServise.getAllEmployees();
    }
    @PostMapping("/employees")
    public Employee createEmployee(EmployeeRequest employeeRequest) {//добавить сотрудника в базу сотрудников с использованием метода сервиса добавить
        return this.employeeServise.addEmployee(employeeRequest);
    }
    @GetMapping("/employees/salary/sum")//получить сумму ЗП
    public int getSalarySum() {
        return this.employeeServise.getSalarySum();
    }
    @GetMapping("/employees/salary/MinSalary")//получить минимальную ЗП
    public Object getMinSalary(Employee employee) {
        return this.employeeServise.getMinSalary();
    }
    @GetMapping("/employees/salary/MaxSalary")//получить максимальную ЗП
    public Object getMaxSalary(Employee employee) {
        return this.employeeServise.getMaxSalary();
    }
    @GetMapping("/employees/salary/SalaryAverage")//получить среднюю ЗП
    public Object getSalaryAverage() {
        return this.employeeServise.getSalaryAverage();
    }
    @GetMapping("/employees/salary/high-salary")//получить сотрудников с ЗП выше средней
    public List<Employee> getTingAllEmployeesWhoseSalaryIsHigherThanTheAverageSalary() {
        return this.employeeServise.getHighSalary();
    }
}
