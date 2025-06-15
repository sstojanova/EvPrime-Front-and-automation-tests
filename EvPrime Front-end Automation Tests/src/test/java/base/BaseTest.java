package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    public WebDriver driver;
    public ChromeOptions options;

    @Before
    public void setUpOnce() {
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:3000/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
