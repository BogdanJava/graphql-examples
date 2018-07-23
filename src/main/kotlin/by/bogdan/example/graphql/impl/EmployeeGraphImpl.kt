package by.bogdan.example.graphql.impl

import by.bogdan.example.dao.EmployeeDao
import by.bogdan.example.dao.OrganizationDao
import by.bogdan.example.graphql.EmployeeGraph
import by.bogdan.example.model.Employee
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import org.springframework.stereotype.Component

@Component
class EmployeeGraphImpl(val employeeDao: EmployeeDao,
                        val organizationDao: OrganizationDao) : EmployeeGraph {

    @GraphQLMutation(name = "addEmployee")
    override fun addEmployee(@GraphQLArgument(name = "name") name: String,
                             @GraphQLArgument(name = "salary") salary: Long,
                             @GraphQLArgument(name = "organizationName") organizationName: String): Employee {
        val organization = organizationDao.findByName(organizationName)
        return employeeDao.save(Employee(name = name, salary = salary,
                organization = organization))
    }


    @GraphQLQuery(name = "employee")
    override fun getEmployee(@GraphQLArgument(name = "id") id: Long): Employee = employeeDao.getOne(id)

    @GraphQLQuery(name = "employees")
    override fun getAllEmployees(): List<Employee> = employeeDao.findAll()
}