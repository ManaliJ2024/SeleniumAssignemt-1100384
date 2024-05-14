package com.executor;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Cucumber executes failed scenarion from this file
		features = "@reports/rerun.txt",
		
		glue= {"src/test/java/features"},
		plugin = { "pretty", 
					"html:reports/htmlreports/report1.html",
					"json:reports/report1.json" }
		
	)

public class ReRunner {

}
