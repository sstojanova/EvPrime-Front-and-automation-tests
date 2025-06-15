package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.awt.*;

public class SidePanel extends BasePage{
    private By menuIcon = By.xpath("//*[@id=\"root\"]/div/div/header/div/button");
    private By homeButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[1]/div/div[2]/span");
    private By eventsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[2]/div/div[2]/span");
    private By contactButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]/div/div[2]/span");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private By plusButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button/span[1]");
    private By addEventButton = By.xpath("//*[@id=\"SpeedDial-actions\"]/button");
    private By logOutButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/ul/li/div/div[2]/span");

    Color plusButtonColor;


    public SidePanel(WebDriver driver) {
        super(driver);
    }


    public void clickMenuIcon(){
        clickElement(menuIcon);
    }

    public String getTextFromHomeButton(){
        return getTextFromElement(homeButton);
    }

    public String getHomeButtonFontType() {
        return driver.findElement(homeButton).getCssValue("font-family");
    }

    public String getHomeButtonFontSize() {
        return driver.findElement(homeButton).getCssValue("font-size");
    }

    public String getTextFromEventsButton(){
        return getTextFromElement(eventsButton);
    }

    public String getEventsButtonFontType() {
        return driver.findElement(eventsButton).getCssValue("font-family");
    }

    public String getEventsButtonFontSize() {
        return driver.findElement(eventsButton).getCssValue("font-size");
    }

    public String getTextFromContactButton(){
        return getTextFromElement(contactButton);
    }

    public String getContactButtonFontType() {
        return driver.findElement(contactButton).getCssValue("font-family");
    }

    public String getContactButtonFontSize() {
        return driver.findElement(contactButton).getCssValue("font-size");
    }


    public String getTextFromLoginButton(){
        return getTextFromElement(loginButton);
    }

    public String getLoginButtonFontType() {
        return driver.findElement(loginButton).getCssValue("font-family");
    }

    public String getLoginButtonFontSize() {
        return driver.findElement(loginButton).getCssValue("font-size");
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public void hoverPlusButton(){
        hoverElement(plusButton);
    }

    public void clickPlusButton(){
        clickElement(plusButton);
    }


    public void clickAddEventButton(){
        clickElement(addEventButton);
    }

    public String getColorOfPlusButton() {
        plusButtonColor = Color.fromString(driver.findElement(plusButton).getCssValue("background-color"));
        return plusButtonColor.asHex();
    }

    public void clickEventsButton(){
        clickElement(eventsButton);
    }

    public void clickContactButton(){
        clickElement(contactButton);
    }

    public void clickLogOutButton(){
        clickElement(logOutButton);
    }

    public String getTextFromLogOutButton(){
        return getTextFromElement(logOutButton);
    }

    public String getLogOutButtonFontType() {
        return driver.findElement(logOutButton).getCssValue("font-family");
    }

    public String getLogOutButtonFontSize() {
        return driver.findElement(logOutButton).getCssValue("font-size");
    }

    public boolean isLogOutButtonVisible() {
        try {
            driver.findElement(logOutButton);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAddEventButtonVisible() {
        try {
            driver.findElement(addEventButton);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAddLogOutButtonVisible() {
        try {
            driver.findElement(logOutButton);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

}


