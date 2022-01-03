package io.github.therealmone.kotlin.spring.example.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "resource")
class Resource(

    @Id
    @GeneratedValue(generator = "UUID")
    var id: UUID?,

    @Column(name = "data")
    var data: String?

)