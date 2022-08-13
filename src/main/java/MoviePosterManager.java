public class MoviePosterManager {

    private MoviePosterRepository repo;

    public MoviePosterManager(MoviePosterRepository repo) {
        this.repo = repo;
    }

    public void add(MoviePoster item) {
        repo.save(item);
    }


    public MoviePoster[] findAll() {
        return repo.findAll();
    }

    public MoviePoster[] findLastDef() {
        MoviePoster[] all = repo.findAll();
        int resultLength;
        if (all.length > 10) {
            resultLength = 10;
        } else {
            resultLength = all.length;
        }
        MoviePoster[] last = new MoviePoster[resultLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = all[all.length - 1 - i];
        }
        return last;
    }

    public MoviePoster[] findLast(int num) {
        MoviePoster[] all = repo.findAll();
        int resultLength;
        if (all.length < num) {
            resultLength = all.length;
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
