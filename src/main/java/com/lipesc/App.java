package com.lipesc;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lipesc.pages.GoogleSearchPage;
import com.lipesc.utils.DriverManagerSelenium;


public class App 
{
    public static void main( String[] args )
    {
        
        
        WebDriver driver = DriverManagerSelenium.getDriver();
        try {
            GoogleSearchPage searchPage = new GoogleSearchPage(driver);
            searchPage.openGoogle();
            searchPage.search("Selenium Java");
            
            var titles = searchPage.getResultTitles();
            searchPage.displayResults(titles);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DriverManagerSelenium.closerDriver();
        }
    }
}
