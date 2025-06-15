package evprimeTests;

import base.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import static org.junit.Assert.*;
import static util.DataBuilder.currentTime;

public class CreateUserLoginTests extends BaseTest {

    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;

    @Before
    public void setUp(){
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);

        sidePanel.clickMenuIcon();
        sidePanel.clickLoginButton();
    }

    @Test
    public void successfulCreateUserTest() throws InterruptedException {

        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "mail" + currentTime() + "@mail.com";
        String password = "pass1234";

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);

        sidePanel.clickLoginButton();
        createUserLoginPage.clickChangeStatusButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        assertTrue(createUserLoginPage.isEmailAlreadyExistMessageDisplayed());
    }

    @Test
    public void invalidEmailErrorCreateUser() throws InterruptedException {
        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "mail" + currentTime();
        String password = "pass1234";

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("Invalid email.",createUserLoginPage.getTextFromErrorMessage());
        assertEquals("User signup failed due to validation errors.",createUserLoginPage.getTextFromErrorDescription());
    }

    @Test
    public void invalidPasswordErrorCreateUser() throws InterruptedException {
        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "mail" + currentTime()+ "@mail.com";
        String password = RandomStringUtils.randomAlphanumeric(5);

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("Invalid password. Must be at least 6 characters long.",createUserLoginPage.getTextFromErrorMessage());
        assertEquals("User signup failed due to validation errors.",createUserLoginPage.getTextFromErrorDescription());
    }

    @Test
    public void invalidEmailAndPasswordErrorCreateUser() throws InterruptedException {
        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "mail" + currentTime();
        String password = RandomStringUtils.randomAlphanumeric(5);

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("Invalid email.",createUserLoginPage.getTextFromErrorMessage());
        assertEquals("Invalid password. Must be at least 6 characters long.",createUserLoginPage.getTextFromErrorMessage2());
        assertEquals("User signup failed due to validation errors.",createUserLoginPage.getTextFromErrorDescription());
    }

    @Test
    public void emailAlreadyExistErrorCreateUser() throws InterruptedException {
        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "test01@mail.com";
        String password = "pass1234";

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("Email exists already.",createUserLoginPage.getTextFromErrorMessage());
        assertEquals("User signup failed due to validation errors.",createUserLoginPage.getTextFromErrorDescription());
    }

    @Test
    public void emailAlreadyExistAndInvalidPasswordErrorCreateUser() throws InterruptedException {
        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "test01@mail.com";
        String password = RandomStringUtils.randomAlphanumeric(5);

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("Email exists already.",createUserLoginPage.getTextFromErrorMessage());
        assertEquals("Invalid password. Must be at least 6 characters long.",createUserLoginPage.getTextFromErrorMessage2());
        assertEquals("User signup failed due to validation errors.",createUserLoginPage.getTextFromErrorDescription());
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {

        createUserLoginPage.insertEmail("test01@mail.com");
        createUserLoginPage.insertPassword("testpasvord");
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertTrue(sidePanel.isAddEventButtonVisible());
        assertTrue(sidePanel.isAddLogOutButtonVisible());
    }

    @Test
    public void invalidEmailLoginTest() throws InterruptedException {

        createUserLoginPage.insertEmail("test01mail.com");
        createUserLoginPage.insertPassword("testpasvord");
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("Authentication failed.",createUserLoginPage.getTextFromErrorDescription());
    }

    @Test
    public void invalidPasswordLoginTest() throws InterruptedException {

        createUserLoginPage.insertEmail("test01@mail.com");
        createUserLoginPage.insertPassword("pasvord");
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);

        assertEquals("Invalid email or password entered.",createUserLoginPage.getTextFromErrorMessage());
        assertEquals("Invalid credentials.",createUserLoginPage.getTextFromErrorDescription());
    }



    @Test
    public void logOutTest() throws InterruptedException {
        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        String mail = "mail" + currentTime() + "@mail.com";
        String password = "pass1234";

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);

        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickLogOutButton();

        assertFalse(sidePanel.isAddEventButtonVisible());
    }

    @Test
    public void createUserLoginPageComponentDesign(){

        assertEquals("#304ffe",createUserLoginPage.getBackgroundColorOfGoButton());
        assertEquals("GO",createUserLoginPage.getTextFromGoButton());
        assertEquals("\"Josefin Sans\"",createUserLoginPage.getGoButtonFontType());
        assertEquals("14px",createUserLoginPage.getGoButtonFontSize());

        assertEquals("#9c27b0",createUserLoginPage.getBackgroundColorOfChangeStatusButton());
        assertEquals("CREATE USER",createUserLoginPage.getTextFromChangeStatusButton());
        assertEquals("\"Josefin Sans\"",createUserLoginPage.getChangeStatusButtonFontType());
        assertEquals("14px",createUserLoginPage.getChangeStatusButtonFontSize());

        createUserLoginPage.clickChangeStatusButton();

        assertEquals("LOG IN",createUserLoginPage.getTextFromChangeStatusButton());
    }

}

