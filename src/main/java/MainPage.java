import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPage {

    private WebDriver driver;
    public Map<String, WebElement> menuValues;
    private WebDriverWait wait;
    public String currCity;
    List<WebElement> citiesList;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By mainLogo = By.cssSelector(".header_new_logo");
    private By loginButton = By.xpath("//div[@id='login_button']");
    private By locationButton = By.id("city");
    private By popUp = By.xpath("//div[@class='popup_content special']");
    private By closePopUp = By.xpath("//a[@id='service_popup_close']//img[1]");
    //private List<WebElement> menuBar = driver.findElements(By.xpath("//div[@class='menu_line']/ul/li"));
    //private By kinoBro = By.xpath("//div[@class='nt-label-lt-integration']");
    //private List<WebElement> socialMediaBar = driver.findElements(By.xpath("//p[@class='title']/following-sibling::div[1]/div"));

//нажатие на лого
    public MainPage clickOnLogo() {
        driver.findElement(mainLogo).click();
        return new MainPage(driver);
    }

 //закрытие всплывающего окна
    public MainPage closePopUp(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(popUp));
        driver.findElement(closePopUp).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUp));
        return new MainPage(driver);
    }

 //получение списка городов
    public MainPage getCitiesList() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(locationButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cities active']")));
        citiesList = driver.findElements(By.xpath("//div[@class='cities active']/div/ul/li"));
        return new MainPage(driver);
    }

    //выбор города
    public MainPage chooseCity(int i) {
        driver.findElement(locationButton).click();
        citiesList.get(i).click();
        return new MainPage(driver);
    }

    //проверка текущего города
    public String getCity(){
        currCity = driver.findElement(locationButton).getText();
        return currCity;
    }
    }

//нажатие на ссылку одной из соц. сетей по индексу
//    public void clickOnMediaLink(int i){
//       socialMediaBar.get(i).click();
//    }

//вызов элемента меню по его индексу
//    public contentPage chooseMenu(int i) {
//        menuBar.get(i).click();
//        return new contentPage(driver);
//    }

//создание пар ключ-название из элементов меню
//    public Map<String, WebElement> getMenuValue() {
//        menuValues = new HashMap<String, WebElement>();
//        for (int i = 0; i <= menuBar.size(); i++) {
//            String menuText = menuBar.get(i).getText();
//            menuValues.put(menuText, menuBar.get(i));
//        }
//        return menuValues;
//    }

//вызов элемента меню по его названию
//    public contentPage chooseMenuByValue(String menuText) {
//        getMenuValue();
//        for (int i = 0; i <= menuValues.size(); i++){
//            if (menuValues.get(i).getText().equals(menuText)) {
//                menuValues.get(i).click();
//            }
//        }
//        return new contentPage(driver);
//    }

//вызов виджета с чатом
//    public KinoBroChat chooseBro () {
//        driver.findElement(kinoBro).click();
//        return new KinoBroChat(driver);
//    }

//вызов окна логина
//    public LogInWindow logInClick () {
//        driver.findElement(loginButton).click();
//        return new LogInWindow(driver);
//    }
//    }
