package by.bogdan.example.service

import by.bogdan.example.model.Employee

interface EmployeeService {
    fun getById(id: Long): Employee
    fun getAll(): List<Employee>
    fun save(e: Employee): Employee
}