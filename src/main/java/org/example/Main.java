package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\pts-2024\\chrome\\chromedriver-1.exe");
        WebDriver driver = new ChromeDriver();
        /*
        driver.get("https://ais2.ukf.sk/ais/start.do");
        WebElement cookieButton = driver.findElement(By.xpath("/html/body/div[6]/button[1]"));
        cookieButton.click();

        WebElement username = driver.findElement(By.id("login"));
        username.sendKeys("DOMINIK");
        WebElement password = driver.findElement(By.id("heslo"));
        password.sendKeys("HESLO");
        WebElement submit = driver.findElement(By.id("login-form-submit-btn"));
        submit.submit();
         */

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

        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
         */

        driver.get("https://www.alza.sk/mobily/18843445.htm");
        try {
            WebElement cookiebutton = driver.findElement(By.xpath("//*[@id=\"rootHtml\"]/body/div[9]/div/div/div[2]/a[1]"));
            cookiebutton.click();
            Thread.sleep(1000);

            WebElement selectBox = driver.findElement(By.id("cpcm_cpc_parametrization_rptHierarchicParameterGroups_hierarchicParameterGroup_0_rptParameters_0_ddlParameterValues_0"));
            Select dropdown = new Select(selectBox);

            // Získame všetky možnosti v zozname
            List<WebElement> options = dropdown.getOptions();
            // Prejdeme všetky možnosti a vypíšeme ich text do konzoly
            for (WebElement option : options) {
                if(option.getText().equals("Apple")) {
                    System.out.println("Ano selectBox obsahuje znacku Apple");
                }
                System.out.println("Option text: " + option.getText() + " " + "Option value: " + option.getAttribute("value"));
            }

            dropdown.selectByIndex(5);
            dropdown.selectByValue("3933");
            dropdown.selectByVisibleText("Apple");
            Thread.sleep(5000);

            Actions act = new Actions(driver);

            act.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);
            act.sendKeys(Keys.PAGE_DOWN).perform();

            WebElement image = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/div/div[1]/div/header/div[4]/a/img"));
            WebElement input = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/div/div[1]/div/header/div[7]/div/div/div/input"));
            act.dragAndDrop(image,input).build().perform();
            act.clickAndHold(image).moveToElement(input).release().build().perform();

            Thread.sleep(5000);


            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("confirm('Potvrd ale vyvrat')");
            Thread.sleep(1000);
            driver.switchTo().alert().dismiss();
            Thread.sleep(1000);

            js.executeScript("alert(22)");
            Thread.sleep(1000);
            driver.switchTo().alert().accept();

            js.executeScript("alert('Ahoj ja som tu')");
            Thread.sleep(1000);
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}