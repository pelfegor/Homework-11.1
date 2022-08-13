public class MoviePosterRepository {

    private MoviePoster[] items = new MoviePoster[0];

    public MoviePoster[] findAll() {
        return items;
    }

    public void save(MoviePoster item) {
        MoviePoster[] tmp = new MoviePoster[items.length +1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length -1] = item;
        items = tmp;
    }

    public MoviePoster findById(int id) {
        for(MoviePoster item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        MoviePoster[] tmp = new MoviePoster[items.length - 1];
        int copyToIndex = 0;
        if (findById(id) != null) {
            for (MoviePoster item : items) {
                if (item.getId() != id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
            items = tmp;
        }
    }

    public void removeAll() {
        items = new MoviePoster[0];
    }
}
