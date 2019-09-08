package com.CM.Collect.Listener;

import java.io.File;
import java.util.*;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportListener implements IReporter
{
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
    {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentRepoert.html", true);
    
        for(ISuite suite : suites)
        {
            Map<String, ISuiteResult> result = suite.getResults();

            for(ISuiteResult r : result.values())
            {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
        extent.loadConfig(new File(System.getProperty("C:\\Users\\hp\\Eclps_Projects\\com.Amazon.Test\\Test_Data")));
        extent.loadConfig(new File("C:\\Users\\hp\\Eclps_Projects\\com.Amazon.Test\\Test_Data\\Report"+xmlSuites.toString()+".xml"));
        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status)
    {
        ExtentTest test;

        if(tests.size() > 0)
        {
            for(ITestResult result : tests.getAllResults())
            {
                test = extent.startTest(result.getMethod().getMethodName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for(String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if(result.getThrowable() != null)
                {
                    test.log(status, result.getThrowable());
                }
                else{
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                extent.endTest(test);
            }
        }
    }

    private Date getTime(Long millis)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
} 
