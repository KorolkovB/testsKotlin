package ui

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Description
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.TmsLink
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import mu.KLogging
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.testng.asserts.Assertion
import pages.GoogleStartPage.searchResults
import steps.searchQueryResult
import java.util.logging.Level

class C12345 {
    companion object : KLogging()

    @BeforeClass
    fun setUpMethod() {
        SelenideLogger.addListener(
            "AllureSelenide",
            AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL)
                .enableLogs(LogType.CLIENT, Level.ALL)
                .enableLogs(LogType.DRIVER, Level.ALL)
                .enableLogs(LogType.PERFORMANCE, Level.ALL)
                .enableLogs(LogType.PROFILER, Level.ALL)
                .enableLogs(LogType.SERVER, Level.ALL)
        )
    }

//    @BeforeMethod
//    fun setUpMethod() {
//        WebDriverManager.chromedriver().setup()
//        val myWebDriver = ChromeDriver()
//        WebDriverRunner.setWebDriver(myWebDriver)
//        myWebDriver.manage().window().maximize()
//    }
//
//    @AfterMethod
//    fun tearDownMethod() {
//        WebDriverRunner.getWebDriver().quit()
//    }

    @Test(description = "Название тестового метода")
    @Description("Подробное описание тестовго метода")
    @TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
    @Severity(SeverityLevel.CRITICAL)
    fun testMyFun() {
        logger.info { "Открываем стартовую страницу" }

        searchQueryResult("selenide")

        Assertion().assertTrue(searchResults.size > 5)
        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java1"))
    }

    @Test(description = "Название тестового метода")
    @Description("Подробное описание тестовго метода")
    @TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
    @Severity(SeverityLevel.BLOCKER)
    fun testMyFun2() {
        logger.info { "Открываем стартовую страницу" }
        searchQueryResult("selenide")

        Assertion().assertTrue(searchResults.size > 5)
        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java"))
    }
}