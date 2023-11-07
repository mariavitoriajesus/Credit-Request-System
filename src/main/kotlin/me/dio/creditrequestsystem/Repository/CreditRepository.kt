package me.dio.creditrequestsystem.Repository

import me.dio.creditrequestsystem.Entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

}