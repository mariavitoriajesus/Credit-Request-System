package me.dio.creditrequestsystem.Controller

import me.dio.creditrequestsystem.Dto.CreditDto
import me.dio.creditrequestsystem.Dto.CreditView
import me.dio.creditrequestsystem.Dto.CreditViewList
import me.dio.creditrequestsystem.Entity.Credit
import me.dio.creditrequestsystem.Service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String>{
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Custumer ${credit.custumer?.fistName} saved!")
    }

    @GetMapping
    fun findAllByCustumerId(@RequestParam(value = "custumerId") custumerId: Long):
            ResponseEntity<List<CreditViewList>>{
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustumer(custumerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "custumerId") custumerId: Long, @PathVariable creditCode: UUID)
    : CreditView {
        val credit = this.creditService.findByCreditCode(custumerId, creditCode)
        return CreditView(credit)
    }
}