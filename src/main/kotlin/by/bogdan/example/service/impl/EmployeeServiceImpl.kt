package by.bogdan.example.service.impl

import by.bogdan.example.dao.EmployeeDao
import by.bogdan.example.model.Employee
import by.bogdan.example.service.EmployeeService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class EmployeeServiceImpl(private val dao: EmployeeDao) : EmployeeService {
    override fun getById(id: Long) = dao.getOne(id)
    override fun getAll(): List<Employee> = dao.findAll()
    override fun save(e: Employee) = dao.save(e)
}