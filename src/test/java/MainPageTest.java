import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\IdeaProjects\\kinoteatr.ru\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://kinoteatr.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void getPageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Кинотеатр.Ру - объединенная киносеть Синема Парк / Формула Кино - Москва", title);
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
