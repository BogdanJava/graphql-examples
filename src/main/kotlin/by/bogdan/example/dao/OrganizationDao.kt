package by.bogdan.example.dao

import by.bogdan.example.model.Organization
import org.springframework.data.jpa.repository.JpaRepository

interface OrganizationDao : JpaRepository<Organization, Long> {
    fun findByName(name: String): Organization
}