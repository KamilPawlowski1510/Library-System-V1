
/**
 * Library Class, responsible for a Collection of Objects
 *
 * @author Kamil Pawlowski
 * @version 1
 */
import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.thoughtworks.xstream.security.AnyTypePermission;

public class Library
{
    /**
     * 1. Variables
     */
    //Declare and build an ArrayList of type Patron and Book
    private ArrayList<Patron> patronList= new ArrayList<Patron>();     
    private ArrayList<Book> bookList= new ArrayList<Book>();  

    /**
     * 2. Constructor
     */
    public Library()
    {

    }

    /**
     * 3. Methods
     */

    //Add the object patron1 passed in as parameter to the patronList ArrayList
    public void addPatron(Patron patron1)
    {
        patronList.add(patron1);
    }

    //Add the object book1 passed in as parameter to the bookList ArrayList
    public void addBook(Book book1)
    {
        bookList.add(book1);
    }

    //Takes the index passed in as parameter and deletes the object stored in patronList at that index.
    public void removePatron(int index)
    {
        patronList.remove(index);

    }

    //Takes the index passed in as parameter and deletes the object stored in bookList at that index.
    public void removeBook(int index)
    {
        bookList.remove(index);

    }

    //Uses the size() method to determine how many elements are in patronList
    public int numberOfPatrons()
    {
        return patronList.size();
    }

    //Uses the size() method to determine how many elements are in bookList
    public int numberOfBooks()
    {
        return bookList.size();
    }

    //Creates and returns a string with details of all patron objects stored in patronList - uses toString()
    public String listOfPatrons()
    {
        String allPatrons="";
        int index = 0;
        if(patronList.isEmpty())
        {
            allPatrons = "There are no Patrons in the System!";
        }
        else
        {
            for(Patron p: patronList)
            {
                allPatrons = allPatrons + "Index " + index + ":   "+ p + "\n";
                index++;
            }
        }
        return allPatrons;
    }

    //Creates and returns a string with details of all book objects stored in bookList - uses toString()
    public String listOfBooks()
    {
        String allBooks="";
        int index = 0;
        if(bookList.isEmpty())
        {
            allBooks = "There are no Books in the System!";
        }
        else
        {
            for(Book b: bookList)
            {
                allBooks = allBooks + "Index " + index + ":   "+ b + "\n";

                index++;
            }
        }
        return allBooks;
    }
    
    //Searches the arraylist for a name that is equal to the name passed in as a parameter.
        public String searchPatronByName(String nameIn)
        {
        String searchResults="";
        for(Patron p: patronList)
        {
            if(p.getName().equals(nameIn))
            {
                searchResults = searchResults + p.toString() + "\n";
            }
        }
        return searchResults;
    }

    //Searches the arraylist for a title that is equal to the title passed in as a parameter.
    public String searchBookByTitle(String nameIn)
    {
        String searchResults="";
        for(Book b: bookList)
        {
            if(b.getTitle().equals(nameIn))
            {
                searchResults = searchResults + b + "\n";
            }
        }
        return searchResults;
    }
    
    public Patron getPatron(int index)
    {
        return patronList.get(index);
    }

    public Book getBook(int index)
    {
        return bookList.get(index);
    }
    
    /**
     * 4. My Methods
     *
     * My own methods that added extra functionality to the program
     */
    //Makes a list of every book in the booklist arraylist that has an avail of true
    public String listAvailableBooks()
    {
        String allBooks="";
        int index = 0;
        if(bookList.isEmpty())
        {
            allBooks = "There are no Books in the System!";
        }
        else
        {
            for(Book b: bookList)
            {
                if(b.getAvail() == true)
                {
                allBooks = allBooks + "Index " + index + ":   "+ b + "\n";
                }
                
                index++;
            }
        }
        return allBooks;
    }
    
    //Used to check whether or not a book ID is valid. This is done by comparing its ID with every bookID in the bookList and seeing if it already occured somewhere
    public boolean validifyBookID(String IDIn)
    {
        boolean searchResults=true;
        for(Book b: bookList)
        {
            if(b.getID().equals(IDIn))
            {
                searchResults = false;
            }
        }
        return searchResults;
    }
    
    //Used when returning a book. Takes the inserted ID and compares it with the ID's of all books in bookList. When it finds one that has the same ID it changes its avail to true.
    public void returnBook(String IDIn)
    {
        for(Book b: bookList)
        {
            if(b.getID().equals(IDIn))
            {
                b.setAvail(true);
            }
        }
        
    }
    
    //Counts how many available books there are in the bookList
    public int numberOfAvailBooks()
    {
        int count =0;
        for(Book b: bookList)
        {
            if(b.getAvail()==true)
            {
                count++;
            }
        }
        return count;
    }
    
    //5. Saving and Loading Methods
    
    //Loads Patron file
        @SuppressWarnings("unchecked")
    public void loadPatron() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("patrons.xml"));
        patronList = (ArrayList<Patron>) is.readObject();
        is.close();
    }
    
    //Loads Book file
        @SuppressWarnings("unchecked")
    public void loadBook() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("books.xml"));
        bookList = (ArrayList<Book>) is.readObject();
        is.close();
    }
    
    //Saves Patron file
    public void savePatron() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("patrons.xml"));
        out.writeObject(patronList);
        out.close(); 
    }
    
    //Saves Book file
    public void saveBook() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("books.xml"));
        out.writeObject(bookList);
        out.close();    
    }
}

