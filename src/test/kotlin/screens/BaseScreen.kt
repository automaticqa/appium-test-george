package screens

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class BaseScreen(driver: AppiumDriver<*>) {
    private val wait: WebDriverWait = WebDriverWait(driver, 30)

    fun waitForElementToBeVisible(element: WebElement?) =
        wait.until(ExpectedConditions.visibilityOf(element))
}

