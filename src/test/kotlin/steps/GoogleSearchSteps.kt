package steps

import com.codeborne.selenide.Selenide.open
import pages.GoogleStartPage

const val GOOGLE_SEARCH_PAGE = "https://google.com/ncr"

fun searchQueryResult(searchString: String) {
    open(GOOGLE_SEARCH_PAGE)

    GoogleStartPage.apply {
        queryInput.value = searchString
        queryInput.pressEnter()
    }

}

