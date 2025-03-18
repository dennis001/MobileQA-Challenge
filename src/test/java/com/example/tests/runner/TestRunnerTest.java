package com.example.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/resources/features", // Caminho para os arquivos .feature
    glue = {"com.example.tests.steps", "com.example.tests.hooks"}, // Pacotes dos steps e hooks
    tags = "@login-sucesso", // Tag para filtrar os cenários
    plugin = {"pretty", "html:target/cucumber-reports.html"} // Relatórios
)
public class TestRunnerTest {
}