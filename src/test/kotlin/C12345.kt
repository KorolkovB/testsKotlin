import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.WebDriverRunner.driver
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.*
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import mu.KLogging
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.testng.asserts.Assertion
import pages.GoogleStartPage.searchResults
import steps.searchQueryResult
import java.util.*
import java.util.logging.Level


class C12345 {
    companion object : KLogging()

    @BeforeMethod
    fun setUpMethod() {
        SelenideLogger.addListener(
            "AllureSelenide",
            AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.CLIENT, Level.ALL)
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

        val logEntries: LogEntries = driver().webDriver.manage().logs().get(LogType.BROWSER.toString())
        val logs = StringBuilder()
        for (entry: LogEntry in logEntries) {
            logs.append(
                Date(entry.timestamp).toString() + " "
                        + entry.level + " " + entry.message
            )
            logs.append(System.lineSeparator())
        }
        Allure.addAttachment("Console log: ", logs.toString())

        Assertion().assertTrue(searchResults.size > 5)
        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java"))
    }

//    @Test(groups = ["smoke"])
//    @Description("Описание тестового метода testMyFun2")
//    fun testMyFun2() {
//        logger.info { "Открываем стартовую страницу" }
//        open("https://google.com/ncr")
//
//        queryInput.value = "selenide"
//        queryInput.pressEnter()
//
//        Assertion().assertTrue(searchResults.size > 5)
//        searchResults.shouldHave(sizeGreaterThan(5))
//        searchResults[0].shouldHave(text("concise ui tests in Java"))
//    }
}