package screens.welcome

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import screens.BaseScreen

class WelcomeTourScreen(appiumDriver: AppiumDriver<*>) : BaseScreen(appiumDriver) {
    init {
        PageFactory.initElements(appiumDriver, this)
    }

    @FindBy(id = "cz.csas.georgego:id/guided_tour_fragment")
    lateinit var guidedTourFragment : WebElement

    @FindBy(id = "cz.csas.georgego:id/tour_big_headline")
    lateinit var tourBigHeadline : WebElement
}