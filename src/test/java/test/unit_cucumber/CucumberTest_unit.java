package test.unit_cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)

@CucumberOptions(
//      dryRun   = false,
//      strict = true,
//      tags     = "",
//      monochrome = false,
        features = { "src/test/features" },
        glue     = { "test.unit_cucumber" },
        plugin   = { "pretty", "html:target/cucumber/html-report", "json:target/unit_cucumber/json-report.json" }
)


public class CucumberTest_unit {

    @AfterClass
    public static void generateReport() {
        System.out.println("Starting net.masterthought.cucumber Report");

        File reportOutputDirectory = new File("target/unit_cucumber");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/unit_cucumber/json-report.json");

        String jenkinsBasePath = "";
        String buildNumber = "1";
        String projectName = "UM Portal Unit Cucumber: Are We There Yet?";
        boolean skippedFails = true;
        boolean pendingFails = false;
        boolean undefinedFails = true;
        boolean missingFails = true;
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optionally only if you need
        //configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
        //configuration.setParallelTesting(parallelTesting);
        //configuration.setJenkinsBasePath(jenkinsBasePath);
        //configuration.setRunWithJenkins(runWithJenkins);
        //configuration.setBuildNumber(buildNumber);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();

        System.out.println("Finished net.masterthought.cucumber Report");
    }
}



