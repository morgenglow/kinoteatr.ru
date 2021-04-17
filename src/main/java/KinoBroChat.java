import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KinoBroChat {
    public WebDriver driver;
    public WebDriverWait wait;
    public boolean notExist = true;

    public KinoBroChat(WebDriver driver) {
        this.driver = driver;
    }

    public By chatField = By.id("nt-widget-form-input");
    public By openChat = By.className("nt-label-lt-integration-icon");
    public By closeChat = By.xpath("//div[@class='nt-close-button']//i[1]");
    public By sendButton = By.className("nt-icon-send");

    public KinoBroChat openChat() {
        driver.findElement(openChat).click();
        return this;
    }

    public KinoBroChat sendQuestion(String question) {
        driver.findElement(chatField).sendKeys(question);
        driver.findElement(sendButton).click();
        return this;
    }

    public MainPage closeChat() {
        driver.findElement(closeChat).click();
        return new MainPage(driver);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
