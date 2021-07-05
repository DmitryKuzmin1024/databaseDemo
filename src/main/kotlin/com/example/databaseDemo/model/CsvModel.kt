package com.example.databaseDemo.model

import com.example.databaseDemo.NoArgConstructor
import com.opencsv.bean.CsvBindByName

@NoArgConstructor
data class CsvModel(
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
)