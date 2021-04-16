import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContentPage{
    public WebDriver driver;
    public WebDriverWait wait;

    public ContentPage(WebDriver driver) {
        this.driver=driver;
    }

    public void setMovieFilter(String typeActivity, String when, String genre) {
        driver.findElement(By.linkText(typeActivity)).click();
        driver.findElement(By.xpath("(//b[@class='button'])[1]")).click();
        driver.findElement(By.xpath("//li[text()='" + when + "']")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".nextMonthDay")).click();
        driver.findElement(By.xpath("(//b[@class='button'])[2]")).click();
        driver.findElement(By.xpath("//li[text()='" + genre + "']")).click();
        //            driver.switchTo().frame(
//                    driver.findElement(By.cssSelector(".form-control")));
//             setDatepicker(driver, "//input[@readonly='readonly']", );
    }

    public void setTheatreFilter(String genre) {
        driver.findElement(By.linkText("Фильмы")).click();
        driver.findElement(By.linkText("Театр")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".nextMonthDay")).click();
        driver.findElement(By.xpath("(//b[@class='button'])")).click();
        driver.findElement(By.xpath("//li[text()='" + genre + "']")).click();
    }

    public void setDatepicker(WebDriver driver, String cssSelector, String date) {
        new WebDriverWait(driver, 30000).until(
                (WebDriver d) -> d.findElement(By.cssSelector(".form-control")).isDisplayed());
        JavascriptExecutor.class.cast(driver).executeScript(
                String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
    }
}
