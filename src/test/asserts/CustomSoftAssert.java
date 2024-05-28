package asserts;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomSoftAssert extends SoftAssert {
    public static List<Throwable> throwableList= new ArrayList<>();

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        throwableList.add(ex);
    }
}
