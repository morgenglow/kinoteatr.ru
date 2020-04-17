import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\IdeaProjects\\kinoteatr.ru\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://kinoteatr.ru/");
        mainPage = new MainPage(driver);
    }

    //проверка заголовка страницы
    @Test
    public void getPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Кинотеатр.Ру - объединенная киносеть Синема Парк / Формула Кино - Москва", title);
    }

    //закрытие всплывающего объявления
    @Test
    public void closePopUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='popup_content special']")));
        driver.findElement(By.xpath("//a[@id='service_popup_close']//img[1]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='popup_content special']")));
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='popup_content special']")).isDisplayed());
    }

    //проверка: клик на лого возвращает главную страницу
    @Test
    public void clickOnLogo(){
        closePopUp();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(mainPage.mainLogo)));
        mainPage.clickOnLogo();
        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://kinoteatr.ru/"));
    }

    //выбор города из меню
//    @Test
//    public void cityCheck(){
//        mainPage.closePopUp();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(mainPage.currentCity)));
//        mainPage.chooseCity(4);
//        Assert.assertEquals(mainPage.getCity(), "Москва");
//    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
