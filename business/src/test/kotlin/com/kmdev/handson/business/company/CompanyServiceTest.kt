package com.kmdev.handson.business.company

import com.kmdev.handson.common.fp.Result
import com.kmdev.handson.common.fp.Result.OK
import com.kmdev.handson.common.fp.Result.Fail
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

class CompanyServiceTest {
    private val mockRepository = mockk<CompanyRepository>(relaxed = true)

    @Test
    @DisplayName("Cadastrar uma empresa com até 3 anos")
    fun testScenario1() {
        val service = CompanyService(mockRepository)
        val site = "https://www.acmeinc.com"

        val data = AddCompanyRequest(
            name = "Acme Inc",
            site = site,
            email = "test@acmeinc.com",
            foundation = "2018-08-05"
        )

        every { mockRepository.fetchBySite(site) } returns null
        every { mockRepository.create(any()) } returns OK(Unit)

        val result = service.addCompany(data)

        result.shouldBeInstanceOf<OK<String>>()
        result.value shouldBe "Company has been created."
    }

    @Test
    @DisplayName("Cadastrar uma empresa com até 5 anos")
    fun testScenario2() {
        val service = CompanyService(mockRepository)
        val site = "https://www.acmeinc.com"

        val data = AddCompanyRequest(
            name = "Acme Inc",
            site = site,
            email = "test@acmeinc.com",
            foundation = "2016-08-05"
        )

        every { mockRepository.fetchBySite(site) } returns null
        every { mockRepository.create(any()) } returns OK(Unit)

        val result = service.addCompany(data)

        result.shouldBeInstanceOf<OK<String>>()
        result.value shouldBe "Company has been created."
    }

    @Test
    @DisplayName("Cadastrar uma empresa acima de 5 anos")
    fun testScenario3() {
        val service = CompanyService(mockRepository)
        val site = "https://www.acmeinc.com"

        val data = AddCompanyRequest(
            name = "Acme Inc",
            site = site,
            email = "test@acmeinc.com",
            foundation = "2015-08-05"
        )

        every { mockRepository.fetchBySite(site) } returns null
        every { mockRepository.create(any()) } returns OK(Unit)

        val result = service.addCompany(data)

        result.shouldBeInstanceOf<OK<String>>()
        result.value shouldBe "Company has been created."
    }

    @Test
    @DisplayName("Tentar cadastrar uma empresa com menos de 2 anos")
    fun testScenario4() {
        val service = CompanyService(mockRepository)
        val site = "https://www.acmeinc.com"

        val data = AddCompanyRequest(
            name = "Acme Inc",
            site = site,
            email = "test@acmeinc.com",
            foundation = "2020-08-05"
        )

        val result = service.addCompany(data)

        result.shouldBeInstanceOf<Result.Fail<String>>()
        result.cause shouldBe "This company is too much younger."
    }

    @Test
    @DisplayName("Tentar cadastrar uma empresa com site ja existente.")
    fun testScenario5() {
        val mockEntity = CompanyEntity("8e863ea3", "Acme Inc", "www.acmeinc.com", "acme@inc.com", "Lorem ipsum dolores", LocalDate.now(), '0')
        val service = CompanyService(mockRepository)
        val site = "www.acme.inc"

        every { mockRepository.fetchBySite(site) } returns mockEntity

        val company = AddCompanyRequest("Acme Inc", "acme@inc.com", site, "Lorem ipsum dolores", "2018-01-20")
        val message = service.addCompany(company)

        message.shouldBeInstanceOf<Fail<String>>()
        message.cause shouldBe "There is a company with this same site."
    }

}
