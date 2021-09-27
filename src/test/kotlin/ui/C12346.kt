package ui

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.*
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import mu.KLogging
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.testng.asserts.Assertion
import pages.GoogleStartPage
import steps.searchQueryResult
import java.util.logging.Level

class C12346 {
    companion object : KLogging()

    @BeforeClass
    @Description("Описание тестового метода setUpMethod")
    fun setUpMethod() {
        SelenideLogger.addListener(
            "AllureSelenide",
            AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL)
        )
    }

    @Test(description = "Название тестового метода")
    @Description("Подробное описание тестовго метода")
    @TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
    @Severity(SeverityLevel.MINOR)
    fun testMyFun3() {
        logger.info { "Открываем стартовую страницу" }
        searchQueryResult("selenide")

        Assertion().assertTrue(GoogleStartPage.searchResults.size > 5)
        GoogleStartPage.searchResults.shouldHave(sizeGreaterThan(5))
        GoogleStartPage.searchResults[0].shouldHave(text("concise ui tests in Java"))
    }

    @Test(description = "Название тестового метода")
    @Description("Подробное описание тестовго метода")
    @TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
    @Severity(SeverityLevel.MINOR)
    fun testMyFun4() {
        logger.info { "Открываем стартовую страницу" }
        searchQueryResult("selenide")

        Assertion().assertTrue(GoogleStartPage.searchResults.size > 5)
        GoogleStartPage.searchResults.shouldHave(sizeGreaterThan(5))
        GoogleStartPage.searchResults[0].shouldHave(text("concise ui tests in Java1"))
    }
}