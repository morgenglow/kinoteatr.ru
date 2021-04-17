import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KinoBroChatTest extends BaseTest{

    @Step("Открытие и закрытие окна чата")
    @Description("Открыть и закрыть чат без действий")
    @Test
    public void openCloseChat() {
        mainPage.closePopUp();
        kinoBroChat= new KinoBroChat(mainPage.driver);
        kinoBroChat.openChat();
        kinoBroChat.closeChat();
        Assert.assertTrue(mainPage.isElementPresent(kinoBroChat.chatField));
    }

    @Step("Открытие чата и отправка сообщение")
    @Description("Написать Привет! в чат")
    @Test
    public void openChatAndSayHello() {
        mainPage.closePopUp();
        kinoBroChat= new KinoBroChat(mainPage.driver);
        kinoBroChat.openChat();
        kinoBroChat.sendQuestion("Hello!");
        Assert.assertTrue(kinoBroChat.isElementPresent(By.xpath("//button[text()='Связаться с оператором']")));
    }

}