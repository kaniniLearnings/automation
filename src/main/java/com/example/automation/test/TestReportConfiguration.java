package com.example.automation.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;

public class TestReportConfiguration {
    public static ExtentReports ext;
    public static ExtentTest test;

    @AfterSuite
    public void afterSuite() {
        ext.flush();
        ext.close();
    }

    @BeforeSuite
    public void beforeSuite(){
        ext = new ExtentReports("extendsReport.html",true);
        ext.loadConfig(new File("extents-config.xml"));
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        test = ext.startTest(this.getClass().getSimpleName()+" :: "+ method.getName());
        test.log(LogStatus.PASS,"test passed");
    }

    @AfterMethod
    public void afterMethod() {
        ext.endTest(test);
    }

}
