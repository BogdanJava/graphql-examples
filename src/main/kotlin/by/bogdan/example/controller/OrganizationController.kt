package by.bogdan.example.controller

import by.bogdan.example.dao.OrganizationDao
import by.bogdan.example.model.Organization
import by.bogdan.example.model.OrganizationArray
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/organization")
class OrganizationController(var organizationDao: OrganizationDao) {

    @GetMapping
    fun getAllOrganizations(): OrganizationArray = OrganizationArray(organizationDao.findAll())

    @GetMapping("/{name}")
    fun getOrganizationByName(@PathVariable name: String): Organization =
            organizationDao.findByName(name)
}