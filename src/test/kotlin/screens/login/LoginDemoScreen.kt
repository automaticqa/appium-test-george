package screens.login

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import screens.BaseScreen

class LoginDemoScreen(appiumDriver: AppiumDriver<*>) : BaseScreen(appiumDriver) {
    init {
        this.appiumDriver = appiumDriver
        PageFactory.initElements(appiumDriver, this)
    }

    @FindBy(xpath = "cz.csas.georgego:id/erste_locker_vw_web_view")
    lateinit var webView: WebElement

    override fun isScreenDisplayed() {
        waitForElementToBeVisible(webView)
    }
}