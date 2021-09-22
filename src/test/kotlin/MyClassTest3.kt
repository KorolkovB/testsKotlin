import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test


class MyClassTest3 {

    @BeforeClass
    fun setUp() {
        SelenideLogger.addListener("AllureSelenide", AllureSelenide().screenshots(true).savePageSource(true))
        Configuration.startMaximized = true
    }

    @Test
    fun testMyFun5() {
        println(Thread.currentThread().id)
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }

    @Test
    fun testMyFun6() {
        println(Thread.currentThread().id)
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }
}