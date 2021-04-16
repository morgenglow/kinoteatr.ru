import io.qameta.allure.Step;
import model.LoginMethods;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.hamcrest.CoreMatchers.containsString;

public class LoginTests extends BaseTest {

    @ParameterizedTest
    @MethodSource("phonesDataProvider")
    @Step("Неудачная попытка авторизации по незарегистрированному телефону")
    @Test
    public void loginPhoneFail(String phone) {
        mainPage.closePopUp();
        loginMethods = new LoginMethods(mainPage.driver);
        loginMethods.openLoginWindow();
        loginMethods.typePhoneNumber(phone);
        String value = loginMethods.driver.findElement(By.xpath("(//p[@class='header error'])[2]")).getText();
        MatcherAssert.assertThat(value, containsString("Номер не зарегистрирован"));
    }


    @ParameterizedTest
    @MethodSource("mailsDataProvider")
    @Step("Неудачная попытка авторизации по незарегистрированному емейлу")
    @Test
    public void loginMailFail(String email, String password) {
        mainPage.closePopUp();
        loginMethods = new LoginMethods(mainPage.driver);
        loginMethods.openLoginWindow();
        loginMethods.typeEmail(email, password);
        String value = loginMethods.driver.findElement(By.xpath("(//p[@class='header error'])[2]")).getText();
        MatcherAssert.assertThat(value, containsString("Такой email не зарегистрирован"));
    }

    static Stream<Arguments> phonesDataProvider() {
        return Stream.of(
                arguments("9801434905"),
                arguments("9081434905"),
                arguments("9921330000")
        );
    }

    static Stream<Arguments> mailsDataProvider() {
        return Stream.of(
                arguments("something@gimail.com", "pass123"),
                arguments(" ", "pass123"),
                arguments(" ", " "),
                arguments("something3@gimail", "pass123")
        );
    }
}
