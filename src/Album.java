/**
 * Album class represents a music album in the media library.
 * It extends the MediaItem class and includes additional attributes
 * such as artist, year of release, and track count.
 */

public class Album extends MediaItem
{
    private String artist;
    private int year;
    private int trackCount;

    public Album(String id, String title, String artist, int year, int trackCount)
    {
        super(id, title);
        this.artist = artist;
        this.year = year;
        this.trackCount = trackCount;
    }

    @Override
    public String summary()
    {
        return "Album,"+super.getId()+","+getTitle()+","+artist+","+year+","+trackCount;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getTrackCount()
    {
        return trackCount;
    }

    public void setTrackCount(int trackCount)
    {
        this.trackCount = trackCount;
    }
}
