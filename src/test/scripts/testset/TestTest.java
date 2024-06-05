package scripts.testset;

import org.testng.annotations.Test;
import pages.TestPage;
import scripts.BaseTest;

public class TestTest extends BaseTest {
    @Test(groups = "smoke")
    public void TestTest() {
        new TestPage().performDownloadFile("src/resources/download");
        new TestPage().performUploadFile("src/resources/upload/image.png");
        new TestPage().performUploadFile("aaaa");
        new TestPage().performUploadFile("bbb");
    }
}
