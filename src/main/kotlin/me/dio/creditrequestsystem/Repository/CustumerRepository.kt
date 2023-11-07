package me.dio.creditrequestsystem.Repository

import me.dio.creditrequestsystem.Entity.Custumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustumerRepository: JpaRepository<Custumer, Long> {
}