package me.dio.creditrequestsystem.Controller

import me.dio.creditrequestsystem.Dto.CustumerDto
import me.dio.creditrequestsystem.Dto.CustumerUpdateDto
import me.dio.creditrequestsystem.Dto.CustumerView
import me.dio.creditrequestsystem.Entity.Custumer
import me.dio.creditrequestsystem.Service.impl.CustumerService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/custumer")
class CustumerController(
    private val custumerService: CustumerService
) {
    @PostMapping
    fun saveCustumer(@RequestBody custumerDto: CustumerDto): ResponseEntity<String> {
        val savedCustumer = this.custumerService.save(custumerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Custumer ${savedCustumer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustumerView> {
        val custumer: Custumer = this.custumerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustumerView(custumer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustumer(@PathVariable id: Long) = this.custumerService.delete(id)

    @PatchMapping
    fun updateCustumer(@RequestParam(value = "custumerId") id: Long,
                       @RequestBody custumerUpdateDto: CustumerUpdateDto): ResponseEntity<CustumerView> {
        val custumer: Custumer = this.custumerService.findById(id)
        val custumerToUpdate = custumerUpdateDto.toEntity(custumer)
        val custumerUpdated: Custumer = this.custumerService.save(custumerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustumerView(custumerUpdated))
    }
}