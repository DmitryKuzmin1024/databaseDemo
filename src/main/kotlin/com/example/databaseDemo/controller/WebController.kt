package com.example.databaseDemo.controller

import com.example.databaseDemo.CsvLogic
import com.example.databaseDemo.repo.DataBaseRepository
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
class WebController(
    private val repository: DataBaseRepository
) {
    private val csvLogic = CsvLogic()

    @RequestMapping("/save")
    fun save(): String {
        csvLogic.saveCsvToDataBase(repository)
        return "Done"
    }

    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

    @RequestMapping("/findbyid/{id}")
    fun findById(@PathVariable id: Long) = repository.findById(id)

    @RequestMapping("findbyvalue/{value}")
    fun findByValue(@PathVariable value: String) = repository.findByValue(value)
}