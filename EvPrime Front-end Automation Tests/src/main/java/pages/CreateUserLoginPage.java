package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CreateUserLoginPage extends BasePage {

    private By formTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private By emailTextBox = By.name("email");
    private By passwordTextBox = By.name("password");
    private By changeStatusButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By emailAlreadyExist = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private By errorMessage2 = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li[2]");
    private By errorDescription = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");

    Color goButtonColor;
    Color changeStatusButtonColor;

    public CreateUserLoginPage(WebDriver driver) {
        super(driver);
    }


    public void insertEmail(String email) {
        insertText(emailTextBox,email);
    }


    public void insertPassword(String password) {
        insertText(passwordTextBox,password);
    }

    public void clickChangeStatusButton() {
        clickElement(changeStatusButton);
    }


    public boolean isCreateNewUserMessageDisplayed() {
        try {
            driver.findElement(formTitle);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickGoButton(){
        clickElement(goButton);
    }

    public boolean isEmailAlreadyExistMessageDisplayed() {
        try {
            driver.findElement(emailAlreadyExist);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTextFromErrorMessage(){
        return getTextFromElement(errorMessage);
    }

    public String getTextFromErrorDescription(){
        return getTextFromElement(errorDescription);
    }


    public String getTextFromErrorMessage2(){
        return getTextFromElement(errorMessage2);
    }

    public String getBackgroundColorOfGoButton() {
        goButtonColor = Color.fromString(driver.findElement(goButton).getCssValue("background-color"));
        return goButtonColor.asHex();
    }

    public String getTextFromGoButton(){
        return getTextFromElement(goButton);
    }


    public String getGoButtonFontType() {
        return driver.findElement(goButton).getCssValue("font-family");
    }

    public String getGoButtonFontSize() {
        return driver.findElement(goButton).getCssValue("font-size");
    }

    public String getBackgroundColorOfChangeStatusButton() {
        changeStatusButtonColor = Color.fromString(driver.findElement(changeStatusButton).getCssValue("background-color"));
        return changeStatusButtonColor.asHex();
    }

    public String getTextFromChangeStatusButton(){
        return getTextFromElement(changeStatusButton);
    }


    public String getChangeStatusButtonFontType() {
        return driver.findElement(changeStatusButton).getCssValue("font-family");
    }

    public String getChangeStatusButtonFontSize() {
        return driver.findElement(changeStatusButton).getCssValue("font-size");
    }

}
