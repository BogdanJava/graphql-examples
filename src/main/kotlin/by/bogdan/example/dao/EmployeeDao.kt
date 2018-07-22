package by.bogdan.example.dao

import by.bogdan.example.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface EmployeeDao : JpaRepository<Employee, Long> {
    @Query("select e from Employee e where lower(e.name) = lower(:name)")
    fun findByName(@Param("name") name: String): Employee
}