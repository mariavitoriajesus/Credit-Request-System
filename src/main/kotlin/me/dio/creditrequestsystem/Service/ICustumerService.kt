package me.dio.creditrequestsystem.Service

import me.dio.creditrequestsystem.Entity.Custumer

interface ICustumerService {
    fun save(custumer: Custumer): Custumer
    fun findById(id: Long): Custumer
    fun delete(id: Long)
}