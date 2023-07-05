package config;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import util.WorkWithLogs;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    static public WebDriver driver;
    @BeforeClass
    public static void BeforeParent(){
        driver = ConfigurationWebDriver.createDriver(WebDrivers.PROXYCHROME);
        ConfigurationWebDriver.server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,CaptureType.RESPONSE_CONTENT);
        ConfigurationWebDriver.server.newHar("hh");
        AgentFactory.create(Agents.UkraineLang);

        // static public WebDriver driver = ConfigurationWebDriver.createDriver(WebDrivers.CHROME);
    }
    @AfterClass
    public static void AfterParent() throws InterruptedException, IOException {
        WorkWithLogs.writeLogs(driver,"logs");
        Har har=ConfigurationWebDriver.server.getHar();
        for (HarEntry l:har.getLog().getEntries()){
            System.out.println(l.getRequest().getUrl());
        }
        har.writeTo(new File("Google.har"));
        Thread.sleep(1000);
        driver.quit();
    }

}
