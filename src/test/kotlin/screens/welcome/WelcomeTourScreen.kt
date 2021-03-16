package screens.welcome

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.support.PageFactory

class WelcomeTourScreen(appiumDriver: AppiumDriver<*>) : BaseWelcomeTourScreen(appiumDriver) {
    init {
        this.appiumDriver = appiumDriver
        PageFactory.initElements(appiumDriver, this)
    }

    override fun isScreenDisplayed() {
        waitForElementToBeVisible(skipTourButton)
    }
}