package listener;

import asserts.CustomSoftAssert;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.ArrayList;

public class MethodListener implements IInvokedMethodListener{
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()){
            if (CustomSoftAssert.throwableList.size()>0){
                testResult.setStatus(ITestResult.FAILURE);
                testResult.setThrowable(new Throwable(CustomSoftAssert.throwableList.toString()));
                CustomSoftAssert.throwableList= new ArrayList<>();
            }
        }
    }
}
