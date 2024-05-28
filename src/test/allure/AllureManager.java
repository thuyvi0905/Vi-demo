package allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scripts.BaseTest;

public class AllureManager {
    public static byte[] captureImage(){
        return ((TakesScreenshot) BaseTest.driverThread.get()).getScreenshotAs(OutputType.BYTES);
    }
}
