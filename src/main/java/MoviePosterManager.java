public class MoviePosterManager {

    private MoviePoster[] items = new MoviePoster[0];

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

    public MoviePoster[] findLastDef() {
        MoviePoster[] all = items;
        int resultLength;
        if (items.length > 10) {
            resultLength = 10;
        } else {
            resultLength = items.length;
        }
        MoviePoster[] last = new MoviePoster[resultLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = all[all.length - 1 - i];
        }
        return last;
    }

    public MoviePoster[] findLast(int num) {
        MoviePoster[] all = items;
        int resultLength;
        if (items.length < num) {
            resultLength = items.length;
        } else {
            resultLength = num;
        }
        MoviePoster[] last = new MoviePoster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            last[i] = all[all.length - 1 - i];
        }
        return last;
    }


}
