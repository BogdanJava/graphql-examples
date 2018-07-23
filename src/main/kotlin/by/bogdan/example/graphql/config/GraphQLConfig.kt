package by.bogdan.example.graphql.config

import by.bogdan.example.graphql.EmployeeGraph
import by.bogdan.example.graphql.OrganizationGraph
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import io.leangen.graphql.GraphQLSchemaGenerator
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfig(val employeeGraph: EmployeeGraph,
                    val organizationGraph: OrganizationGraph) {

    @Bean
    fun graphQL(): GraphQL {
        val schema: GraphQLSchema = GraphQLSchemaGenerator()
                .withBasePackages("by.bogdan.example.graphql.impl")
                .withOperationsFromSingletons(employeeGraph, organizationGraph)
                .withResolverBuilders(AnnotatedResolverBuilder())
                .withValueMapperFactory(JacksonValueMapperFactory())
                .generate()
        return GraphQL.newGraphQL(schema).build()
    }

}