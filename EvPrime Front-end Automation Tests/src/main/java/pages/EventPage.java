package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class EventPage extends BasePage{
    private By deleteEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");
    private By deleteButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");
    private By eventTitleBox = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By eventDateBox = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[2]/h6");
    private By eventLocationBox = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[3]/h6");
    private By eventDescriptionBox = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/span");
    private By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[2]/a");
    private By editButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");
    private By updateEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");

    Color editEventButtonColor;

    public EventPage(WebDriver  driver) {
        super(driver);
    }

    public void clickDeleteEventButton(){
        clickElement(deleteEventButton);
    }

    public void clickDeleteButton(){
        clickElement(deleteButton);
    }

    public String getTextFromEventTitleBox(){
       return getTextFromElement(eventTitleBox);
    }

    public String getTextFromEventDateBox(){
        return getTextFromElement(eventDateBox);
    }

    public String getTextFromEventLocationBox(){
        return getTextFromElement(eventLocationBox);
    }

    public String getTextFromEventDescriptionBox(){
        return getTextFromElement(eventDescriptionBox);
    }

    public void clickBackToEventsButton(){
        clickElement(backToEventsButton);
    }

    public void clickEditButton(){
        clickElement(editButton);
    }

    public void clickUpdateEventButton(){
        clickElement(updateEventButton);
    }

    public void updateTitle(String title) {
        WebElement titleInput = driver.findElement(By.name("title"));
        titleInput.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        titleInput.sendKeys(title);
    }

    public String getBackgroundColorOfEditEventButton() {
        editEventButtonColor = Color.fromString(driver.findElement(editButton).getCssValue("background-color"));
        return editEventButtonColor.asHex();
    }
    public String getTextFromEditEventButton(){
        return getTextFromElement(editButton);
    }

    public String getEditEventButtonFontType() {
        return driver.findElement(editButton).getCssValue("font-family");
    }

    public String getEditEventButtonFontSize() {
        return driver.findElement(editButton).getCssValue("font-size");
    }


}
