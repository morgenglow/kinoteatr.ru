package AppManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver driver;
    public WebDriverWait wait;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void initBrowser(){
            if (browser.equals(BrowserType.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/Driver/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)) {
                System.setProperty("webdriver.ie.driver", "src/test/resources/Driver/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://kinoteatr.ru/");
    }
}
