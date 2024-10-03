package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\pts-2024\\chrome\\chromedriver-1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ais2.ukf.sk/ais/start.do");
        WebElement cookieButton = driver.findElement(By.xpath("/html/body/div[6]/button[1]"));
        cookieButton.click();

        WebElement username = driver.findElement(By.id("login"));
        username.sendKeys("DOMINIK");
        WebElement password = driver.findElement(By.id("heslo"));
        password.sendKeys("HESLO");
        WebElement submit = driver.findElement(By.id("login-form-submit-btn"));
        submit.submit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}