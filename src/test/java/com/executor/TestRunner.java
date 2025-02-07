package com.executor;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
				glue="com.stepdefination",
//				tags="@boxScenario1 or @boxScenario2 or @boxScenario3 or @bookmarkDataTableHeaderScenario",
//				tags="@boxleftsidebar",
//				tags="@boxExampleScenario_part1 or @boxExampleScenario_part2 or @boxExampleScenario_part3",
//				tags="@orangeHRMLoginScenario",
//				tags="@SC1_herokuappScenario or @SC2_contextMenuAlert or @SC5_horizontalSlider",
//				tags="@SC2_contextMenuAlert",
				tags="@SC3_pfizerScienceMenu",
//				tags="@SC5_horizontalSlider",
//				tags="@herokaupp", // or @pfizer
//				tags="@SC4_PfizerJobSearch",
						plugin ={"pretty", "summary",
						"html:reports/htmlreports/report.html",
						"json:reports/report.json",
						"junit:reports/Cucumber.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
				monochrome=true,
				snippets=SnippetType.CAMELCASE,
				publish = true,
				dryRun=false
				)
public class TestRunner {

}
