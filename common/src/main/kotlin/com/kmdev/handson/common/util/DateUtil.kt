package com.kmdev.handson.common.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder

internal val DATE_FORMATTER = DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd").toFormatter()
internal val DATE_TIME_FORMATTER = DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd HH:mm:ss").toFormatter()

fun convertStringToDate(value: String): LocalDate = try {
    LocalDate.parse(value, DATE_FORMATTER)
} catch(ex: Exception) {
    LocalDate.now()
}

fun convertStringToDateTime(value: String): LocalDateTime = try {
    LocalDateTime.parse(value, DATE_TIME_FORMATTER)
} catch(ex: Exception) {
    LocalDateTime.now()
}

fun convertDateToString(value: LocalDate): String = try {
    value.format(DATE_FORMATTER)
} catch(ex: Exception) {
    ""
}
