import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.hasSize;

public class ContentPageTest extends BaseContentPageTest{

    @Step("Проверка работы фильтров для фильмов")
    @Test
    public void filmFilterTest() {
        contentPage.setMovieFilter("Фильмы", "Скоро на экранах", "драма");
        Integer moviesSize = contentPage.driver.findElements(By.xpath("//div[@class='movie_card_clickable']")).size();
        MatcherAssert.assertThat(moviesSize, Matchers.greaterThan(0));
        }

    @Step("Проверка работы фильтров для спектаклей")
    @Test
    public void theatreFilterTest(){
        contentPage.setTheatreFilter("спектакль");
        Integer theatreSize = contentPage.driver.findElements(By.xpath("//div[@class='movie_card_clickable']")).size();
        MatcherAssert.assertThat(theatreSize, Matchers.greaterThan(0));

    }


}
