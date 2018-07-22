package by.bogdan.example

import by.bogdan.example.dao.EmployeeDao
import by.bogdan.example.dao.OrganizationDao
import by.bogdan.example.model.Employee
import by.bogdan.example.model.Organization
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class SpringGraphqlApplication {
    @Bean
    fun init(dao: EmployeeDao,
             orgDao: OrganizationDao) = CommandLineRunner {
        dao.saveAll(
                listOf(
                        Employee(name = "Bogdan", salary = 500,
                                organization = orgDao.save(Organization(name = "iTechArt"))),
                        Employee(name = "Stefa", salary = 500,
                                organization = orgDao.save(Organization(name = "freelance"))),
                        Employee(name = "Stas", salary = 500,
                                organization = orgDao.save(Organization(name = "superlama"))),
                        Employee(name = "Bronik", salary = 500,
                                organization = orgDao.save(Organization(name = "IBA Group")))
                )
        )
    }

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate =
            builder.build()
}

fun main(args: Array<String>) {
    runApplication<SpringGraphqlApplication>(*args)
}
