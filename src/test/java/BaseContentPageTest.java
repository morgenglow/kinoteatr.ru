import AppManager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class BaseContentPageTest {
    protected WebDriver driver;
    private final ApplicationManager applicationManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    ContentPage contentPage;

    @Before
    public void setUp() {
        applicationManager.initBrowser();
        applicationManager.closePopUp();
        contentPage = new ContentPage(applicationManager.driver);
        contentPage.wait = new WebDriverWait(contentPage.driver, 10);
    }

    @After
    public void tearDown() {
        contentPage.driver.quit();
    }
}
