package by.bogdan.example.graphql.impl

import by.bogdan.example.dao.EmployeeDao
import by.bogdan.example.graphql.EmployeeGraph
import by.bogdan.example.model.Employee
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLQuery
import org.springframework.stereotype.Service

@Service
class EmployeeGraphImpl(val employeeDao: EmployeeDao) : EmployeeGraph {
    @GraphQLQuery(name = "employee")
    override fun getEmployee(@GraphQLArgument(name = "id") id: Long): Employee =
            employeeDao.getOne(id)

    @GraphQLQuery(name = "employees")
    override fun getAllEmployees(): List<Employee> =
            employeeDao.findAll()
}