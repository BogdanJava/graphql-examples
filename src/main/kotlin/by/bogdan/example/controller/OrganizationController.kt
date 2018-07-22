package by.bogdan.example.controller

import by.bogdan.example.dao.OrganizationDao
import by.bogdan.example.model.Organization
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/getOrganization")
class OrganizationController(var organizationDao: OrganizationDao) {

    @GetMapping
    fun getAllOrganizations(): List<Organization> = organizationDao.findAll()

    @GetMapping("/{name}")
    fun getOrganizationByName(@PathVariable name: String): Organization =
            organizationDao.findByName(name)
}