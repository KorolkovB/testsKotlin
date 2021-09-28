package setups.ui

import com.codeborne.selenide.Configuration
import io.qameta.allure.Description
import org.testng.annotations.BeforeSuite

class BeforeSuiteSetups {
    @BeforeSuite
    @Description("Описание тестового метода setUpSuite")
    fun setUpSuite() {
        Configuration.startMaximized = true
        Configuration.timeout = 5000
    }
}