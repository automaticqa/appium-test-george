package tests

import actions.Direction
import actions.swipeScreen
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Test
import screens.welcome.WelcomeTourScreen
import utils.ProjectCapabilities
import java.lang.Thread.sleep
import java.net.MalformedURLException

class AuthorizationTest : BaseTest() {

    lateinit var welcomeTourScreen : WelcomeTourScreen

    @Before
    @Throws(MalformedURLException::class)
    fun setup() {
        appiumDriver = AndroidDriver(server, ProjectCapabilities.getAndroidBaseCapabilities())
        welcomeTourScreen = WelcomeTourScreen(appiumDriver)
    }

    @Test
    fun someTest() {
        sleep(7000)
        swipeScreen(appiumDriver, Direction.LEFT)
        sleep(1000)
        swipeScreen(appiumDriver, Direction.RIGHT)
    }

    @After
    fun tearDown() {
        appiumDriver.quit()
    }
}