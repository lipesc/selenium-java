package com.lipesc;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lipesc.pages.DuckSearchPage;
import com.lipesc.utils.DriverManagerSelenium;


public class App 
{
    public static void main( String[] args )
    {
        
        
        WebDriver driver = DriverManagerSelenium.getDriver();
        try {
            DuckSearchPage searchPage = new DuckSearchPage(driver);
            searchPage.openGoogle();
            searchPage.search("Selenium Search pages with Java");
            
            var titles = searchPage.getResultTitles();
            searchPage.displayResults(titles);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DriverManagerSelenium.closerDriver();
        }
    }
}
