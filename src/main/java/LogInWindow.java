import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LogInWindow {

    private WebDriver driver;

    public LogInWindow(WebDriver driver) {
        this.driver = driver;
    }

    private By registerButton = By.xpath("//span[text()='Зарегистрироваться']");
    private By loginText = By.xpath("//p[text()='Войти']");
    private By loginPhone = By.id("auth_by_phone");
    private By loginEmail = By.id("auth_by_email");
    private List<WebElement> socAPI = driver.findElements(By.xpath("//div[@class='auth-modal-footer init']/ul/li"));

}
