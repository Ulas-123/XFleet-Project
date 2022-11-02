package XFleet.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber-report.html",
                    "rerun:target/rerun.txt",
                    "json:target/cucumber.json",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber",},
            features = "src/test/resources/features",
            glue = "XFleet/step_definition",
            dryRun = false,
            tags = "@FLTAP-692"
            //publish = false

    )
    public class CukesRunner {

    }


