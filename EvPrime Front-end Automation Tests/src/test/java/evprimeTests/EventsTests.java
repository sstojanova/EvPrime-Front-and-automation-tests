package evprimeTests;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static util.DataBuilder.currentTime;


public class EventsTests extends BaseTest {

    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private EventsPage eventsPage;
    private CreateEditEventPage createEditEventPage;
    private EventPage eventPage;


    @Before
    public void setUp() throws InterruptedException {
        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        eventsPage = new EventsPage(driver);
        createEditEventPage = new CreateEditEventPage(driver);
        eventPage = new EventPage(driver);
    }


    @Test
    public void eventEndToEndFlowTest() throws InterruptedException {
        //create user
        sidePanel.clickMenuIcon();
        sidePanel.clickLoginButton();

        String mail = "mail" + currentTime() + "@mail.com";
        String password = "pass1234";

        createUserLoginPage.clickChangeStatusButton();

        assertTrue(createUserLoginPage.isCreateNewUserMessageDisplayed());

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        //login
        Thread.sleep(2000);
        sidePanel.clickLoginButton();
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(password);
        createUserLoginPage.clickGoButton();

        //create event
        Thread.sleep(3000);
        sidePanel.hoverPlusButton();
        Thread.sleep(2000);
        sidePanel.clickAddEventButton();
        Thread.sleep(2000);
        createEditEventPage.insertEventTitle("Maraton");
        createEditEventPage.insertEventImage("https://static01.nyt.com/images/2017/10/17/science/11physed-marathon-photo/11physed-marathon-photo-jumbo.jpg?quality=75&auto=webp");
        createEditEventPage.insertEventDate("2025-06-10");
        createEditEventPage.insertEventLocation("Veles");
        createEditEventPage.insertEventDescription("Trcame za Racin");
        createEditEventPage.clickCreateEventButton();

        //event validation
        sidePanel.clickEventsButton();
        Thread.sleep(4000);
        eventsPage.clickEventImage();

        assertEquals("Maraton", eventPage.getTextFromEventTitleBox());
        assertEquals("2025-06-10", eventPage.getTextFromEventDateBox());
        assertEquals("Veles", eventPage.getTextFromEventLocationBox());
        assertEquals("Trcame za Racin", eventPage.getTextFromEventDescriptionBox());

        //update event
        eventPage.clickEditButton();
        Thread.sleep(3000);
        eventPage.updateTitle("Atletska trka");
        eventPage.clickUpdateEventButton();
        Thread.sleep(3000);

        assertEquals("Atletska trka",eventPage.getTextFromEventTitleBox());

        eventPage.clickBackToEventsButton();
        Thread.sleep(3000);
    }


    @After
    public void deleteEvent() throws InterruptedException {

        eventsPage.clickEventImage();
        eventPage.clickDeleteEventButton();
        Thread.sleep(2000);
        eventPage.clickDeleteButton();
    }

}
