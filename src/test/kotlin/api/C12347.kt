package api

import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.TmsLink
import io.restassured.RestAssured.get
import org.hamcrest.Matchers.equalTo
import org.testng.annotations.Test

@Severity(SeverityLevel.MINOR)
@TmsLink("https://testrail.app.local/testrail/index.php?/auth/login/")
class C12347 {

    @Test(description = "Тестирование API")
    fun apiTest() {
        get("https://reqres.in/api/users?page=2").then().body("page", equalTo(3));

    }
}