import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KinoBroChat {
    private WebDriver driver;

    public KinoBroChat(WebDriver driver) {
        this.driver = driver;
    }

    private By chatField = By.id("nt-widget-form-input");
    private By closeChat = By.xpath("//div[@class='nt-close-button']//i[1]");

    public KinoBroChat sendQuestion (String question){
        driver.findElement(chatField).sendKeys(question);
        return this;
    }

    public contentPage closeChat (){
        driver.findElement(closeChat).click();
        return new contentPage(driver);
    }
}
