package ui

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.TmsLink
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import pages.GoogleStartPage.searchResults
import steps.searchQueryResult
import java.util.logging.Level

@Severity(SeverityLevel.MINOR)
@TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
class C12346 {
    private val STRING_FOR_SEARCH = "selenide"

    @BeforeClass
    fun setUpClass() {
        SelenideLogger.addListener(
            "AllureSelenide",
            AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.INFO)
        )
    }

    @Test(description = "Поиск искомого значения в Google")
    fun searchingForQueryResults() {
        searchQueryResult(STRING_FOR_SEARCH)

        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java"))
    }
}