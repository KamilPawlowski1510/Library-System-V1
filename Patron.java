
/**
 * Patron Class 
 *
 * @author Kamil Pawlowski
 * @version 1
 */
import java.util.ArrayList;

public class Patron
{
    // variables
    private String ID;
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private ArrayList<Book> borrowed= new ArrayList<Book>(); 
    /**
     * Constructor for objects of class Patron
     */

    public Patron(String ID, String name, String email, String phoneNo, String address, ArrayList<Book> borrowed)
    {
        this.ID = ID;
        if(name.length() <=40)
        {
            this.name = name;
        }
        else
        {   
            this.name = name.substring(0,40);
        }
        if(email.contains("@") && email.contains("."))
        {
            this.email = email;
        }
        else
        {
            this.email = "invalid email format";
        }
        this.phoneNo = phoneNo;
        this.address = address;
        this.borrowed = borrowed;
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

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }
    
    public String getPhoneNo()
    {
        return phoneNo;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public ArrayList<Book> getBorrowed()
    {
        return borrowed;
    }
    
    
    
    /**
     * Setters for each Variable
     *
     * @param     String parameter
     * @return    Nothing
     */
    public void setID(String ID)
    { 
        this.ID = ID;
    }

    public void setName(String name)
    { 
       if(name.length() <=40)
        {
            this.name = name;
        }
        else
        {   
            this.name = name.substring(0,40);
        }
    }  

    public void setEmail(String email)
    { 
           if(email.contains("@") && email.contains("."))
        {
            this.email = email;
        }
        else
        {
            this.email = "invalid email format";
        }
    }  
    
    public void setPhoneNo(String phoneNo)
    { 
        this.phoneNo = phoneNo;
    } 
    
    public void setAddress(String address)
    { 
        this.address = address;
    }
    
    public void setBorrowed(ArrayList<Book> borrowed)
    { 
        this.borrowed = borrowed;
    }
    
    /**
     * Borrowed Book Methods
     *
     * Arraylist methods to interact with the borrowed arraylist
     */
    //Add book to arraylist
    public void addBorrowed(Book book1)
    {
        borrowed.add(book1);
    }
    
    //Remove book from arraylist
    public void removeBorrowed(int index)
    {
        borrowed.remove(index);

    }
    
    //Quantity of books in arraylist
    public int numberOfBorrowed()
    {
        return borrowed.size();
    }
    
    //Makes a list of all borrowed books
    public String listOfBorrowed()
    {
        String allBorrowed="Patron has " +numberOfBorrowed()+" Books currently Borrowed\n";
        int index = 0;
        if(borrowed.isEmpty())
        {
            allBorrowed = "The Patron has No Borrowed Books";
        }
        else
        {
            for(Book b: borrowed)
            {
                allBorrowed = allBorrowed + "Index " + index + ":   "+ b + "\n";

                index++;
            }
        }
            return allBorrowed;
    }
    
    public String toString()
    {
        return
            " ID: " + ID 
        + " | Name: " + name 
        + " | Email: " + email 
        + " | Phone Number: " + phoneNo
        + " | Address: " + address 
        + "\n";
    }
}

