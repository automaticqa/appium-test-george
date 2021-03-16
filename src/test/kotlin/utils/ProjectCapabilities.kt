package utils

import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
// TODO: refactor to Builder pattern
class ProjectCapabilities {
    companion object {
        fun getAndroidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("deviceName", "samsung-sm_n770f-RR8N105KP4F")
            caps.setCapability("platformName", "Android")
            caps.setCapability(CapabilityType.VERSION, "11")
            caps.setCapability("deviceOrientation", "portrait")
            caps.setCapability("automationName", "UiAutomator2")
            val file = File("/home/andadmin/ApksForAppium", "george-česká-spořitelna_21.02.13.apk")
            caps.setCapability("app", file.absolutePath)
            return caps
        }
    }
}