package tests

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import java.net.URL

open class BaseTest {
    lateinit var driver: AppiumDriver<MobileElement>
    val server: URL = URL("http://localhost:4723/wd/hub")
}