package evprimeTests;

import base.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pages.ContactPage;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;

public class ContactPageTests extends BaseTest {

    private ContactPage contactPage;
    private SidePanel sidePanel;


    @Before
    public void setUp(){
        contactPage = new ContactPage(driver);
        sidePanel = new SidePanel(driver);
    }

    @Test
    public void validationContactPageTest()  {
        sidePanel.clickMenuIcon();
        sidePanel.clickContactButton();

        assertEquals("Want to reach out?",contactPage.getTextFromContactPageTitle());

        String name = RandomStringUtils.randomAlphanumeric(10);
        String mail = RandomStringUtils.randomAlphanumeric(10) + "@mail.com";
        String message = RandomStringUtils.randomAlphanumeric(100);

        contactPage.insertName(name);
        contactPage.insertMail(mail);
        contactPage.insertMessage(message);
        contactPage.clickSendButton();

        assertEquals("Unexpected Application Error!",contactPage.getTextFromErrorMessage());
    }

    @Test
    public void contactPageComponentsDesign(){

        sidePanel.clickMenuIcon();
        sidePanel.clickContactButton();

        assertEquals("#304ffe",contactPage.getBackgroundColorOfSendButton());
        assertEquals("#ffffff",contactPage.getColorOfSendButton());
        assertEquals("SEND",contactPage.getTextFromSendButton());
        assertEquals("\"Josefin Sans\"",contactPage.getSendButtonFontType());
        assertEquals("14px",contactPage.getSendButtonFontSize());
    }

}
