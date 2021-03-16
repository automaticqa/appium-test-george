package tests

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.remote.DesiredCapabilities
import screens.login.FirstLoginToGeorgeScreen
import screens.login.LoginDemoOrSmsScreen
import screens.login.LoginDemoScreen
import screens.login.LoginWithUserIdScreen
import screens.welcome.WelcomeTourScreen
import utils.ProjectCapabilities
import java.net.URL

open class BaseTest {
    lateinit var appiumDriver: AppiumDriver<MobileElement>
    var desiredCapabilities: DesiredCapabilities = ProjectCapabilities.getAndroidBaseCapabilities()

    // All app screens are supposed to be declared here
    lateinit var welcomeTourScreen: WelcomeTourScreen
    lateinit var loginToGeorgeScreen: FirstLoginToGeorgeScreen
    lateinit var loginDemoOrSmsScreen: LoginDemoOrSmsScreen
    lateinit var loginDemoScreen: LoginDemoScreen
    lateinit var loginWithUserIdScreen: LoginWithUserIdScreen

    val server: URL = URL("http://localhost:4723/wd/hub")
}