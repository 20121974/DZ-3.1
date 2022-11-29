package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeServiсe;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeServiсe = employeeService;
    }//конструктор

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {//получить всех сотрудников из базы сотрудников с использованием метода сервиса получить
        return this.employeeServiсe.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(EmployeeRequest employeeRequest) {//добавить сотрудника в базу сотрудников с использованием метода сервиса добавить
        return this.employeeServiсe.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")//получить сумму ЗП
    public int getSalarySum() {
        return this.employeeServiсe.getSalarySum();
    }

    @GetMapping("/employees/salary/MinSalary")//получить минимальную ЗП
    public Employee getMinSalary(Employee employee) {
        return this.employeeServiсe.getMinSalary();
    }

    @GetMapping("/employees/salary/MaxSalary")//получить максимальную ЗП
    public Employee getMaxSalary(Employee employee) {
        return this.employeeServiсe.getMaxSalary();
    }

    @GetMapping("/employees/salary/SalaryAverage")//получить среднюю ЗП
    public Object getSalaryAverage() {
        return this.employeeServiсe.getSalaryAverage();
    }

    @GetMapping("/employees/salary/high-salary")//получить сотрудников с ЗП выше средней
    public List<Employee> getTingAllEmployeesWhoseSalaryIsHigherThanTheAverageSalary() {
        return this.employeeServiсe.getHighSalary();
    }
}
