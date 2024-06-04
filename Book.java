
/**
 * Book Class 
 *
 * @author Kamil Pawlowski
 * @version 1
 */
import java.util.ArrayList;

public class Book
{
    // variables
    private String ID;
    private String title;
    private String author;
    private String genre;
    private Double cost;
    private boolean avail;
    /**
     * Constructor for objects of class Book
     */

    public Book(String ID, String title, String author, String genre, Double cost, boolean avail)
    {
        this.ID = ID;
        this.title = title;
        this.author = author;
        if(genre.length() <=40)
        {
            this.genre = genre;
        }
        else
        {   
            this.genre = genre.substring(0,40);
        }
        this.cost = cost;
        this.avail = avail;
    }

    /**
     * Getters for each Variable
     *
     * @param      No parameters
     * @return    the contents of the variable
     */
    public String getID()
    { 
        return ID;
    }
    
    public String getTitle()
    { 
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getGenre()
    {
        return genre;
    }

    public Double getCost()
    {
        return cost;
    }
    
    public boolean getAvail()
    {
        return avail;
    }
    
    
    
    /**
     * Setters for each Variable
     *
     * @param     Same type as the appropriate variable
     * @return    Nothing
     */
    public void setID(String ID)
    { 
        this.ID = ID;
    }
    
    public void setTitle(String title)
    { 
        this.title = title;
    }

    public void setAuthor(String author)
    { 
        this.author = author;
    }  

    public void setGenre(String genre)
    { 
        if(genre.length() <=40)
        {
            this.genre = genre;
        }
        else
        {   
            this.genre = genre.substring(0,40);
        }
    }

    public void setCost(Double cost)
    { 
            this.cost = cost;
    }  
    
    public void setAvail(boolean avail)
    { 
        this.avail = avail;
    }  
    
    
    
    /**
     * Status, transalates the availability into english
     *
     * @param      No parameters
     * @return     String describing the availablility in words
     */
    public String status()
    {
        if (avail == false)
        {
            return "Unavailable";
        }
        else
        {
            return "Available";
        }
    }
    
    
    
    public String toString()
    {
        return 
            " ID: " + ID
        + " | Title: " + title
        + " | Author: " + author
        + " | Genre: " + genre 
        + " | Cost: €" + cost 
        + " | Availability: " + status() 
        + "\n";
    }
}

