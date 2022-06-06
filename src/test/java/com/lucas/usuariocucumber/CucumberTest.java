package com.lucas.usuariocucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/main/resources/feature", plugin = "pretty") 
@RunWith(Cucumber.class)
public class CucumberTest {
//, extraGlue = "com.lucas.usuariocucumber.controller"
}
