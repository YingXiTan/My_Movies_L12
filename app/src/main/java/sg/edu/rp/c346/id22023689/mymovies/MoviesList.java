package sg.edu.rp.c346.id22023689.mymovies;

public class MoviesList {
    private String title;
    private int year;
    private String rating;
    private String genre;

    public MoviesList(String title, String rating, int year, String genre) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {return title;}

    public String getRating() {return rating;}

    public int getYear() {return year;}

    public String getGenre() {return genre;}




}
