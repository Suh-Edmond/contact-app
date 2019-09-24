//package declaration
package contactapp;

//class declaration

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactApp {

 
    //main method declaration
    public static void main(String[] args) throws FileNotFoundException {
      
     //  declaring an input Object
    Scanner input = new Scanner(System.in);
    ContactDetails contact = new ContactDetails();//   declaring an object of class contactDetails
    ContactFile file = new ContactFile();//declaring an object of class contactFile
    boolean valChoice;
    contact.help();//call to methos help
//    validate users choice
    do{
        valChoice = file.chooseAction();
    }while(valChoice == false);

    }//end of  main method
    
}//end of class contactApplication
