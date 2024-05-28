package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.YamlUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static ThreadLocal<WebDriver> driverThread = ThreadLocal.withInitial(() -> null);
    public static Map environment;
    public static ChromeOptions chromeOptions;
    public final String downloadFilePath = "src/resources/download";
    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "environment"})
    public void beforeClass(@Optional("chrome") String browser, @Optional("uat") String envi) {
        environment = YamlUtils.getConfig("src/resources/env-" + envi + ".yaml");
        switch (browser) {
            case "chrome":
//                chromeOptions = new ChromeOptions();
//                chromeOptions.setCapability("download.default_directory", downloadFilePath);
                driverThread.set(new ChromeDriver());
                break;
            case "firefox":
                driverThread.set(new FirefoxDriver());
                break;
            default:
                System.out.println("Unknown browser");
        }
        driverThread.get().manage().window().maximize();
        driverThread.get().get(environment.get("url").toString());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }

}
