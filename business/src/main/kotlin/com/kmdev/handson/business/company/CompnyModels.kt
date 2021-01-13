package com.kmdev.handson.business.company

data class AddCompanyRequest(
    val name: String,
    val site: String,
    val email: String? = "",
    val description: String? = "",
    val foundation: String,
)
