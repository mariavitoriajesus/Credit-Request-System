package me.dio.creditrequestsystem.Exception

data class BusinessException( override val message: String?) : RuntimeException (message)
