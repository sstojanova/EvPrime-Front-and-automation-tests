package evprimeTests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.CreateUserLoginPage;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SidePanelTests extends BaseTest {

    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;


    @Before
    public void setUp(){
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
    }

    @Test
    public void sidePanelItemsValidationWithoutLogin() throws InterruptedException {

        sidePanel.clickMenuIcon();

        assertEquals("Home",sidePanel.getTextFromHomeButton());
        assertEquals("Events",sidePanel.getTextFromEventsButton());
        assertEquals("Contact",sidePanel.getTextFromContactButton());
        assertEquals("Login",sidePanel.getTextFromLoginButton());
    }

    @Test
    public void sidePanelItemValidationWithLogin() throws InterruptedException {

        sidePanel.clickMenuIcon();
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail("test01@mail.com");
        createUserLoginPage.insertPassword("testpasvord");
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);


        assertEquals("Home",sidePanel.getTextFromHomeButton());
        assertEquals("Events",sidePanel.getTextFromEventsButton());
        assertEquals("Contact",sidePanel.getTextFromContactButton());
        assertTrue(sidePanel.isLogOutButtonVisible());
        assertEquals("Log out",sidePanel.getTextFromLogOutButton());
        assertTrue(sidePanel.isAddEventButtonVisible());
    }

    @Test
    public void sidePanelComponentsDesignWithoutLoginTest(){

        sidePanel.clickMenuIcon();

        assertEquals("\"Josefin Sans\"",sidePanel.getHomeButtonFontType());
        assertEquals("16px",sidePanel.getHomeButtonFontSize());
        assertEquals("\"Josefin Sans\"",sidePanel.getEventsButtonFontType());
        assertEquals("16px",sidePanel.getEventsButtonFontSize());
        assertEquals("\"Josefin Sans\"",sidePanel.getContactButtonFontType());
        assertEquals("16px",sidePanel.getContactButtonFontSize());
        assertEquals("\"Josefin Sans\"",sidePanel.getLoginButtonFontType());
        assertEquals("16px",sidePanel.getLoginButtonFontSize());

    }

    @Test
    public void sidePanelComponentsDesignWithLoginTest() throws InterruptedException {

        sidePanel.clickMenuIcon();
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail("test01@mail.com");
        createUserLoginPage.insertPassword("testpasvord");
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        assertEquals("\"Josefin Sans\"",sidePanel.getLogOutButtonFontType());
        assertEquals("16px",sidePanel.getLogOutButtonFontSize());

        sidePanel.clickPlusButton();
        Thread.sleep(2000);

        assertEquals("#000000",sidePanel.getColorOfPlusButton());
    }

}
