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
    private By emailField = By.id("login_email");
    private By passField = By.id("login_password");
    private By rememberMeCheckbox = By.xpath("//div[@class='tick checked']");
    private By forgotpassword = By.id("auth-not-remember-pass-link");
    private By logInButton = By.id("auth_submit_by_email");
    private List<WebElement> socAPI = driver.findElements(By.xpath("//div[@class='auth-modal-footer init']/ul/li"));
    private By backButtonReg = By.xpath("//div[@id='auth_slide_reg_by_phone']/div[1]/span[1]");
    private By backButtonEmail = By.xpath("((//span[@class='auth_header_action'])[5]");
    private By backButtonPhone = By.xpath("//div[@id='auth_slide_phone']/div[1]/span[1]");
    private By closeLogInWindow = By.xpath("//div[@class='auth-close'][1]");

//реакция на нажатие кнопки "Регистрация"(на данный момент невозможна)
    public String registration(){
        driver.findElement(registerButton).click();
        String answer = driver.findElement(By.xpath("//div[@id='auth_slide_reg_by_phone']/div[3]/div[1]/b[1]")).getText();
        return answer;
    }

//закрытие окна аутентификации
    public contentPage closeLogInWindow (){
        driver.findElement(closeLogInWindow).click();
        return new contentPage(driver);
    }

//возврат в окно авторизации из окна регистрации
    public LogInWindow returnBack(){
        driver.findElement(backButtonReg).click();
        return this;
    }

//авторизация по email
    public contentPage emailAuth(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passField).sendKeys(password);
        driver.findElement(logInButton).submit();
        return new contentPage(driver);
    }
}
