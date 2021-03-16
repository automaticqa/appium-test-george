package tests

import actions.Direction
import actions.swipeScreen
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Test
import screens.WelcomeTourScreen
import screens.login.FirstLoginToGeorgeScreen
import screens.login.LoginDemoOrSmsScreen
import screens.login.LoginDemoScreen
import screens.login.LoginWithUserIdScreen
import java.net.MalformedURLException
import java.util.concurrent.TimeUnit

class AuthorizationTest : BaseTest() {

    @Before
    @Throws(MalformedURLException::class)
    fun setup() {
        desiredCapabilities.setCapability("fullReset", "true")
        appiumDriver = AndroidDriver(server, desiredCapabilities)
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        welcomeTourScreen = WelcomeTourScreen(appiumDriver)
        loginToGeorgeScreen = FirstLoginToGeorgeScreen(appiumDriver)
        loginDemoOrSmsScreen = LoginDemoOrSmsScreen(appiumDriver)
        loginDemoScreen = LoginDemoScreen(appiumDriver)
        loginWithUserIdScreen = LoginWithUserIdScreen(appiumDriver)
    }

    @Test
    fun `user should be able to open login via user id screen`() {
        welcomeTourScreen.isScreenDisplayed()
        welcomeTourScreen.skipTourButton.click()

        loginToGeorgeScreen.isScreenDisplayed()
        loginToGeorgeScreen.loginToGeorgeBtn.click()

        loginDemoOrSmsScreen.isScreenDisplayed()
        loginDemoOrSmsScreen.loginWithPassSmsBtn.click()

        loginWithUserIdScreen.isScreenDisplayed()
    }

    @Test
    fun `user should be able to skip welcome tour`() {
        welcomeTourScreen.isScreenDisplayed()
        welcomeTourScreen.skipTourButton.click()

        loginToGeorgeScreen.isScreenDisplayed()
        loginToGeorgeScreen.getGeorgeBtn.click()
    }

    @Test
    fun `user should be able to get back to welcome tour screen`() {
        val welcomeTourScreensQuantity = 4
        welcomeTourScreen.isScreenDisplayed()
        repeat(welcomeTourScreensQuantity) {
            swipeScreen(appiumDriver, Direction.LEFT)
        }

        loginToGeorgeScreen.isScreenDisplayed()
        swipeScreen(appiumDriver, Direction.RIGHT)
        welcomeTourScreen.isScreenDisplayed()
    }

    @After
    fun tearDown() {
        appiumDriver.quit()
    }
}