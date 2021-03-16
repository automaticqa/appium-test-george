package utils

import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File

class ProjectCapabilities {
    companion object {
        fun getAndroidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("automationName", "UiAutomator2")
            caps.setCapability("deviceName", "samsung-sm_n770f-RR8N105KP4F")
            caps.setCapability("noReset", "true")
            caps.setCapability("appPackage", "cz.csas.georgego")
            caps.setCapability("appActivity", "at.beeone.george.SplashScreenActivity")
            caps.setCapability("appWaitPackage", "cz.csas.georgego")
            val file = File("/home/andadmin/ApksForAppium", "george-česká-spořitelna_21.02.13.apk")
            caps.setCapability("app", file.absolutePath)
            return caps
        }
    }
}