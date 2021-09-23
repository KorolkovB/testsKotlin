package pages

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import org.openqa.selenium.By

object GoogleStartPage {
    val queryInput = element(By.name("q"))
    val searchResults = elements(By.cssSelector("#res .g"))
}