package ui

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeSuite

open class BaseUiTest {
    @BeforeSuite
    fun setUpSuite() {
        Configuration.startMaximized = true
        Configuration.timeout = 5000
    }

    @BeforeClass
    fun setUpClass() {
        SelenideLogger.addListener(
            "AllureSelenide",
            AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true)
        )
    }
}