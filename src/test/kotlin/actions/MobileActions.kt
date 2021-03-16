package actions

import io.appium.java_client.AppiumDriver
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.Dimension
import java.time.Duration

fun swipeScreen(driver: AppiumDriver<*>, dir: Direction) {
    val animationTimeMs = 200
    val pressTimeMs = 200
    val edgeBorder = 10
    val pointOptionStart: PointOption<*>
    val pointOptionEnd: PointOption<*>
    val dims: Dimension = driver.manage().window().size

    println("swipeScreen(): dir: '$dir'")

    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2)
    pointOptionEnd = when (dir) {
        Direction.DOWN -> PointOption.point(dims.width / 2, dims.height - edgeBorder)
        Direction.UP -> PointOption.point(dims.width / 2, edgeBorder)
        Direction.LEFT -> PointOption.point(edgeBorder, dims.height / 2)
        Direction.RIGHT -> PointOption.point(dims.width - edgeBorder, dims.height / 2)
    }

    runCatching {
        AppTouchAction(driver)
            .press(pointOptionStart)
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(pressTimeMs.toLong())))
            .moveTo(pointOptionEnd)
            .release().perform()
    }.onFailure {
        System.err.println(
            """
                swipeScreen(): TouchAction FAILED
                ${it.message}
                """.trimIndent()
        )
        return
    }

    runCatching { Thread.sleep(animationTimeMs.toLong()) }
}