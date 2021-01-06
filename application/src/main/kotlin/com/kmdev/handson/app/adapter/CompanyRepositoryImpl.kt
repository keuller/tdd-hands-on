package com.kmdev.handson.app.adapter

import com.kmdev.handson.app.adapter.mappers.CompanyMapper
import com.kmdev.handson.app.infra.Database
import com.kmdev.handson.app.infra.Database.getSql
import com.kmdev.handson.business.company.CompanyEntity
import com.kmdev.handson.business.company.CompanyRepository
import com.kmdev.handson.common.fp.Result.Fail
import com.kmdev.handson.common.fp.Result.OK
import com.kmdev.handson.common.fp.Result

class CompanyRepositoryImpl : CompanyRepository {

    override fun create(company: CompanyEntity): Result<String> = try {
        Database.runCommandInTransaction {
            it.createUpdate(getSql("db.create")).bindBean(company).execute()
        }
        OK("Success")
    } catch (ex: Exception) {
        Fail(ex.message ?: "Fail to insert a new company.")
    }

    override fun update(company: CompanyEntity): Result<Unit> = try {
        Database.runCommandInTransaction {
            it.createUpdate(getSql("db.update")).bindBean(company).execute()
        }
        OK(Unit)
    } catch(ex: Exception) {
        Fail(ex.message ?: "Fail to update company with ID ${company.id}")
    }

    override fun delete(id: String) {
        Database.runCommand {
            it.createUpdate(getSql("db.delete")).bind("id", id).execute()
        }
    }

    override fun fetchById(id: String): CompanyEntity? = Database.runCommand {
        it.select(getSql("db.fetchId"))
            .bind("id", id)
            .map(CompanyMapper())
            .firstOrNull()
    }

    override fun fetchBySite(value: String): CompanyEntity? = Database.runCommand {
        it.select(getSql("db.fetchBySite")).bind("site", value)
            .map(CompanyMapper())
            .firstOrNull()
    }

    override fun fetchAll(): List<CompanyEntity> = Database.runCommand {
        it.select(getSql("db.fetchAll")).map(CompanyMapper()).list()
    }

}
