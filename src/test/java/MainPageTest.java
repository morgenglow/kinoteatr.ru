import io.qameta.allure.Description;
import io.qameta.allure.Step;
import model.LoginMethods;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.enabled;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class MainPageTest extends BaseTest{
    private List<String> browserTabs;

    @Step("Открытие главной страницы")
    @Description("Проверка заголовка главной страницы")
    @Test
    public void getPageTitle() {
        String title = mainPage.driver.getTitle();
        Assert.assertEquals("Кинотеатр.Ру - объединенная киносеть Синема Парк / Формула Кино - Москва", title);
    }

    @Step("Подтверждение города нахождения - Москва")
    @Test
    public void clickOnCity() {
        mainPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pop_up_box")));
        mainPage.driver.findElement(By.className("btn")).click();
        Assert.assertTrue(mainPage.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pop_up_box"))));
    }

    @Step("Изменение города нахождения на Воронеж")
    @Test
    public void clickOnCityChange() {
        mainPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pop_up_box")));
        mainPage.driver.findElement(By.className("btn2")).click();
        mainPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cities active']")));
        mainPage.driver.findElement(By.xpath("//a[@data-city-code='voronezh']")).click();
        Assert.assertEquals("https://kinoteatr.ru/voronezh/", mainPage.driver.getCurrentUrl());
    }

    @Step("Проверка: клик на лого возвращает главную страницу")
    @Test
    public void clickOnLogo() {
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.driver.findElement(mainPage.mainLogo)));
        mainPage.clickOnLogo();
        Assert.assertTrue(mainPage.driver.getCurrentUrl().contentEquals("https://kinoteatr.ru/"));
    }

    @Step("Проверка работоспособности ссылки на VK")
    @Test
    public void clickOnVkLink() {
        mainPage.driver.findElement(By.xpath("//span[@class='yad icon-yd-vk']")).click();
        browserTabs = new ArrayList<String>(mainPage.driver.getWindowHandles());
        mainPage.driver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals("https://vk.com/kinoteatr", mainPage.driver.getCurrentUrl());
    }


    @Test
    public void clickOnIgLink() {
        mainPage.driver.findElement(By.xpath("//span[@class='yad icon-yd-instagram']")).click();
        browserTabs = new ArrayList<String>(mainPage.driver.getWindowHandles());
        mainPage.driver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals("https://www.instagram.com/kinoteatr.official/", mainPage.driver.getCurrentUrl());
    }

    @Step("Подсчет количества доступных городов из меню")
    @Test
    public void cityCheck() {
        mainPage.closePopUp();
        mainPage.getCitiesList();
        int linkCount = mainPage.citiesList.size();
        System.out.println("Количество городов для выбора: " + linkCount);
    }

    @Step("Сравнение ожидаемого и фактического списка городов для выбора")
    @Test
    public void cityCompare(){
        mainPage.closePopUp();
        List<String> textList =mainPage.getText(mainPage.getCitiesList());
        System.out.println(textList);
        Assert.assertEquals((new HashSet<>(Arrays.asList(mainPage.expectedCitiesList))), (new HashSet<>(Arrays.asList(textList))));
    }

//
//    @Step("Переход на вкладку с контентом")
//    @Test
//    public void switchToTheatre(){
//        mainPage.closePopUp();
//        mainPage.clickUniversal(By.xpath("//a[@href='#theatre']"));
//        ContentPage contentPage = new ContentPage(mainPage.driver);
//        Assert.assertEquals("TheatreHD: театр в кино", contentPage.driver.findElement(By.xpath("//div[@class='wrap_title theatre_container_header']")).getText());
//    }

//    @Step("Проверка работоспособности ссылок на города из меню")
//    @Test
//    public void cityClick() throws InterruptedException {
//        int i = 0;
//        mainPage.closePopUp();
//        mainPage.getCitiesList();
//        int linkCount = mainPage.citiesList.size();
//        String[] linkTexts = new String[linkCount];
//
//        for (WebElement elements : mainPage.citiesList) {
//            linkTexts[i] = elements.getText();
//            i++;
//        }
//
//        for (int t = 0; t < linkCount; t++) {
//            mainPage.citiesList.get(t).click();
//            if (driver.getTitle().equals("Page 404")) {
//                System.out.println("\"" + linkTexts[t] + "\""
//                        + " is not working.");
//            } else {
//                System.out.println("\"" + linkTexts[t] + "\""
//                        + " is working.");
//            }
//            driver.navigate().back();
//        }
//    }

}
