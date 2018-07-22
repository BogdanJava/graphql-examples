package by.bogdan.example.graphql

import by.bogdan.example.model.Employee
import by.bogdan.example.service.EmployeeService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.DataRetrievalFailureException
import org.springframework.web.client.RestTemplate

@Configuration
class GraphQLConfig(private val employeeService: EmployeeService,
                    private val restRemplate: RestTemplate) {

    @Bean
    fun queryResolver(): GraphQLQueryResolver = object : GraphQLQueryResolver {
        fun employee(id: Long): Employee = try {
            employeeService.getById(id)
        } catch (e: DataRetrievalFailureException) {
            // TODO learn how to return errors in GraphQL
            throw RuntimeException("Entity with id=$id not found")
        }
    }
}