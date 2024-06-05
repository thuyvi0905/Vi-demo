package scripts.testset;

import org.testng.annotations.Test;
import pages.TestPage;
import scripts.BaseTest;

public class TestTest extends BaseTest {
    @Test(groups = "smoke")
    public void TestTest() {
        new TestPage().performDownloadFile("src/resources/download");
        new TestPage().performUploadFile("src/resources/upload/imag12e.png");
        new TestPage().performUploadFile("aaaa1");
        new TestPage().performUploadFile("bbb1");
        new TestPage().performUploadFile("ccc1");
        new TestPage().performUploadFile("dddd");
        new TestPage().performUploadFile("eeeeee");
    }
}
