package actions

import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidTouchAction
import org.openqa.selenium.Dimension
import java.time.Duration
import java.awt.Event.DOWN

import java.awt.Event.UP

import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.lang.IllegalArgumentException


fun swipeScreen(driver: AppiumDriver<*>, dir: Direction) {
    println("swipeScreen(): dir: '$dir'") // always log your actions

    // Animation default time:
    //  - Android: 300 ms
    // final value depends on your app and could be greater
    val ANIMATION_TIME = 200 // ms
    val PRESS_TIME = 200 // ms
    val edgeBorder = 10 // better avoid edges
    val pointOptionStart: PointOption<*>
    val pointOptionEnd: PointOption<*>

    // init screen variables
    val dims: Dimension = driver.manage().window().getSize()

    // init start point = center of screen
    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2)
    pointOptionEnd = when (dir) {
        Direction.DOWN -> PointOption.point(dims.width / 2, dims.height - edgeBorder)
        Direction.UP -> PointOption.point(dims.width / 2, edgeBorder)
        Direction.LEFT -> PointOption.point(edgeBorder, dims.height / 2)
        Direction.RIGHT -> PointOption.point(dims.width - edgeBorder, dims.height / 2)
        else -> throw IllegalArgumentException("swipeScreen(): dir: '$dir' NOT supported")
    }

    // execute swipe using TouchAction
    try {
        AppTouchAction(driver)
            .press(pointOptionStart) // a bit more reliable when we add small wait
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME.toLong())))
            .moveTo(pointOptionEnd)
            .release().perform()
    } catch (e: Exception) {
        System.err.println(
            """
                swipeScreen(): TouchAction FAILED
                ${e.message}
                """.trimIndent()
        )
        return
    }

    // always allow swipe action to complete
    try {
        Thread.sleep(ANIMATION_TIME.toLong())
    } catch (e: InterruptedException) {
        // ignore
    }
}