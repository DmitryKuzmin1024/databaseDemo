package com.example.databaseDemo.model

import com.example.databaseDemo.NoArgConstructor
import com.opencsv.bean.CsvBindAndJoinByPosition
import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvBindByPosition
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@NoArgConstructor
class Customer(
    @CsvBindByName(column = "year")
    val year: String,
    @CsvBindByName(column = "industry_code_ANZSIC")
    val industry_code_ANZSIC: String,
    @CsvBindByName(column = "industry_name_ANZSIC")
    val industry_name_ANZSIC: String,
    @CsvBindByName(column = "rme_size_grp")
    val rme_size_grp: String,
    @CsvBindByName(column = "variable")
    val variable: String,
    @CsvBindByName(column = "value")
    val value: String,
    @CsvBindByName(column = "unit")
    val unit: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {
}