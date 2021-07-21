package com.example.databaseDemo.repo

import com.example.databaseDemo.model.DataBaseModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DataBaseRepository : CrudRepository<DataBaseModel, Long> {
    fun findByValue(value: String): MutableIterable<DataBaseModel>
}