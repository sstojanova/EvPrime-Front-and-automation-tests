package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class ContactPage extends BasePage{

    private By contactPageTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/h2");
    private By nameBox = By.name("name");
    ////*[@id="root"]/div/div/main/div[2]/form/div[1]/div[1]/div
    private By mailBox = By.name("email");
    private By messageBox = By.cssSelector("textarea[name=\"description\"][required][aria-invalid=\"false\"]");
    private By sendButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/button");
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/h2");
    private By fillTheFieldMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[2]/div::after");

    Color sendButtonColor;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromContactPageTitle(){
        return getTextFromElement(contactPageTitle);
    }

    public void insertName(String name) {
        insertText(nameBox,name);
    }

    public void insertMail(String mail) {
        insertText(mailBox,mail);
    }

    public void insertMessage(String message) {
        insertText(messageBox,message);
    }

    public void clickSendButton(){
        clickElement(sendButton);
    }

    public String getBackgroundColorOfSendButton() {
        sendButtonColor = Color.fromString(driver.findElement(sendButton).getCssValue("background-color"));
        return sendButtonColor.asHex();
    }

    public String getColorOfSendButton() {
        sendButtonColor = Color.fromString(driver.findElement(sendButton).getCssValue("color"));
        return sendButtonColor.asHex();
    }

    public String getTextFromSendButton(){
        return getTextFromElement(sendButton);
    }

    public String getSendButtonFontType() {
        return driver.findElement(sendButton).getCssValue("font-family");
    }

    public String getSendButtonFontSize() {
        return driver.findElement(sendButton).getCssValue("font-size");
    }

    public String getTextFromErrorMessage(){
        return getTextFromElement(errorMessage);
    }


}
