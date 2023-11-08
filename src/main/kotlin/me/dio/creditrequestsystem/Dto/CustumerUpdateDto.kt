package me.dio.creditrequestsystem.Dto

import me.dio.creditrequestsystem.Entity.Custumer
import java.math.BigDecimal

data class CustumerUpdateDto(
    val fistName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(custumer: Custumer): Custumer {
        custumer.fistName = this.fistName
        custumer.lastName = this.lastName
        custumer.income = this.income
        custumer.address.street = this.street
        custumer.address.zipCode = this.zipCode

        return custumer
    }
}
