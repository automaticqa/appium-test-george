package screens

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class WelcomeTourScreen(appiumDriver: AppiumDriver<*>) : BaseScreen(appiumDriver) {
    init {
        this.appiumDriver = appiumDriver
        PageFactory.initElements(appiumDriver, this)
    }

    @FindBy(id = "cz.csas.georgego:id/skip_tour_btn")
    lateinit var skipTourButton: WebElement

    @FindBy(id = "cz.csas.georgego:id/tour_big_headline")
    lateinit var tourBigHeadLine: WebElement

    @FindBy(id = "cz.csas.georgego:id/tour_sub_headline")
    lateinit var tourSubHeadLine: WebElement

    override fun isScreenDisplayed() {
        waitForElementToBeVisible(tourBigHeadLine)
        skipTourButton.isDisplayed
        tourSubHeadLine.isDisplayed
    }
}