package com.example.databaseDemo.controller

import com.example.databaseDemo.model.Customer
import com.example.databaseDemo.repo.CustomerRepository
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import com.opencsv.bean.CsvToBeanBuilder
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import java.io.FileReader

@RestController
class WebController {

    @Autowired
    lateinit var repository: CustomerRepository

    @RequestMapping("/save")
    fun save(): String {
        readCsv()
        return "Done"
    }

    fun readCsv() {
        CsvToBeanBuilder<Customer>(
            FileReader("/home/kuzya/Desktop/databaseDemo/src/main/resources/example.csv")
        )
            .withType(Customer::class.java)
            .build()
            .parse()
            .also {
                repository.saveAll(it)
            }
    }

    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

//    @RequestMapping("/кк/{id}")
//    fun findById(@PathVariable id: Long) = repository.findById(id)
//
//    @RequestMapping("findbylastname/{lastName}")
//    fun findByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)
}