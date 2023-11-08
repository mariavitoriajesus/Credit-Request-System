package me.dio.creditrequestsystem.Entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name= "Custumer")
data class Custumer(
    @Column(nullable = false) var fistName: String = "",
    @Column(nullable = false) var lastName: String = "",
    @Column(nullable = false, unique = true) var cpf: String = "",
    @Column(nullable = false, unique = true) var email: String = "",
    @Column(nullable = false) var income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) var password: String = "",
    @Column(nullable = false) var address: Address = Address(),
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE), mappedBy = "custumer")
    var ccredits: List<Credit> = mutableListOf(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
