import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.logevents.SelenideLogger
import io.github.bonigarcia.wdm.WebDriverManager
import io.qameta.allure.selenide.AllureSelenide
import org.openqa.selenium.By
import org.openqa.selenium.edge.EdgeDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class MyClassTest2 {

    @BeforeClass
    fun setUp() {
        SelenideLogger.addListener("AllureSelenide", AllureSelenide().screenshots(true).savePageSource(true))
    }

    @BeforeMethod
    fun setUpMethod() {
        WebDriverManager.edgedriver().setup()
        val myWebDriver = EdgeDriver()
        WebDriverRunner.setWebDriver(myWebDriver)
        myWebDriver.manage().window().maximize()
    }

    @AfterMethod
    fun tearDownMethod() {
        WebDriverRunner.getWebDriver().quit()
    }

    @Test
    fun testMyFun3() {
        println(Thread.currentThread().id)
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }

    @Test
    fun testMyFun4() {
        println(Thread.currentThread().id)
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }
}