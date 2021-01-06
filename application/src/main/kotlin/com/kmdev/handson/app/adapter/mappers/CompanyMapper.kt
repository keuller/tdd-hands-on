package com.kmdev.handson.app.adapter.mappers

import com.kmdev.handson.business.company.CompanyEntity
import com.kmdev.handson.common.util.convertStringToDateTime
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class CompanyMapper : ColumnMapper<CompanyEntity> {
    override fun map(rs: ResultSet?, col: Int, ctx: StatementContext?): CompanyEntity? {
        if (rs == null) return null
        val updated = rs.getString("UPDATED_AT")
        return CompanyEntity(
            id = rs.getString("ID"),
            name = rs.getString("NAME"),
            site = rs.getString("SITE"),
            email = rs.getString("EMAIL"),
            description = rs.getString("DESCRIPTION"),
            foundation = rs.getDate("FOUNDATION").toLocalDate(),
            score = rs.getString("SCORE").toCharArray()[0],
            createdAt = convertStringToDateTime(rs.getString("CREATED_AT")),
            updatedAt = if (updated != null) convertStringToDateTime(updated) else null
        )
    }
}
