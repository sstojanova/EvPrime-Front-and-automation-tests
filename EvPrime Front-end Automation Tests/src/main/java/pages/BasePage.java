package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickElement(By element){
        driver.findElement(element).click();
    }

    public String getTextFromElement(By element){
        return driver.findElement(element).getText();
    }

    public void insertText(By element,String text){
         driver.findElement(element).sendKeys(text);
    }

    public void hoverElement(By locator){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

}
