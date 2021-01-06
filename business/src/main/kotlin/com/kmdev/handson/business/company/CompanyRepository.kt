package com.kmdev.handson.business.company

import com.kmdev.handson.common.fp.Result

interface CompanyRepository {

    fun create(company: CompanyEntity): Result<String>

    fun update(company: CompanyEntity): Result<Unit>

    fun delete(id: String)

    fun fetchAll(): List<CompanyEntity>

    fun fetchById(id: String): CompanyEntity?

    fun fetchBySite(value: String): CompanyEntity?

}
