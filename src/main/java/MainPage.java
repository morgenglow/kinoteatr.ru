import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class MainPage {

    public WebDriver driver;
    public Map<String, WebElement> menuValues;
    public WebDriverWait wait;
    public String currCity;
    public static List<WebElement> citiesList;
    public List<String> textList =new ArrayList<>();;
    public final List<String> expectedCitiesList = new ArrayList(Arrays.asList("Москва","Санкт-Петербург","Белгород","Волгоград","Вологда","Воронеж","Екатеринбург","Ижевск","Калининград","Ковров","Краснодар","Красноярск","Мурманск","Набережные Челны","Нижний Новгород","Новокузнецк","Новосибирск","Пермь","Рязань","Самара","Саратов","Сочи","Ставрополь","Сургут","Сыктывкар","Тула","Тюмень","Ульяновск","Уфа","Челябинск"));

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By mainLogo = By.cssSelector(".header_new_logo");
    private By loginButton = By.xpath("//div[@id='login_button']");
    private By locationButton = By.className("city");
    private By popUp = By.className("pop_up_box");
    private By closePopUp = By.className("btn");
    //private List<WebElement> menuBar = driver.findElements(By.xpath("//div[@class='menu_line']/ul/li"));
    //private By kinoBro = By.xpath("//div[@class='nt-label-lt-integration']");
    //private List<WebElement> socialMediaBar = driver.findElements(By.xpath("//p[@class='title']/following-sibling::div[1]/div"));

    //нажатие на лого
    public MainPage clickOnLogo() {
        driver.findElement(mainLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickUniversal(By locator) {
        driver.findElement(locator).click();
        return new MainPage(driver);
    }

    //закрытие всплывающего окна
    public MainPage closePopUp() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(popUp));
        driver.findElement(closePopUp).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUp));
        return new MainPage(driver);
    }

    //получение списка городов
    public List<WebElement> getCitiesList() {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(locationButton).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fon_box hidden']/following-sibling::div[1]")));
        citiesList = driver.findElements(By.xpath("//a[@data-city-code]"));
        return citiesList;
    }

    //выбор города
    public MainPage chooseCity(int i) {
//        driver.findElement(locationButton).click();
        citiesList.get(i).click();
        return new MainPage(driver);
    }

    //проверка текущего города
    public String getCity() {
        currCity = driver.findElement(locationButton).getText();
        return currCity;
    }

    public List<String> getText(List<WebElement> element) {
        for(int i=0; i<citiesList.size(); i++){
            String city = citiesList.get(i).getText();
            city = city.replaceAll("^\\s+|\\s+$", "");
            textList.add(city);
        }
        return textList;
    }

    public void fillCardData(String cardNumber, String expiryData, String cvc) {
        driver.switchTo().frame(0);
        clickUniversal(By.id("pan"));
        driver.findElement(By.id("pan")).sendKeys(cardNumber);
        clickUniversal(By.id("expiry"));
        driver.findElement(By.id("expiry")).clear();
        driver.findElement(By.id("expiry")).sendKeys(expiryData);
        driver.findElement(By.id("cvc")).clear();
        driver.findElement(By.id("cvc")).sendKeys(cvc);
    }

    public void fillPresentForm() {
        clickUniversal(By.xpath("//textarea[@name='to_name']"));
        driver.findElement(By.xpath("//textarea[@name='to_name']")).sendKeys("Mila");
        driver.findElement(By.id("text_message")).clear();
        driver.findElement(By.id("text_message")).sendKeys("Happy birthday!");
        driver.findElement(By.xpath("//textarea[@name='from_name']")).clear();
        driver.findElement(By.xpath("//textarea[@name='from_name']")).sendKeys("Lucy");
        driver.findElement(By.id("to-email-field")).clear();
        driver.findElement(By.id("to-email-field")).sendKeys("mila@mila.com");
        driver.findElement(By.id("from-email-field")).clear();
        driver.findElement(By.id("from-email-field")).sendKeys("Lucy@lucy.com");
        cardOptions("(//label[@class='checkbox']//span)[2]", "(//span[text()='Оплатить и отправить'])[2]");
    }

    public void cardOptions(String cardSumm, String cardDesign) {
        clickUniversal(By.xpath(cardSumm));
        clickUniversal(By.xpath(cardDesign));
    }
}
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