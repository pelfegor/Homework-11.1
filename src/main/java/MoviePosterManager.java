public class MoviePosterManager {

    private MoviePoster[] items = new MoviePoster[0];

    private int limit;

    public MoviePosterManager() {
        limit = 10;
    }

    public MoviePosterManager(int limit) {
        this.limit = limit;
    }

    public void save(MoviePoster item) {
        MoviePoster[] tmp = new MoviePoster[items.length +1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length -1] = item;
        items = tmp;
    }

    public MoviePoster[] findAll() {
        return items;
    }

    public MoviePoster[] findLast() {
        int resultLength = limit < items.length ? limit : items.length;
        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}
