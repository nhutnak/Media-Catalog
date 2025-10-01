public class Book extends MediaItem
{
    private String author;
    private int year;
    private int pageCount;

    public Book(String id, String title, String author, int year, int pageCount)
    {
        super(id, title);
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    @Override
    public String summary()
    {
        return "Book,"+super.getId()+","+getTitle()+","+author+","+year+","+pageCount;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
}
