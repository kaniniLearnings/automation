package com.example.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GooglePageTest extends TestReportConfiguration{

    WebDriver driver;

    public void initialize() {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
    }

    public void launch() {
        driver.get("https://www.google.com/");
    }

    public void close() {
        driver.close();
        driver.quit();
    }

    public void enterText(String text) {
        driver.findElement(By.name("q")).sendKeys(text);
    }

    public void submitForm(){
        driver.findElement(By.name("f")).submit();
    }

    @Test
    public void GoodPage(){
        initialize();
        launch();
        Assert.assertEquals(driver.getTitle(),"Google");
        close();
    }

    @Test
    public void Search(){
        initialize();
        launch();
        enterText("Selenium");
        submitForm();
        Assert.assertEquals(driver.getTitle(),"Selenium - Google Search");
        close();
    }

    @Test
    public void SearchText(){
        initialize();
        launch();
        enterText("Selenium");
        submitForm();
        Assert.assertEquals(driver.findElement(By.name("q")).getAttribute("value"),"Selenium");
        close();
    }


}
