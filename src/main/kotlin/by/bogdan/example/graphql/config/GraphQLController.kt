package by.bogdan.example.graphql.config

import graphql.ExecutionInput
import graphql.GraphQL
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class GraphQLController(val graphQL: GraphQL) {

    @PostMapping("/graphql",
            consumes = [APPLICATION_JSON_UTF8_VALUE], produces = [APPLICATION_JSON_UTF8_VALUE])
    fun indexFromAnnotated(@RequestBody request: Map<String, String>, raw: HttpServletRequest)
            : Map<String, Any> {
        return graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request["query"])
                .operationName(request["operationName"])
                .context(raw)
                .build()).toSpecification()
    }
}