import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String filename = "catalogue.csv";
        ArrayList<MediaItem> catalogue = MediaParser.readFromFile(filename);
        Scanner input = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            /*
             *	List all: print each item’s summary() (shows polymorphism in action).
             *	Add item: prompt for type and its fields, auto-generate an ID (e.g., BK-002).
             *	Save: write all items to catalog.csv in the format shown above.
             *	Export: write the catalog to a binary file (catalog.bin) using either Java serialization or DataOutputStream.
             */
            System.out.println("Enter a number to pick an option: " +
             "\n(1) List all items. " +
             "\n(2) Add item (Book/Movie/Album)." +
             "\n(3) Save catalog to CSV." +
             "\n(4) Export catalog to binary file." +
             "\n(5) Populate catologue with testing data. " +
             "\n(0) Exit.");
             System.out.print("Enter option: ");
            option = input.nextInt();
            input.nextLine(); // consume newline
            switch (option)
            {
                case 1: //List all items
                {
                    for (MediaItem item : catalogue)
                    {
                        System.out.println(item.summary());
                    }
                    break;
                }
                case 2: //Add item
                {
                    System.out.println("Enter item type (Book/Movie/Album): ");
                    String type = input.nextLine();
                    if(type.equalsIgnoreCase("Book"))
                    {
                        System.out.print("Enter title: ");
                        String title = input.nextLine();
                        System.out.print("Enter author: ");
                        String author = input.nextLine();
                        System.out.print("Enter year: ");
                        int year = input.nextInt();
                        System.out.print("Enter page count: ");
                        int pageCount = input.nextInt();
                        String id = "B" + catalogue.size() + 1;
                        catalogue.add(new Book(id, title, author, year, pageCount));
                    }
                    else if(type.equalsIgnoreCase("Movie"))
                    {
                        System.out.print("Enter title: ");
                        String title = input.nextLine();
                        System.out.print("Enter director: ");
                        String director = input.nextLine();
                        System.out.print("Enter year: ");
                        int year = input.nextInt();
                        System.out.print("Enter runtime minutes: ");
                        int runtimeMinutes = input.nextInt();
                        String id = "M" + catalogue.size() + 1;
                        catalogue.add(new Movie(id, title, director, year, runtimeMinutes));
                    }
                    else if(type.equalsIgnoreCase("Album"))
                    {
                        System.out.print("Enter title: ");
                        String title = input.nextLine();
                        System.out.print("Enter artist: ");
                        String artist = input.nextLine();
                        System.out.print("Enter year: ");
                        int year = input.nextInt();
                        System.out.print("Enter track count: ");
                        int trackCount = input.nextInt();
                        String id = "A" + catalogue.size() + 1;
                        catalogue.add(new Album(id, title, artist, year, trackCount));
                    }
                    else
                    {
                        System.out.println("Invalid type.");
                    }
                    break;
                }
                case 3: //Save catalog to CSV
                {
                    boolean resultw = MediaParser.writeToFile(filename, catalogue);
                    if(resultw)
                    {
                        System.out.println("File writing succeeded.");
                    }
                    else
                    {
                        System.out.println("File writing failed.");
                    }
                    break;
                }
                case 4://To binary
                {
                    break;
                }
                case 5: //Populate catalogue with testing data
                {
                    catalogue.add(new Book("B"+catalogue.size()+1, "The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
                    catalogue.add(new Movie("M"+catalogue.size()+1, "Inception", "Christopher Nolan", 2010, 148));
                    catalogue.add(new Album("A"+catalogue.size()+1, "Thriller", "Michael Jackson", 1982, 9));
                    catalogue.add(new Book("B"+catalogue.size()+1, "1984", "George Orwell", 1949, 328));
                    catalogue.add(new Movie("M"+catalogue.size()+1, "The Matrix", "The Wachowskis", 1999, 136));
                    catalogue.add(new Album("A"+catalogue.size()+1, "Back in Black", "AC/DC", 1980, 10));
                    break;
                }
                case 0:
                {
                    System.out.println("Ok bye then.");
                }
            }

        }



        /*
        catalogue.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        catalogue.add(new Movie("M001", "Inception", "Christopher Nolan", 2010, 148));
        catalogue.add(new Album("A001", "Thriller", "Michael Jackson", 1982, 9));
        catalogue.add(new Book("B002", "1984", "George Orwell", 1949, 328));
        catalogue.add(new Movie("M002", "The Matrix", "The Wachowskis", 1999, 136));
        catalogue.add(new Album("A002", "Back in Black", "AC/DC", 1980, 10));
         */
        catalogue = MediaParser.readFromFile("catalogue.csv");
//      if (resultr)
//        {
//            System.out.println("File reading succeeded.");
//            for(MediaItem item : catalogue)
//            {
//                System.out.println(item.summary());
//            }
//        }
//        else
//        {
//            System.out.println("File reading failed.");
//        }

//        boolean resultw = false; //MediaParser.writeToFile(filename,catalogue);
//        if(resultw)
//        {
//            System.out.println("File writing succeeded.");
//        }
//        else
//        {
//            System.out.println("File writing failed.");
//        }

    }


}