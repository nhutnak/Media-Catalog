import java.io.*;
import java.util.ArrayList;

public class MediaParser
{
    private String filename;
    public MediaParser(String filename)
    {
        this.filename = filename;
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

    public static ArrayList<MediaItem> readFromFile(String filename)
    {
        ArrayList<MediaItem> catalogue = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filename)))
        {
            String line = in.readLine();
            while(line != null)
            {
                String[] parts = line.split(",");
                if(parts[0].equals("Book"))
                {
                    catalogue.add(new Book(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
                }
                else if(parts[0].equals("Movie"))
                {
                    catalogue.add(new Movie(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
                }
                else if(parts[0].equals("Album"))
                {
                    catalogue.add(new Album(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
                }
                line = in.readLine();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());

        }
        return catalogue;
    }
}
