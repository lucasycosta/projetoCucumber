package com.lucas.usuariocucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/resources/featureEMG", 
				 snippets = SnippetType.CAMELCASE, 
				 plugin = { "pretty", "html:target/report-html/report-api.html", "json:target/report-json/report-api.json" }, 
				 glue = {"com.lucas.usuariocucumber.api" }, 
				 tags = "@apirest",
				 monochrome = true)
@RunWith(Cucumber.class)
public class CucumberAPITest {

}
