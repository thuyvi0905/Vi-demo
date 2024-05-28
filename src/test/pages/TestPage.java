package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
@Slf4j
public class TestPage extends BasePage {
    @FindBy(xpath = "//a[text()='puppy_and_kitten.jpg']")
    WebElement lnkdownload;

    @FindBy(xpath ="//input[@id='file-upload']")
    WebElement btnUpload;

    @FindBy(xpath ="//input[@id='file-submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    WebElement result;

    public TestPage(){
        PageFactory.initElements(driver,this);
    }

    public void performDownloadFile(String path) {
        clickToElement(lnkdownload);
        File f = new File(path);
        getCsa().assertTrue(f.exists());
        log.info(f.getName().toString());
        log.info("Download file success.");
    }

    public void performUploadFile(String path){
        File f = new File(path);
        sendTextToElement(btnUpload,f.getAbsolutePath());
        clickToElement(btnSubmit);
        getCsa().assertEquals(getText(result),"File Uploaded!");
        log.info(getText(result)+"File Upload success.");
    }
}
