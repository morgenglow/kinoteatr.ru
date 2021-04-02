import AppManager.ApplicationManager;
import model.LoginMethods;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private final ApplicationManager applicationManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    public MainPage mainPage;
    public LoginMethods loginMethods;
    public WebDriverWait wait;


    @Before
    public void setUp() {
        applicationManager.initBrowser();
        mainPage = new MainPage(applicationManager.driver);
        mainPage.wait = new WebDriverWait(mainPage.driver, 10);
//        mainPage.wait = new WebDriverWait(mainPage.driver, 10);
//        loginMethods= new LoginMethods(driver);
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
//        loginMethods.driver = new ChromeDriver();
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    protected void openLoginWindow() {
        loginMethods.openLoginWindow();
    }
}
