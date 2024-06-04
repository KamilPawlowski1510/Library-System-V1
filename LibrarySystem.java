
/**
 * This is the Library System class, containing the main() method and will be the front end user interface
 *
 * @author Kamil Pawlowski
 * @version 1
 */

import java.util.ArrayList;
//This is used to make delays in the code where necessary
import java.util.concurrent.TimeUnit;
public class LibrarySystem
{
    
    //Create an object libraryWF from the Library Class
    private Library libraryWF = new Library();  
    
    //Constructor
    public LibrarySystem()
    {
    }
    
    //main method, creates and runs library system
    public static void main(String[] args)
    {
        LibrarySystem ls1 = new LibrarySystem();
        ls1.run();
    }

    /**
     * mainMenu() - This method displays the menu for the application,
     * reads the menu option that the user entered and returns it.
     *
     * @return     the users menu choice
     */
    public int mainMenu()
    {

        System.out.println("Library Menu\n");
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease enter choice [0-2]: ");

        System.out.println("1. Patron Menu");
        System.out.println("2. Book Menu");
        System.out.println("0. Quit");
        

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;
    }

    /**
     * run() - This method displays the menu and processes the user's menu
     * choice.  Option ‘0’ exits the program.
     */

    public void run()
    {
        //load sequence, done once initially
        try{
                libraryWF.loadPatron();
                libraryWF.loadBook();
                System.out.println("Loaded all files succesfully");
            }
        catch (Exception e)
            { 
                System.out.println("Error reading from file: " + e);
             }   
        try 
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException ie) 
            {
                Thread.currentThread().interrupt();
            }
        System.out.print('\u000C');
        
        
        int option = mainMenu();
        while(option !=0)
        {
            switch (option)
            {
                case 1: 
                    runPatron();
                    break;
                case 2:
                    runBook();
                    break;
                
                default : 
                    System.out.println("Invalid option selected");
            }
            option = mainMenu();
        }
    } 
    
    /**
     * patronMenu() - This method displays the menu for the runPatron() method. It's 
     * used to show the user their options and store their choice.
     *
     * @return     the users menu choice
     */
    public int patronMenu()
    {
        System.out.println("Library Menu > Patron Menu\n");
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease enter choice [0-7]: ");

        System.out.println("1. List all Patrons");
        System.out.println("2. Number of Patrons");
        System.out.println("3. List Patron details by name");
        System.out.println("4. See Patron's borrowed books");
        System.out.println("5. Update Patron details");
        System.out.println("6. Add a Patron");
        System.out.println("7. Remove a Patron");
        System.out.println("0. Go Back");
        
        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;

    }
    
    /**
     * runPatron() - This method displays the menu with the Patron options and processes 
     * the user's patronMenu choice.  Option ‘0’ goes back to main menu.
     * 
     */
    public void runPatron()
    {
        int option = patronMenu();
        while(option !=0)
        {
            switch (option)
            {
                case 1:
                    System.out.println(libraryWF.listOfPatrons());
                    break;
                case 2:
                    if(libraryWF.numberOfPatrons() ==1)
                    {
                        System.out.println("There is " + libraryWF.numberOfPatrons() + " patron in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfPatrons() + " patrons in the system.");
                    }
                    break;
                case 3:
                    listOfPatronsByName();
                    break;
                case 4:
                    runBorrowed();
                    break;
                case 5: 
                    updatePatronDetails();
                    break;
                case 6: 
                    createPatron();
                    break;
                
                case 7:
                    deletePatron(); 
                    break;
                
                default : 
                    System.out.println("Invalid option selected");
            }
            System.out.println();
            option = patronMenu();
        }
    } 
    
    /**
     * bookMenu() - This method displays the menu for the runBook() method. It's 
     * used to show the user their options and store their choice.
     *
     * @return     the users menu choice
     */
    public int bookMenu()
    {
        System.out.println("Library Menu > Book Menu\n");
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease Enter choice [0-6]: ");

        System.out.println("1. List all Books");
        System.out.println("2. Number of Books");
        System.out.println("3. List Book Details by Title");
        System.out.println("4. Update Book Details");
        System.out.println("5. Add a Book");
        System.out.println("6. Remove a Book");
        System.out.println("0. Go Back");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;

    }
    
    /**
     * runBook() - This method displays the menu with the Book options and processes 
     * the user's bookMenu choice.  Option ‘0’ goes back to main menu.
     * 
     */
    public void runBook()
    {
        int option = bookMenu();
        while(option !=0)
        {
            switch (option)
            {
                case 1:
                    System.out.println(libraryWF.listOfBooks());
                    break;
                    
                case 2:
                    if(libraryWF.numberOfBooks() ==1)
                    {
                        System.out.println("There is " + libraryWF.numberOfBooks() + " book in the system.");
                    }
                    else
                    {
                        System.out.println("There are " + libraryWF.numberOfBooks() + " books in the system.");
                    }
                    
                    break; 
                    
                case 3:
                    listOfBooksByTitle();
                    break;
                    
                case 4:
                    updateBookDetails();
                    break;
                    
                case 5: 
                    createBook();
                    break;
                
                case 6:
                    deleteBook(); 
                    break;
 
                default : 
                    System.out.println("Invalid option selected");
            }
            System.out.println();
            option = bookMenu();
        }
    } 
    
    /**
     * borrowedPatronMenu() - This method displays the first menu for the runBorrowed() method. It's 
     * used to let the user select the patron with validation that the choice is appropriate that
     * will be used to determine whose borrowed books are being interacted with.
     *
     * @return     the users menu choice
     */
    public int borrowedPatronMenu()
    {
        System.out.println("Library Menu > Patron Menu > Borrowed Books\n");
        
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(libraryWF.listOfPatrons());
        System.out.print(" \nSelect the index of the Patron whose borrowed books you wish to see: ");
        String choice = EasyScanner.nextString();
        while (!choice.matches("[0-9]+") || Integer.parseInt(choice) >= libraryWF.numberOfPatrons())
        {
            System.out.println(" Please enter a number that's within the arraylist. ");
            choice = EasyScanner.nextString();
        }
        System.out.print('\u000C');
        return Integer.parseInt(choice);
        
    }
    
    /**
     * borrowedMenu() - This method displays the second menu for the runBorrowed() method. It's 
     * used to show the user which Patrons books they're interacting with as well as their options
     * for how they can interact with them.
     *
     * @return     the users menu choice
     */
    public int borrowedMenu(Patron patron)
    {
        System.out.println("Library Menu > Patron Menu > Borrowed Books > "+patron.getName()+"\n");
        
        System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" \nPlease Enter choice [0-2]: ");

        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("0. Go Back");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.print('\u000C');
        return choice;

    }
    
    /**
     * runBorrowed() - This method displays two menus, one to select which Patrons borrowed books 
     * to interact with and another showing how the books can be interacted with, and processes 
     * the user's choices.  Option ‘0’ goes back to Patron menu.
     * 
     */
    public void runBorrowed()
    {
        if (libraryWF.numberOfPatrons() ==0)
        {
            System.out.print("There are no Patrons in the System!");
        }
        else
        {
            int patronI = borrowedPatronMenu();
            Patron patron = libraryWF.getPatron(patronI);
            System.out.println(patron.listOfBorrowed());
            int option = borrowedMenu(patron);
            while(option !=0)
            {
                switch (option)
                {
                    case 1:
                        borrowBook(patron);
                        break;
                    case 2:
                        returnBook(patron);
                        break;
                    default : 
                        System.out.println("Invalid option selected");
                }
                System.out.println();
                option = borrowedMenu(patron);
            }
        }
        
    } 
    
    //Used to borrow a book. It takes in a patron, checks for available books and if there are any shows a list of them. The user selects the index of the book they want to borrow,
    //this index is validated(consists of only digits, isn't bigger than the highest position in the arraylist and checks if the book associated with that index is available), the
    //book of their choice has it's validity changed to unavailable and a copy of it is created in the Patrons borrowed books arraylist. The changes are then saved automatically.
    public void borrowBook(Patron patron)
    {
        if(libraryWF.numberOfAvailBooks()==0)
        {
            System.out.println("There are no available books in the system to borrow!");
        }
        else
        {
            System.out.println("Library Menu > Patron Menu > Borrowed Books > "+patron.getName()+"\n");
            
            System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.print(libraryWF.listAvailableBooks());
            System.out.println(" \nSelect the index of the Book which you'd like to borrow.: ");
            String choice = EasyScanner.nextString();
            
            while (!choice.matches("[0-9]+") || Integer.parseInt(choice) >= libraryWF.numberOfBooks() || libraryWF.getBook(Integer.parseInt(choice)).getAvail() ==false )
            {
                System.out.println(" Please enter the index of an available book. ");
                choice = EasyScanner.nextString();
            }
            Book book =libraryWF.getBook(Integer.parseInt(choice));
            book.setAvail(false);
            patron.addBorrowed(book);
            try
            {
                libraryWF.savePatron();
                libraryWF.saveBook();
                System.out.println("Changes Added to System and Saved:");
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file: " + e);
                System.out.println("Changes Added to System not Saved:");
            }
            try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
            System.out.print('\u000C');
        }
        
    }
    
    //Used to return a book. Takes in a patron and if the patron has any books borrowed asks the patron which book they'd like to return. Has validation to make sure the users
    //choice is a number and isn't greater than the highest index in the arraylist. It uses the selected book to check its ID and searches through the bookList to find a book
    //with the same ID. It changes that books avail to true and removes the copy of the book from the patron's borrow arraylist
    public void returnBook(Patron patron)
    {
        if(patron.numberOfBorrowed()==0)
        {
            System.out.println("There are no books to return!");
        }
        else
        {
            System.out.println("Library Menu > Patron Menu > Borrowed Books > "+patron.getName()+"\n");
        
            System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.print(patron.listOfBorrowed());
            System.out.println(" \nSelect the index of the Book which you'd like to return.: ");
            String choice = EasyScanner.nextString();
            
            while (!choice.matches("[0-9]+") || Integer.parseInt(choice) >= patron.numberOfBorrowed())
            {
                System.out.println(" Please enter the index of a borrowed book. ");
                choice = EasyScanner.nextString();
            }
            Book book =patron.getBorrowed().get(Integer.parseInt(choice));
            libraryWF.returnBook(book.getID());
            patron.removeBorrowed(Integer.parseInt(choice));
            try
            {
                libraryWF.savePatron();
                libraryWF.saveBook();
                System.out.println("Changes Added to System and Saved:");
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file: " + e);
                System.out.println("Changes Added to System not Saved:");
            }
            try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
            System.out.print('\u000C');
        }
        
    }
    
    //Creates a new patron and automatically saves it
    public void createPatron()
    {

        //Declare 6 String Variables
        String ID;
        String name;
        String email;
        String phoneNo;
        String address;
        ArrayList<Book> borrowed= new ArrayList<Book>();
        
        //Input and assign values for 5 variables
        System.out.print("Enter Patron ID: ");
        ID = EasyScanner.nextString();

        System.out.print("Enter Patron Name ");
        name = EasyScanner.nextString();
        while(name.length() >40)
        {
            System.out.print("Try again - A patrons name can have a maximum of 40 characters   : ");
            name = EasyScanner.nextString();

        }

        System.out.print("Enter Patron Email: ");
        email = EasyScanner.nextString();
        while(!(email.contains("@") && email.contains(".")))
        {
            System.out.print("Try again - Email must have an @ and a .   : ");
            email = EasyScanner.nextString();

        }
        
        System.out.print("Enter Patron Phone Number: ");
        phoneNo = EasyScanner.nextString();
        
        System.out.print("Enter Patron Address: ");
        address = EasyScanner.nextString();

        //Use these 6 values, stored in the variables, to create and construct patron1 object
        Patron patron1 = new Patron(ID, name, email, phoneNo, address, borrowed);
        libraryWF.addPatron(patron1);
        try
        {
            libraryWF.savePatron();
            System.out.println("Patron Added to System and Saved:");
        }
        catch (Exception e)
        {
            System.out.println("Error writing to file: " + e);
            System.out.println("Patron Added to System not Saved:");
        } 
        try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
        System.out.print('\u000C');
    }
    
    //creates a new book and automatically saves it
    public void createBook()
    {

        //Declare 6 String Variables
        String ID;
        String title;
        String author;
        String genre;
        Double cost;
        boolean avail = true;
        
        //Input and assign values for 5 variables, there is a default value for the sixth
        System.out.print("Enter a 7 digit Book ID: ");
        ID = EasyScanner.nextString();
        while (!libraryWF.validifyBookID(ID) || !ID.matches("[0-9]+") || !(ID.length() == 7))
        {
            System.out.print("Invalid ID, Please Enter a Unique, 7 Digit ID: ");
            ID = EasyScanner.nextString();
        }
        
        
        System.out.print("Enter Book Title: ");
        title = EasyScanner.nextString();

        System.out.print("Enter Book Author: ");
        author = EasyScanner.nextString();

        System.out.print("Enter Book Genre: ");
        genre = EasyScanner.nextString();
        while(genre.length() >40)
        {
            System.out.print("Try again - A books genre can have a maximum of 40 characters   : ");
            genre = EasyScanner.nextString();

        }
        
        System.out.print("Enter Book Cost:€ ");
        cost = EasyScanner.nextDouble();

        //Use these 5 values, stored in the variables, to create and construct book1 object
        Book book1 = new Book(ID, title, author, genre, cost, avail);
        libraryWF.addBook(book1);
        try
        {
            libraryWF.saveBook();
            System.out.println("Book Added to System and Saved:");
        }
        catch (Exception e)
        {
            System.out.println("Error writing to file: " + e);
            System.out.println("Book Added to System not Saved:");
        }    
        try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
        System.out.print('\u000C');
    }
    
    //Deletes a selected Patron. Stops if there aren't any patrons to be deleted or if the user 
    //attempts to delete a Patron that is currenlty borrowing a book. Saves automatically afterwards.
    public void deletePatron()
    {
        if(libraryWF.numberOfPatrons() ==0)
        {
            System.out.println("There are no patrons in the system to be removed!  ");
        }
        else
        {
            System.out.println("Waterford Library Patron List: " + "\n" + libraryWF.listOfPatrons());
            System.out.println("______________________________");
            System.out.println("Enter the Index of the Patron you wish to delete from the system:  ");
            int index = EasyScanner.nextInt();
            if (!(libraryWF.getPatron(index).numberOfBorrowed() ==0))
            {
                System.out.println("The Patron you have selected cannot be removed as they are currently borrowing books.");
            }
            else
            {
                libraryWF.removePatron(index);
                try
                {
                    libraryWF.savePatron();
                    System.out.println("Patron Removed from System and Saved:");
                }
                catch (Exception e)
                {
                    System.out.println("Error writing to file: " + e);
                    System.out.println("Patron Removed from System not Saved:");
                }    
                try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
                System.out.print('\u000C');
            }
        }
    }
    
    //Deletes a selected Book. Stops if there aren't any books to be deleted or if the user 
    //attempts to delete a Book that is currenlty borrowed. Saves automatically afterwards.
    public void deleteBook()
    {
        if(libraryWF.numberOfBooks() ==0)
        {
            System.out.println("There are no books in the system to be removed!  ");
        }
        else
        {
            System.out.println("Waterford Library Book List: " + "\n" + libraryWF.listOfBooks());
            System.out.println("______________________________");
            System.out.println("Enter the Index of the Book you wish to delete from the system:  ");
            int index = EasyScanner.nextInt();
            if (libraryWF.getBook(index).getAvail() ==false)
            {
                System.out.println("The Book you have selected cannot be removed as it is currently borrowed.");
            }
            else
            {
                libraryWF.removeBook(index);
                try
                {
                    libraryWF.saveBook();
                    System.out.println("Book Removed from System and Saved:");
                }
                catch (Exception e)
                {
                    System.out.println("Error writing to file: " + e);
                    System.out.println("Book Removed from System not Saved:");
                } 
            }
            try 
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException ie) 
            {
                Thread.currentThread().interrupt();
            }
            System.out.print('\u000C');
        }
    }
    
    //makes a list of every patron that has the entered name
    public void listOfPatronsByName()
    {

        System.out.print("Enter Patron Name: ");
        String name = EasyScanner.nextString();
        System.out.println(libraryWF.searchPatronByName(name));

    }
    
    //makes a list of every book that has the entered title
    public void listOfBooksByTitle()
    {

        System.out.println("Enter Book Title: ");
        String title = EasyScanner.nextString();
        System.out.println(libraryWF.searchBookByTitle(title));

    }
    
    //Updates a selected Book. Stops early if there aren't any books to choose from or if the book selected is currently borrowed. Has validation and saves automatically.
    public void updateBookDetails()
    {
        if(libraryWF.numberOfBooks() ==0)
        {
            System.out.println("There are no books in the system to be updated!  ");
        }
        else
        {
            System.out.println("Waterford Library Book List: " + "\n" + libraryWF.listOfBooks());
            
            System.out.println("Please enter the index of the Book you wish to Update: ");
            int index = EasyScanner.nextInt();
            Book b = libraryWF.getBook(index);
            
            if (b.getAvail() == false)
            {
                System.out.println("The Book you have selected cannot be updated as it is currently borrowed. ");
            }
            else
            {
                //Input and assign values for 5 variables
                System.out.println("\tWhich of the following do you wish to edit:");
                System.out.println("\t1. Book ID");
                System.out.println("\t2. Book Title");
                System.out.println("\t3. Book Author");
                System.out.println("\t4. Book Genre");
                System.out.println("\t5. Book Cost");
                System.out.println("\t0. Save and Exit");
                int option = EasyScanner.nextInt();
                while(option!=0)
                {
                    switch(option)
                    {
                        case 1:
                            System.out.print("Enter a 7 digit Book ID: ");
                            String bookID = EasyScanner.nextString();
                            while (!libraryWF.validifyBookID(bookID) || !bookID.matches("[0-9]+") || !(bookID.length() == 7))
                            {
                                System.out.print("Invalid ID, Please Enter a Unique, 7 Digit ID: ");
                                bookID = EasyScanner.nextString();
                            }
                            b.setTitle(bookID);
                            break;
                        case 2:
                            System.out.print("Enter Book Title: ");
                            String bookTitle = EasyScanner.nextString();
                            b.setTitle(bookTitle);
                            break;
                        case 3:
                            System.out.print("Enter Book Author: ");
                            String bookAuthor = EasyScanner.nextString();
                            b.setAuthor(bookAuthor);
                            break;
                        case 4:
                            System.out.print("Enter Book Genre: ");
                            String bookGenre = EasyScanner.nextString();
                            while(bookGenre.length() >40)
                            {
                                System.out.print("Try again - A books genre can have a maximum of 40 characters   : ");
                                bookGenre = EasyScanner.nextString();
                            }
                            b.setGenre(bookGenre);
                            break;
                        case 5:
                            System.out.print("Enter Book Cost: €");
                            Double bookCost = EasyScanner.nextDouble();
                            b.setCost(bookCost);
                            break;
                
                        default:
                            System.out.println("Invalid Option");

                    }
                    System.out.println("\tWhich of the following do you wish to edit:");
                    System.out.println("\t1. Book ID");
                    System.out.println("\t2. Book Title");
                    System.out.println("\t3. Book Author");
                    System.out.println("\t4. Book Genre");
                    System.out.println("\t5. Book Cost");
                    System.out.println("\t0. Save and Exit");
                    option = EasyScanner.nextInt();

                }
        
                try
                {
                    libraryWF.saveBook();
                    System.out.println("Details Updated and Saved:");
                }
                catch (Exception e)
                {
                    System.out.println("Error writing to file: " + e);
                    System.out.println("Details Updated not Saved:");
                }
        
                System.out.println(b);
            }
            try 
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException ie) 
            {
                Thread.currentThread().interrupt();
            }
            System.out.print('\u000C');
        }
    }

    //Updates a selected Patron. Stops early if there aren't any patrons to choose from or if the patron selected is currently borrowing a book. Has validation and saves automatically.
    public void updatePatronDetails()
    {
        if(libraryWF.numberOfPatrons() ==0)
        {
            System.out.println("There are no patrons in the system to be updated!  ");
        }
        else
        {
            System.out.println("Waterford Library Patron List: " + "\n" + libraryWF.listOfPatrons());

            System.out.print("Please enter the index of the Patron you wish to Update: ");
            int index = EasyScanner.nextInt();

            Patron p = libraryWF.getPatron(index);

            //Input and assign values for 5 variables
            System.out.println("\tWhich of the following do you wish to edit:");
            System.out.println("\t1. Patron ID");
            System.out.println("\t2. Patron Name");
            System.out.println("\t3. Patron Email");
            System.out.println("\t4. Patron Phone Number");
            System.out.println("\t5. Patron Address");
            System.out.println("\t0. Save and Exit");
            int option = EasyScanner.nextInt();
            while(option!=0)
            {
                switch(option)
                {
                    case 1:
                        System.out.print("Enter Patron ID: ");
                        String patronID = EasyScanner.nextString();
                        p.setID(patronID);
                        break;
                    case 2:
                        System.out.print("Enter Patron Name: ");
                        String patronName = EasyScanner.nextString();
                        while(patronName.length() >40)
                        {
                            System.out.print("Try again - A patron's name can have a maximum of 40 characters   : ");
                            patronName = EasyScanner.nextString();

                        }
                        p.setName(patronName);
                        break;
                    case 3:
                        System.out.print("Enter Patron Email: ");
                        String patronEmail = EasyScanner.nextString();
                        while(!(patronEmail.contains("@") && patronEmail.contains(".")))
                        {
                            System.out.print("Try again - Email must have an @ and a .   : ");
                            patronEmail = EasyScanner.nextString();

                        }
                        p.setEmail(patronEmail);
                        break;
                    case 4:
                        System.out.print("Enter Patron Phone Number: ");
                        String patronPhoneNo = EasyScanner.nextString();
                        p.setPhoneNo(patronPhoneNo);
                        break;
                    case 5:        
                        System.out.print("Enter Patron Address: ");
                        String patronAddress = EasyScanner.nextString();
                        p.setAddress(patronAddress);
                        break;
                    default:
                        System.out.println("Invalid Option");

                }
            
            
            
                System.out.println("\tWhich of the following do you wish to edit:");
                System.out.println("\t1. Patron ID");
                System.out.println("\t2. Patron Name");
                System.out.println("\t3. Patron Email");
                System.out.println("\t4. Patron Phone Number");
                System.out.println("\t5. Patron Address");
                System.out.println("\t0. Save and Exit");
                option = EasyScanner.nextInt();

            }
        
            try
            {
                libraryWF.savePatron();
                System.out.println("Details Updated and Saved:");
            }
            catch (Exception e)
            {
                System.out.println("Error writing to file: " + e);
                System.out.println("Details Updated not Saved:");
            }
        
            System.out.println(p);
            try 
                {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException ie) 
                {
                    Thread.currentThread().interrupt();
                }
            System.out.print('\u000C');
        }
    }
}
