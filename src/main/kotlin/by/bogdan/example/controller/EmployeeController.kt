package by.bogdan.example.controller

import by.bogdan.example.dao.EmployeeDao
import by.bogdan.example.model.Employee
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employee")
class EmployeeController(private val employeeDao: EmployeeDao) {

    @GetMapping(path = ["", "/"])
    fun getAll(): List<Employee> =
            employeeDao.findAll()

    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String) = try {
        employeeDao.findByName(name)
    } catch (e: EmptyResultDataAccessException) {
        mapOf(Pair("message", e.message))
    }

}

