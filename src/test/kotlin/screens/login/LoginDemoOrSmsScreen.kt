package screens.login

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import screens.BaseScreen

class LoginDemoOrSmsScreen(appiumDriver: AppiumDriver<*>) : BaseScreen(appiumDriver) {
    init {
        this.appiumDriver = appiumDriver
        PageFactory.initElements(appiumDriver, this)
    }

    @FindBy(id = "cz.csas.georgego:id/tv_application_label")
    lateinit var appLabel: WebElement

    @FindBy(id = "cz.csas.georgego:id/ll_button")
    lateinit var llBtn: WebElement

    @FindBy(id = "cz.csas.georgego:id/btn_login_with_pass")
    lateinit var loginWithPassSmsBtn: WebElement

    @FindBy(id = "cz.csas.georgego:id/btn_login_with_demo_user")
    lateinit var loginWithDemoBtn: WebElement

    override fun isScreenDisplayed() {
        waitForElementToBeVisible(appLabel)
        llBtn.isDisplayed
        loginWithPassSmsBtn.isDisplayed
        loginWithDemoBtn.isDisplayed
    }
}