package com.example.databaseDemo.controller

import com.example.databaseDemo.CsvLogic
import com.example.databaseDemo.repo.DataBaseRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
class WebController(
    private val repository: DataBaseRepository,
    @Value("\${file.upload-dir}")
    private val fileDirectory: String
) {
    private val csvLogic = CsvLogic()

//    @PostMapping("/upload")
//    fun fileUpload(@RequestParam("File") file: MultipartFile): ResponseEntity<Any?>? {
//        val myFile = File(fileDirectory + file.originalFilename)
//        myFile.createNewFile()
//        csvLogic.saveCsvToDataBase(repository, myFile)
//        return ResponseEntity("CSV Uploaded Successfully ${file.size}", HttpStatus.OK)
//    }

    @PostMapping("/upload")
    fun fileUpload(@RequestParam("File") file: MultipartFile): String {
        csvLogic.saveCsvToDataBase(
            repository,
            File(fileDirectory + file.originalFilename)
        )
        return "CSV uploaded ${file.size}"
    }

    @GetMapping("/hello")
    fun sayHello() = "Hello there!"

    @GetMapping("/findall")
    fun findAll() = repository.findAll()

    @GetMapping("/findbyid")
    fun findById(@RequestParam("id") id: Long) = repository.findById(id)

    @GetMapping("/findbyvalue")
    fun findByValue(@RequestParam("value") value: String) = repository.findByValue(value)
}