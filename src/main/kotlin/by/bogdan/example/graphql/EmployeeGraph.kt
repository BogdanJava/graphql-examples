package by.bogdan.example.graphql

import by.bogdan.example.model.Employee

interface EmployeeGraph {
    fun getEmployee(id: Long): Employee
    fun getAllEmployees(): List<Employee>
    fun addEmployee(name: String, salary: Long, organizationName: String): Employee
}