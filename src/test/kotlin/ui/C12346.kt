package ui

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.TmsLink
import org.testng.annotations.Test
import pages.GoogleStartPage.searchResults
import ui.steps.searchQueryResult

@Severity(SeverityLevel.MINOR)
@TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
class C12346 : BaseUiTest() {
    private val STRING_FOR_SEARCH = "selenide"

    @Test(description = "Поиск искомого значения в Google")
    fun searchingForQueryResults() {
        searchQueryResult(STRING_FOR_SEARCH)

        searchResults.shouldHave(sizeGreaterThan(5))
        searchResults[0].shouldHave(text("concise ui tests in Java"))
    }
}