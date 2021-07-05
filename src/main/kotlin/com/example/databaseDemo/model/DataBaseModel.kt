package com.example.databaseDemo.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class DataBaseModel(
    val year: String,
    val industry_code_ANZSIC: String,
    val industry_name_ANZSIC: String,
    val rme_size_grp: String,
    val variable: String,
    val value: String,
    val unit: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
)