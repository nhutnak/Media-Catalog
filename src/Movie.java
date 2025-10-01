/**
 * Movie class represents a movie media item with specific attributes like director, year, and runtime.
 * It extends the MediaItem class and provides a summary of the movie details.
 */

public class Movie extends MediaItem
{
    private String director;
    private int year;
    private int runtimeMinutes;

    public Movie(String id, String title, String director, int year, int runtimeMinutes)
    {
        super(id, title);
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
    }

    @Override
    public String summary()
    {
        return "Movie,"+super.getId()+","+getTitle()+","+director+","+year+","+runtimeMinutes;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getRuntimeMinutes()
    {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes)
    {
        this.runtimeMinutes = runtimeMinutes;
    }
}
