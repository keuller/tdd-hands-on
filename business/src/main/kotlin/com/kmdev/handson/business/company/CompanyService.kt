package com.kmdev.handson.business.company

import com.kmdev.handson.common.fp.Result
import com.kmdev.handson.common.fp.Result.Fail
import com.kmdev.handson.common.fp.Result.OK
import com.kmdev.handson.common.util.convertStringToDate
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.util.*

class CompanyService(private val repository: CompanyRepository) {
    private val logger = LoggerFactory.getLogger(javaClass)

    private fun calculateScore(date: LocalDate): Char {
        val currentYear = LocalDate.now().year
        val years = currentYear - date.year

        if (years < 2) return '0'
        if (years in 2..3) return 'C'
        if (years in 4..5) return 'B'
        return 'A'
    }

    fun addCompany(data: AddCompanyRequest): Result<String> {
        val foundation = convertStringToDate(data.foundation)

        val score = calculateScore(foundation)
        if (score == '0') return Fail("This company is too much younger.")

        val entity = repository.fetchBySite(data.site)
        if (entity != null) return Fail("There is a company with this same site.")

        val company = CompanyEntity(UUID.randomUUID().toString(), data.name, data.site,
            data.email, data.description, foundation, score)

        return when(val result = repository.create(company)) {
            is OK -> OK("Company has been created.")
            is Fail -> Fail(result.cause)
        }
    }

}
