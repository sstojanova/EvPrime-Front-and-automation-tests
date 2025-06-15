package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EventsPage extends BasePage{

    private By eventImage = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/ul/li/img");
    private By eventsTitleList = By.cssSelector("div.MuiImageListItemBar-title.css-dasnyc-MuiImageListItemBar-title");

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void clickEventImage(){
        clickElement(eventImage);
    }

}


