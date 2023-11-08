package me.dio.creditrequestsystem.Service

import me.dio.creditrequestsystem.Entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustumer(custumerId: Long): List<Credit>
    fun findByCreditCode(custumerId: Long,creditCode: UUID): Credit
}