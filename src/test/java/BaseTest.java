import AppManager.ApplicationManager;
import model.CardData;
import model.LoginMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

public class BaseTest {
    private final ApplicationManager applicationManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    public MainPage mainPage;
    public LoginMethods loginMethods;
    public KinoBroChat kinoBroChat;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeEach
    public void setUp() {
        applicationManager.initBrowser();
        mainPage = new MainPage(applicationManager.driver);
        mainPage.wait = new WebDriverWait(mainPage.driver, 10);
    }


    @AfterEach
    public void tearDown() throws Exception {
        mainPage.driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
