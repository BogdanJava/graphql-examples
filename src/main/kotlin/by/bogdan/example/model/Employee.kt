package by.bogdan.example.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.ToString
import org.apache.commons.lang3.builder.ToStringExclude
import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(@Id @GeneratedValue var id: Long = 0,
                    var name: String? = "",
                    var salary: Long = 0,
                    @ManyToOne @JoinColumn(name = "organization_id")
                    @JsonIgnore var organization: Organization?) {
    constructor() : this(0, "", 0, null)

    override fun toString(): String {
        return mapOf(Pair("id", id), Pair("name", name), Pair("salary", salary),
                Pair("organization", organization?.name)).toString()
    }
}