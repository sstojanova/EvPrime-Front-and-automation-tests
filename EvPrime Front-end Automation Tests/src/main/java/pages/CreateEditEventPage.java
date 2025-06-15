package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CreateEditEventPage extends BasePage {
    private By eventTitle = By.name("title");
    private By eventImage = By.name("image");
    private By eventDate = By.name("date");
    private By eventLocation = By.name("location");
    //private By eventDescription = By.id(":r7:");
    private By eventDescription = By.cssSelector("textarea[name=\"description\"]");
    private By createEventButton =By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");

    Color createEventButtonColor;


    public CreateEditEventPage(WebDriver driver) {
        super(driver);
    }

    public void insertEventTitle(String title){
        insertText(eventTitle,title);
    }

    public void insertEventImage(String image){
        insertText(eventImage,image);
    }

    public void insertEventDate(String date){
        insertText(eventDate,date);
    }

    public void insertEventLocation(String location){
        insertText(eventLocation,location);
    }

    public void insertEventDescription(String description){
        insertText(eventDescription,description);
    }

    public void clickCreateEventButton(){
        clickElement(createEventButton);
    }

    public String getBackgroundColorOfCreateEventButton() {
        createEventButtonColor = Color.fromString(driver.findElement(createEventButton).getCssValue("background-color"));
        return createEventButtonColor.asHex();
    }
    public String getTextFromCreateEventButton(){
        return getTextFromElement(createEventButton);
    }

    public String getCreateEventButtonFontType() {
        return driver.findElement(createEventButton).getCssValue("font-family");
    }

    public String getCreateEventButtonFontSize() {
        return driver.findElement(createEventButton).getCssValue("font-size");
    }

}
