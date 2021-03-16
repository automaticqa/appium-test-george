package screens.login

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import screens.BaseScreen

class LoginWithUserIdScreen(appiumDriver: AppiumDriver<*>) : BaseScreen(appiumDriver) {
    init {
        this.appiumDriver = appiumDriver
        PageFactory.initElements(appiumDriver, this)
    }

    val userIdEditText: WebElement by lazy {
        appiumDriver.findElement(By.id("cz.csas.georgego:id/et_name"))
    }

    val nextBtn: WebElement by lazy {
        appiumDriver.findElement(By.id("cz.csas.georgego:id/ll_button"))
    }

    val loginWithDemoUserBtn: WebElement by lazy {
        appiumDriver.findElement(By.id("cz.csas.georgego:id/btn_login_with_demo_user"))
    }

    override fun isScreenDisplayed() {
        userIdEditText.isDisplayed
        nextBtn.isDisplayed
        loginWithDemoUserBtn.isDisplayed
    }
}