package screens

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

abstract class BaseScreen(var appiumDriver: AppiumDriver<*>) {
    private val wait = WebDriverWait(appiumDriver, 30)

    abstract fun isScreenDisplayed()

    fun waitForElementToBeVisible(element: WebElement): WebElement =
        wait.until(ExpectedConditions.visibilityOf(element))
}