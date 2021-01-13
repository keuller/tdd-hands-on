package com.kmdev.handson.business.company

import java.time.LocalDate
import java.time.LocalDateTime

data class CompanyEntity(
    val id: String,
    val name: String,
    val site: String,
    val email: String?,
    val description: String?,
    val foundation: LocalDate,
    val score: Char,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)
