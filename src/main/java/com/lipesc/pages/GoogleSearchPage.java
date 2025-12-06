package com.lipesc.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));

    }

    public void openGoogle() {
    driver.get("https://google.com.br");        
    }

    public void search(String query) {
        System.out.println("buscando > " + query);
        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        search.clear();
        search.sendKeys(query);
        search.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public List<String> getResultTitles() {
        List<WebElement> results = driver.findElements(By.cssSelector("div.g"));
        System.out.printf("titulos encontrados > &s \n", results.size());

        List<String> titles = new ArrayList<>();
        for (int i = 0; i < Math.min(5, results.size()); i++) {
            try {
                String title = results.get(i).findElement(By.cssSelector("h3")).getText();
                titles.add(title);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return titles;
    }

    public void displayResults(List<String> results) {
        int count = 1;
        for (String result : results) {
            System.out.printf("%d -- %s", count, result);
            count++;
        }
    }
}
