package by.bogdan.example.graphql

import by.bogdan.example.model.Employee
import by.bogdan.example.model.Organization

interface OrganizationGraph {
    fun getOrganization(employee: Employee): Organization?
    fun getAllOrganizations(): List<Organization>?
}