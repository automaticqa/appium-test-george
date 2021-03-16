package tests

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import utils.ProjectCapabilities
import java.lang.Thread.sleep
import java.net.MalformedURLException

class AuthorizationTest : BaseTest() {

    @Before
    @Throws(MalformedURLException::class)
    fun setup() {
        driver = AndroidDriver(server, ProjectCapabilities.getAndroidBaseCapabilities())
    }

    @Test
    fun someTest() {
        sleep(50000)
        val oneNumberButton: MobileElement =
            driver.findElement(By.id("cz.csas.georgego:id/erste_locker_btn_pin_1")) as MobileElement

        oneNumberButton.click()
    }

    @After
    fun tearDown() {
        driver.quit()
    }
}