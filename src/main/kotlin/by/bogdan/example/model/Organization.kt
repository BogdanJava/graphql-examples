package by.bogdan.example.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "organization")
data class Organization(
        @Id @GeneratedValue var id: Long? = 0,
        var name: String? = "",
        @JsonIgnore @OneToMany(mappedBy = "organization")
        var employees: Set<Employee>? = null) {
    constructor() : this(0, "", null)
}