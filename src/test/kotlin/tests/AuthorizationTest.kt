package tests

import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Test
import screens.FirstLoginToGeorgeScreen
import screens.LoginDemoOrSmsScreen
import screens.welcome.WelcomeTourScreen
import utils.ProjectCapabilities
import java.lang.Thread.sleep
import java.net.MalformedURLException
import java.util.concurrent.TimeUnit

class AuthorizationTest : BaseTest() {

    @Before
    @Throws(MalformedURLException::class)
    fun setup() {
        appiumDriver = AndroidDriver(server, ProjectCapabilities.getAndroidBaseCapabilities())
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        welcomeTourScreen = WelcomeTourScreen(appiumDriver)
        loginToGeorgeScreen = FirstLoginToGeorgeScreen(appiumDriver)
        loginDemoOrSmsScreen = LoginDemoOrSmsScreen(appiumDriver)
    }

    @Test
    fun someTest() {
        welcomeTourScreen.isScreenDisplayed()
        welcomeTourScreen.skipTourButton.click()

        loginToGeorgeScreen.isScreenDisplayed()
        loginToGeorgeScreen.tourLoginBtn.click()

        loginDemoOrSmsScreen.isScreenDisplayed()
        loginDemoOrSmsScreen.loginWithDemoBtn.click()
        sleep(5000)
    }

    @After
    fun tearDown() {
        appiumDriver.quit()
    }
}