import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerTest {

    MoviePosterRepository repo = new MoviePosterRepository();
    MoviePosterManager poster = new MoviePosterManager(repo);



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
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);
        poster.add(item4);

        MoviePoster[] expected = {item1, item2, item3, item4};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetAll() {
        poster.add(item1);
        poster.add(item2);

        MoviePoster[] expected = {item1, item2};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldGetLastDef() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);

        MoviePoster[] expected = {item3, item2, item1};
        MoviePoster[] actual = poster.findLastDef();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastDefIfMoviesMoreThanTen() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);
        poster.add(item4);
        poster.add(item5);
        poster.add(item6);
        poster.add(item7);
        poster.add(item8);
        poster.add(item9);
        poster.add(item10);
        poster.add(item11);

        MoviePoster[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        MoviePoster[] actual = poster.findLastDef();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastIfMoviesLessThanNum() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);

        MoviePoster[] expected = {item3, item2, item1};
        MoviePoster[] actual = poster.findLast(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastIfMoviesMoreThanNum() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);

        MoviePoster[] expected = {item3, item2};
        MoviePoster[] actual = poster.findLast(2);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindByIdIfExists() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);

        MoviePoster expected = item2;
        MoviePoster actual = repo.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldFindByIdIfNotExists() {
        poster.add(item1);
        poster.add(item2);

        MoviePoster expected = null;
        MoviePoster actual = repo.findById(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveById() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);

        repo.removeById(2);

        MoviePoster[] expected = {item1, item3};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveAll() {
        poster.add(item1);
        poster.add(item2);
        poster.add(item3);

        repo.removeAll();

        MoviePoster[] expected = {};
        MoviePoster[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
