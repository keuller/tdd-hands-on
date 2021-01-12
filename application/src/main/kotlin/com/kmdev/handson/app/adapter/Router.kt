package com.kmdev.handson.app

import com.kmdev.handson.app.adapter.*
import com.kmdev.handson.common.http.CustomViewModel
import org.http4k.core.*
import org.http4k.core.Method.GET
import org.http4k.core.Method.PUT
import org.http4k.core.Method.POST
import org.http4k.core.Method.DELETE
import org.http4k.routing.*
import org.http4k.template.HandlebarsTemplates
import org.http4k.template.viewModel

data class IndexPage(val title: String) : CustomViewModel

class Router {
    // static assets HTML, CSS, images, etc
    private val assetsHandler = static(ResourceLoader.Directory("public/assets"))

    // template handler
    private fun index(): HttpHandler {
        val renderer = HandlebarsTemplates().HotReload("public/views")
        val indexContent = Body.viewModel(renderer, ContentType.TEXT_HTML).toLens()
        return {
            indexContent(IndexPage("TDD Hands On"), Response(Status.OK))
        }
    }

    // creates application routes
    fun routes(): RoutingHttpHandler = routes(
        "/" bind GET to index(),
        "/assets"  bind GET to assetsHandler,
        "/companies" bind routes(
            "/"     bind GET to listCompanies(),
            "/{id}" bind GET to findCompanyById(),
            "/{id}" bind PUT to updateCompany(),
            "/"     bind POST to createCompany(),
            "/{id}" bind DELETE to removeCompany()
        )
    )

}
