import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test


class MyClassTest2 {

    @BeforeMethod
    fun setUp() {
        println("Test started")
        SelenideLogger.addListener("AllureSelenide", AllureSelenide().screenshots(true).savePageSource(true))
    }

    @AfterMethod
    fun tearDown() {
        println("Test finished")
    }

    @Test
    fun testMyFun() {
        Configuration.startMaximized = true
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }
}