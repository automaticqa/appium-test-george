package tests

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import screens.FirstLoginToGeorgeScreen
import screens.LoginDemoOrSmsScreen
import screens.welcome.WelcomeTourScreen
import java.net.URL

open class BaseTest {
    lateinit var appiumDriver: AppiumDriver<MobileElement>

    // Here are supposed to be declared all App screens
    lateinit var welcomeTourScreen : WelcomeTourScreen
    lateinit var loginToGeorgeScreen : FirstLoginToGeorgeScreen
    lateinit var loginDemoOrSmsScreen: LoginDemoOrSmsScreen

    val server: URL = URL("http://localhost:4723/wd/hub")
}