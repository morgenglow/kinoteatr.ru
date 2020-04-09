import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath("//div[@id='login_button']");
    private By locationButton= By.id("city");
    List<WebElement> cityBar = driver.findElements(By.xpath("//div[@class='wrap3']/ul/li"));
    private By searchButton = By.xpath("//input[@id='search_button']");
    List<WebElement> menuBar = driver.findElements(By.xpath("//div[@class='menu_line']/ul/li"));
    private By kinoBro = By.xpath("//div[@class='nt-label-lt-integration']");

    public MainPage chooseCity() {
        driver.findElement(locationButton).click();
        cityBar.get(3).click();
        return new MainPage(driver);
    }

    public contentPage chooseMenu() {
        menuBar.get(2).click();
        return new contentPage(driver);
    }

    public KinoBroChat chooseBro() {
        driver.findElement(kinoBro).click();
        return new KinoBroChat(driver);
    }

    public LogInWindow logInClick(){
        driver.findElement(loginButton).click();
        return new LogInWindow(driver);
    }
}
