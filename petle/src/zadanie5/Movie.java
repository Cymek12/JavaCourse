package zadanie5;

public class Movie extends LibraryItem{
    static int movieCounter;
    private String director;
    private int movieTime;

    public Movie(String title, String director, int movieTime) {
        super(title);
        this.director = director;
        this.movieTime = movieTime;
        //movieCounter++;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(int movieTime) {
        this.movieTime = movieTime;
    }

    @Override
    public String toString() {
        return  "Tytuł: " + title +
                ", Reżyser: " + director +
                ", Długość filmu: " + movieTime +
                " min, Czy dostępny: " + isAvailable;
    }
}
