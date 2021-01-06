package com.kmdev.handson.business.company

import com.kmdev.handson.common.fp.Result
import com.kmdev.handson.common.fp.Result.Fail
import com.kmdev.handson.common.fp.Result.OK
import com.kmdev.handson.common.util.convertDateToString
import com.kmdev.handson.common.util.convertStringToDate
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.util.*

class CompanyService(private val repository: CompanyRepository) {
    private val logger = LoggerFactory.getLogger(javaClass)

}
