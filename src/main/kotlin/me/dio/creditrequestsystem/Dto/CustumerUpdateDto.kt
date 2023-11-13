package me.dio.creditrequestsystem.Dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditrequestsystem.Entity.Custumer
import java.math.BigDecimal

data class CustumerUpdateDto(
    @field:NotEmpty(message = "Invalid input") val fistName: String,
    @field:NotEmpty(message = "Invalid input") val lastName: String,
    @field:NotNull(message = "Invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input") val zipCode: String,
    @field:NotEmpty(message = "Invalid input") val street: String
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
