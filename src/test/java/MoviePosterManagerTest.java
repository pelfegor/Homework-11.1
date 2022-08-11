import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerTest {

    MoviePoster item1 = new MoviePoster(1, "https://", "Бладшот", "боевик");
    MoviePoster item2 = new MoviePoster(2, "https://", "Вперед", "мультфильм");
    MoviePoster item3 = new MoviePoster(3, "https://", "Отель", "комедия");
    MoviePoster item4 = new MoviePoster(4, "https://", "Звонок", "ужасы");
    MoviePoster item5 = new MoviePoster(5, "https://", "Тигры", "документальный");
    MoviePoster item6 = new MoviePoster(6, "https://", "Блейд", "триллер");
    MoviePoster item7 = new MoviePoster(7, "https://", "Карты", "аркада");
    MoviePoster item8 = new MoviePoster(8, "https://", "Человек-паук", "комиксы");
    MoviePoster item9 = new MoviePoster(9, "https://", "Дом-призрак", "ужасы");
    MoviePoster item10 = new MoviePoster(10, "https://", "Гарри Поттер", "приключения");
    MoviePoster item11 = new MoviePoster(11, "https://", "Китай", "документальный");
    @Test
    public void shouldSave() {
        MoviePosterManager poster = new MoviePosterManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);

        MoviePoster[] expected = {item1, item2, item3, item4};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetAll() {
        MoviePosterManager poster = new MoviePosterManager();
        poster.save(item1);
        poster.save(item2);

        MoviePoster[] expected = {item1, item2};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldGetLastDef() {
        MoviePosterManager poster = new MoviePosterManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);

        MoviePoster[] expected = {item3, item2, item1};
        MoviePoster[] actual = poster.findLastDef();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastDefIfMoviesMoreThanTen() {
        MoviePosterManager poster = new MoviePosterManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item5);
        poster.save(item6);
        poster.save(item7);
        poster.save(item8);
        poster.save(item9);
        poster.save(item10);
        poster.save(item11);

        MoviePoster[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        MoviePoster[] actual = poster.findLastDef();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastIfMoviesLessThanNum() {
        MoviePosterManager poster = new MoviePosterManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);

        MoviePoster[] expected = {item3, item2, item1};
        MoviePoster[] actual = poster.findLast(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastIfMoviesMoreThanNum() {
        MoviePosterManager poster = new MoviePosterManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);

        MoviePoster[] expected = {item3, item2};
        MoviePoster[] actual = poster.findLast(2);

        Assertions.assertArrayEquals(expected, actual);
    }
}
