package com.kmdev.handson.common.http

import org.http4k.template.ViewModel

interface CustomViewModel : ViewModel {
    /**
     * Gets file name and last package as directory ex. com.kmdev.http4k.app.IndexPage -> app/IndexPage.hbs
     */
    override fun template(): String {
        val values = javaClass.name.split(".")
        return "${values[values.size - 2]}/${values[values.size - 1]}"
    }
}
