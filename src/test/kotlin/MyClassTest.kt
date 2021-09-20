import org.testng.Assert.assertEquals
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
        assertEquals(10, MyClass.myFun(5))
    }
}