package me.dio.creditrequestsystem.Service.impl

import me.dio.creditrequestsystem.Entity.Credit
import me.dio.creditrequestsystem.Repository.CreditRepository
import me.dio.creditrequestsystem.Service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val custumerService: CustumerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            custumer = custumerService.findById(credit.custumer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustumer(custumerId: Long): List<Credit> =
        this.creditRepository.findAllByCustumer(custumerId)

    override fun findByCreditCode(custumerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not fund"))
        return if(credit.custumer?.id == custumerId) credit else throw RuntimeException("Contact admin")
    }
}