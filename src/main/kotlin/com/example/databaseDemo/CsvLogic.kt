package com.example.databaseDemo

import com.example.databaseDemo.model.DataBaseModel
import com.example.databaseDemo.model.CsvModel
import com.example.databaseDemo.repo.DataBaseRepository
import com.opencsv.bean.CsvToBeanBuilder
import java.io.File
import java.io.FileReader

class CsvLogic {
    private fun readCsv(file: File): MutableList<CsvModel> {
        return CsvToBeanBuilder<CsvModel>(
            FileReader(file)
        )
            .withType(CsvModel::class.java)
            .build()
            .parse()
    }

    private fun parseCsvToDataBase(csv: MutableList<CsvModel>): MutableList<DataBaseModel> {
        return csv.map {
            DataBaseModel(
                it.year,
                it.industry_code_ANZSIC,
                it.industry_name_ANZSIC,
                it.rme_size_grp,
                it.variable,
                it.value,
                it.unit
            )
        }.toMutableList()
    }

    fun saveCsvToDataBase(repository: DataBaseRepository, file: File) {
        repository.saveAll(parseCsvToDataBase(readCsv(file)))
    }
}