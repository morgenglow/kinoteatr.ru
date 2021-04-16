import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.qameta.allure.Step;
import model.CardData;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PresentBuyTest extends BaseTest {

    public static List<CardData> cardDataFromFile() throws IOException {
        List<CardData> cardLines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testData/cards.txt")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(" ");
            cardLines.add(new CardData(split[0], split[1], split[2]));
            line = reader.readLine();
        }
        return cardLines;
    }

    @ParameterizedTest
    @MethodSource("giftCardsDataProvider")
    @Step("Тест для проверки ввода некорректного номера карты")
    public void giftCardBuy_WrongCard_Test(String cardSumm, String cardDesign) {
        mainPage.clickUniversal(By.linkText("Киноподарок"));
        //выбор данных карты
        mainPage.cardOptions(cardSumm, cardDesign);
        //заполнение данных отправителя и получателя
        mainPage.fillPresentForm();
        //заполнение данных карты
        mainPage.fillCardData("1234567890123456", "12/22", "123");
        assertEquals("Неверный номер карты", mainPage.driver.findElement(By.xpath("//label[@for='pan']")).getText());
    }

    static Stream<CardData> bankCardsDataProvider() throws IOException {
        Stream.Builder<CardData> builder = Stream.builder();
        for( int i = 0; i < cardDataFromFile().size(); i++ )
            builder.add(cardDataFromFile().get(i));
        Stream<CardData> stream = builder.build();
        return stream;
    }

    @ParameterizedTest
    @MethodSource("bankCardsDataProvider")
    @Step("Тест для проверки ввода некорректного срока действия карты")
    public void giftCardBuy_WrongExpiry_Test(CardData cardData) {
        mainPage.clickUniversal(By.linkText("Киноподарок"));
        //выбор данных карты
        mainPage.cardOptions("(//label[@class='card-type-option'])[1]", "(//span[@class='chooser-option-decor'])[1]");
        //заполнение данных отправителя и получателя
        mainPage.fillPresentForm();
        //заполнение данных карты
        mainPage.fillCardData(cardData.getCardNumber(), cardData.getExpiryData(), cardData.getCvc());
        String value = mainPage.driver.findElement(By.xpath("//label[@for='expiry']")).getText();
        MatcherAssert.assertThat(value, containsString("Неверная дата"));
    }


    static Stream<Arguments> giftCardsDataProvider() {
        return Stream.of(
                arguments("(//label[@class='card-type-option'])[1]", "(//span[@class='chooser-option-decor'])[1]"),
                arguments("(//label[@class='card-type-option'])[2]", "(//span[@class='chooser-option-decor'])[2]"),
                arguments("(//label[@class='card-type-option'])[3]", "(//span[@class='chooser-option-decor'])[3]"),
                arguments("(//label[@class='card-type-option'])[3]", "(//span[@class='chooser-option-decor'])[3]")
        );
    }

}


