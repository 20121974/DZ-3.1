package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.servis.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;//поле

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }//конструктор

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {//получить всех сотрудников из базы сотрудников с использованием метода сервиса получить
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {//добавить сотрудника в базу сотрудников с использованием метода сервиса добавить
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")//получить сумму ЗП
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employees/salary/MinSalary")//получить минимальную ЗП
    public Object getMinSalary() {
        return this.employeeService.getMinSalary();
    }

    @GetMapping("/employees/salary/MaxSalary")//получить максимальную ЗП
    public Object getMaxSalary() {
        return this.employeeService.getMaxSalary();
    }

    @GetMapping("/employees/salary/high-salary")//получить сотрудников с ЗП выше средней
    public Object getTingAllEmployeesWhoseSalaryIsHigherThanTheAverageSalary() {
        return this.employeeService.getHighSalary();
    }
}
