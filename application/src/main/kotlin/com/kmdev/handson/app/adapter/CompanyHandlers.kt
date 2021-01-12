package com.kmdev.handson.app.adapter

import org.http4k.core.HttpHandler
import org.http4k.core.Response
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.lens.Path
import org.http4k.lens.string

internal val idParam = Path.string().of("id")

fun findCompanyById(): HttpHandler = { request ->
    val id = idParam(request)
    Response(NOT_FOUND).body("No company found.")
}

fun listCompanies(): HttpHandler = {
    Response(NOT_FOUND).body("No companies found.")
}

fun createCompany(): HttpHandler = { request ->
    Response(BAD_REQUEST).body("Operation not implemented yet.")
}

fun updateCompany(): HttpHandler = { request ->
    Response(BAD_REQUEST).body("Operation not implemented yet.")
}

fun removeCompany(): HttpHandler = { request ->
    Response(BAD_REQUEST).body("Operation not implemented yet.")
}
