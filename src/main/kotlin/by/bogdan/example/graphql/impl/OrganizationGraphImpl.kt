package by.bogdan.example.graphql.impl

import by.bogdan.example.graphql.OrganizationGraph
import by.bogdan.example.model.Employee
import by.bogdan.example.model.Organization
import by.bogdan.example.model.OrganizationArray
import io.leangen.graphql.annotations.GraphQLContext
import io.leangen.graphql.annotations.GraphQLQuery
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OrganizationGraphImpl(val http: RestTemplate,
                            @Value("server.base-url")
                            val baseUrl: String) : OrganizationGraph {

    @GraphQLQuery(name = "getOrganization")
    override fun getOrganization(@GraphQLContext employee: Employee): Organization? =
            http.getForEntity("$baseUrl/api/getOrganization/${employee.organization?.name}",
                    Organization::class.java).body

    @GraphQLQuery(name = "organizations")
    override fun getAllOrganizations(): List<Organization>? =
            http.getForEntity("$baseUrl/api/getOrganization",
                    OrganizationArray::class.java).body?.organizations
}