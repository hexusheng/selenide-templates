package com.templates.listeners;

import com.templates.helpers.AllureThings;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

public class AllureFailReporter extends ExitCodeListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        AllureThings.exec().makeScreenShot("Fail screenshot");
    }
}
