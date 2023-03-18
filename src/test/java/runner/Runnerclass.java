package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)

@CucumberOptions	(


		features	= "src/test/resources/Features" ,
		glue		= {"step_defination"} ,
		plugin 		= {"pretty","html:target/Cucumber-Reports/new-report.html"},
		monochrome 	= true,

//		tags 		= "smoke121" ,

		dryRun 		= false


		)



//@io.cucumber.testng.CucumberOptions	(
//
//
//		features	= "src/test/resources/Features/Register.feature" ,
//		glue		= {"step_defination"} ,
//		plugin 		= {"pretty","html:target/Cucumber-Reports/new-report.html"},
//		monochrome 	= true,
//
////		tags 		= "@ok1" ,
//
//		dryRun 		= false
//
//
//		)



public class Runnerclass extends AbstractTestNGCucumberTests {

}
