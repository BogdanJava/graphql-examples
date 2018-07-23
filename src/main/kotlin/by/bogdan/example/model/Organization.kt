package by.bogdan.example.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "organization")
data class Organization(
        @Id @GeneratedValue var id: Long = 0,
        var name: String = "",
        @OneToMany(mappedBy = "organization")
        @JsonIgnore var employees: Set<Employee>? = null) {
    constructor() : this(0, "", null)

    override fun toString(): String {
        return mapOf(Pair("id", id), Pair("name", name)).toString()
    }
}