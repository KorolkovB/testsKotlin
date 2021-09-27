import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Description
import io.qameta.allure.Step
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import mu.KLogging
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.testng.asserts.Assertion
import pages.GoogleStartPage
import java.util.logging.Level

class C12346 {
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
                .enableLogs(LogType.BROWSER, Level.ALL)
        )
    }

//    @Test(groups = [
//        "SmokeTest"
//    ])
//    @Description("Описание тестового метода testMyFun3")
//    fun testMyFun4() {
//        logger.info { "Открываем стартовую страницу" }
//        open("https://google.com/ncr")
//
//        GoogleStartPage.queryInput.value = "selenide"
//        GoogleStartPage.queryInput.pressEnter()
//
//        Assertion().assertTrue(GoogleStartPage.searchResults.size > 5)
//        GoogleStartPage.searchResults.shouldHave(sizeGreaterThan(5))
//        GoogleStartPage.searchResults[0].shouldHave(text("concise ui tests in Java2"))
//    }
}