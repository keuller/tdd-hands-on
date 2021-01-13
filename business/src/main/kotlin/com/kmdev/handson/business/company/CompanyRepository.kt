package com.kmdev.handson.business.company

import com.kmdev.handson.common.fp.Result

interface CompanyRepository {

    fun create(bean: CompanyEntity): Result<Unit>

    fun fetchBySite(value: String): CompanyEntity?

}
