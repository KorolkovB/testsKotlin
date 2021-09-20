import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.*
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class MyClassTest {

    @BeforeMethod
    fun setUp() {
        println("Test started")
    }

    @AfterMethod
    fun tearDown() {
        println("Test finished")
    }

    @Test
    fun testMyFun() {
        open("https://google.com/ncr")
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
        element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }
}