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

        //Vyhľadávanie na základe ID HTML tagu
        //WebElement usernameID = driver.findElement(By.id("login_field"));
        //Vyhľadávanie na základe mena HTML tagu
        //WebElement usernameName = driver.findElement(By.name("login_field"));
        //Vyhľadávanie na základe css class name
        //WebElement usernameClassName = driver.findElement(By.className("login_field"));
        //Vyhľadávanie na základe HTML tagu podla typu
        //WebElement usernameTagName = driver.findElement(By.tagName("input"));
        //Vyhľadávanie na základe obsahu linku
        //<a href="fdsafdsa">A href je nasa hviezda</a>
        //WebElement usernameLinkText = driver.findElement(By.linkText("A href je nasa hviezda"));
        //Vyhľadávanie na základe časti obsahu linku
        //WebElement usernameParcialLinkText = driver.findElement(By.partialLinkText("A href"));
        //Vyhľadávanie na základe CSS selectorov
        //WebElement usernameCss = driver.findElement(By.cssSelector("input[class=login_field]"));
        //Vyhľadávanie na základe XPath
        //WebElement usernameXpath = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}