package me.dio.creditrequestsystem.Dto

import me.dio.creditrequestsystem.Entity.Credit
import me.dio.creditrequestsystem.EnumMeration.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val emailCustumerView: String?,
    val incomeCustumer:BigDecimal?
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallment,
        status = credit.status,
        emailCustumerView = credit.custumer?.email,
        incomeCustumer = credit.custumer?.income
    )

}
