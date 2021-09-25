import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Description
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import mu.KLogging
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.testng.asserts.Assertion
import pages.GoogleStartPage.queryInput
import pages.GoogleStartPage.searchResults
import steps.searchQueryResult
import java.util.logging.Level


class MyClassTest {
    companion object : KLogging()

    @BeforeMethod
    @Description("Описание тестового метода setUpMethod")
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

    @Test
    @Description("Описание тестового метода testMyFun")
    fun testMyFun() {
        logger.info { "Открываем стартовую страницу" }

        searchQueryResult("selenide")

        Assertion().assertTrue(searchResults.size > 5)
        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java"))
    }

    @Test
    @Description("Описание тестового метода testMyFun2")
    fun testMyFun2() {
        logger.info { "Открываем стартовую страницу" }
        open("https://google.com/ncr")

        queryInput.value = "selenide"
        queryInput.pressEnter()

        Assertion().assertTrue(searchResults.size > 5)
        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java2"))
    }
}