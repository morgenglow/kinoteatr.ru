package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMethods {
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginMethods(WebDriver driver) {
        this.driver=driver;
    }

    public void openLoginWindow() {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("js-top-login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mail_container")));
        driver.navigate().refresh();
        driver.findElement(By.id("js-top-login")).click();
    }

    public void typePhoneNumber(String number) {
        driver.findElement(By.id("auth_by_phone")).click();
        driver.findElement(By.id("login_phone")).click();
        driver.findElement(By.id("login_phone")).clear();
        driver.findElement(By.id("login_phone")).sendKeys(number);
        driver.findElement(By.id("auth_login_by_phone")).click();
    }

    public void typeEmail(String email, String password) {
        driver.findElement(By.id("auth_by_email")).click();
        driver.findElement(By.id("login_email")).sendKeys(email);
        driver.findElement(By.id("login_password")).sendKeys(password);
        driver.findElement(By.id("auth_submit_by_email")).click();
    }
}
