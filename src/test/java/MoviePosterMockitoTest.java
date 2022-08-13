import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MoviePosterMockitoTest {

    MoviePosterRepository repo = Mockito.mock(MoviePosterRepository.class);
    MoviePosterManager poster = new MoviePosterManager(repo);

    MoviePoster item1 = new MoviePoster(1, "https://", "Бладшот", "боевик");
    MoviePoster item2 = new MoviePoster(2, "https://", "Вперед", "мультфильм");
    MoviePoster item3 = new MoviePoster(3, "https://", "Отель", "комедия");

    @Test
    public void ShouldGetLastDef() {
        MoviePoster[] items = {item1, item2, item3};
        doReturn(items).when(repo).findAll();

        MoviePoster[] expected = {item3, item2, item1};
        MoviePoster[] actual = poster.findLastDef();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetLastIfMoviesMoreThanNum() {
        MoviePoster[] items = {item1, item2, item3};
        doReturn(items).when(repo).findAll();

        MoviePoster[] expected = {item3, item2};
        MoviePoster[] actual = poster.findLast(2);

        Assertions.assertArrayEquals(expected, actual);
    }
}
