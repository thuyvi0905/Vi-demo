package dataprovider;

import org.testng.annotations.DataProvider;

public class Provider {
    @DataProvider
    public static Object[][] netlifySearchKeywords (){
        return new Object[][]{{"john"}, {"kathy"}, {"peter"}};
    }
}
