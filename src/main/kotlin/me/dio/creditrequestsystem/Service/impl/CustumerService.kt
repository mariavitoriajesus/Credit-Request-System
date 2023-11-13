package me.dio.creditrequestsystem.Service.impl

import me.dio.creditrequestsystem.Entity.Custumer
import me.dio.creditrequestsystem.Exception.BusinessException
import me.dio.creditrequestsystem.Repository.CustumerRepository
import me.dio.creditrequestsystem.Service.ICustumerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustumerService(
    private val custumerRepository: CustumerRepository
): ICustumerService {
    override fun save(custumer: Custumer): Custumer =
        this.custumerRepository.save(custumer)

    override fun findById(id: Long): Custumer = this.custumerRepository.findById(id)
        .orElseThrow{ throw BusinessException("Id $id not fund")
        }

    override fun delete(id: Long) {
        val custumer: Custumer = this.findById(id)
        this.custumerRepository.delete(custumer)
    }
}