import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<MediaItem> catalogue = new ArrayList<MediaItem>();
        catalogue.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        catalogue.add(new Movie("M001", "Inception", "Christopher Nolan", 2010, 148));
        catalogue.add(new Album("A001", "Thriller", "Michael Jackson", 1982, 9));
        String filename = "catalogue.csv";
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename))))
        {
            for(MediaItem item : catalogue)
            {
                out.println(item.summary());
            }
            System.out.println("Catalogue saved to " + filename);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}