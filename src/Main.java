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
        catalogue.add(new Book("B002", "1984", "George Orwell", 1949, 328));
        catalogue.add(new Movie("M002", "The Matrix", "The Wachowskis", 1999, 136));
        catalogue.add(new Album("A002", "Back in Black", "AC/DC", 1980, 10));
        String filename = "catalogue.csv";

        boolean result = writeToFile(filename, catalogue);
        if(result)
        {
            System.out.println("File writing succeeded.");
        }
        else
        {
            System.out.println("File writing failed.");
        }

    }

    public static boolean writeToFile(String filename, ArrayList<MediaItem> catalogue)
    {
        boolean success = false;
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename))))
        {
            for(MediaItem item : catalogue)
            {
                out.println(item.summary());
            }
            System.out.println("Catalogue saved to " + filename);
            success = true;

        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            success = false;
        }
        return success;
    }
}