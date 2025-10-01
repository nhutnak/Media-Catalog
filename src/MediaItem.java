public abstract class MediaItem
{
    private String id;
    private String title;

    public MediaItem(String id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public String summary(){return null;}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
