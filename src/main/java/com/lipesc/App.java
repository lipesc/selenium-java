package com.lipesc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args )
    {
        
        WebDriver driver = new ChromeDriver();
        
        try {
           
            driver.get("https://www.github.com/lipesc");
            
            System.out.println("teste de titulo > " + driver.getTitle());
            
            Thread.sleep(1000);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
