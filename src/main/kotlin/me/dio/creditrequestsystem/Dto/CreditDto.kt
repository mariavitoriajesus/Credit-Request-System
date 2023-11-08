package me.dio.creditrequestsystem.Dto

import me.dio.creditrequestsystem.Entity.Credit
import me.dio.creditrequestsystem.Entity.Custumer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFistInstallment: LocalDate,
    val numberOfInstallments: Int,
    val custumerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFistInstallment,
        numberOfInstallment = this.numberOfInstallments,
        custumer = Custumer(id = this.custumerId)
    )

}
