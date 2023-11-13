package me.dio.creditrequestsystem.Dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.creditrequestsystem.Entity.Credit
import me.dio.creditrequestsystem.Entity.Custumer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "invalid input") val creditValue: BigDecimal,
    @field:Future val dayFistInstallment: LocalDate,
    val numberOfInstallments: Int,
    @field:NotNull(message = "invalid input") val custumerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFistInstallment,
        numberOfInstallment = this.numberOfInstallments,
        custumer = Custumer(id = this.custumerId)
    )

}
