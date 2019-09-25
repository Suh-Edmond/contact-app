//package declaration
package contactapp;

//import statements
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.FormatterClosedException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//class declaration
public class ContactFile {
    
//instance variables declaration
    static PrintWriter writer;
    static ContactDetails newContact;
    Scanner input;
    static File file;
    static BufferedReader buffer;

    
//  constructor
    @SuppressWarnings("Convert2Diamond")
    public ContactFile() throws FileNotFoundException{
        newContact = new ContactDetails();//intialising an object from class ContactDetails
    }//end of constructor

    
// method create file
public static File createFile(){
        file = new File("Contact File.txt");
        if(file.exists() == false){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
         
        return file;
}//end of method createFile


//method add contact
    @SuppressWarnings("Convert2Diamond")
    public static  boolean addContact() throws IOException{
    ContactDetails con ;
    boolean confirmMessage = false;
    file = createFile();//call to method createFile
    writer = new PrintWriter(new FileWriter(file, true)); //initialising printWriter object                
    try{
//      call to method getContactInfo
        con = newContact.getContactInfo();
        writer.format("%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t   %s", con.getFirstName(),  con.getLastName(),con.getTelephoneNumber()
                ,con.getUserEmail(), con.getAddress());//writing to file 
               confirmMessage = true;
               writer.format("%n");
        }
        catch(FormatterClosedException ex){
        System.err.println(ex);
       }
    writer.close();//call to method close file
    return confirmMessage;
}//end of method addContact

    
    
//method chooseAction
    @SuppressWarnings("UnusedAssignment")
    public Boolean chooseAction(){
        input  = new Scanner(System.in);
        boolean start = true;
        boolean valChoice = false;
        boolean message;
        String fName;
        try{
            //starts the program
            while(start != false){
                System.out.print("\nMake a Choice: ");
                int choice = input.nextInt();
                String lName;
                //switch statement for different actions
                switch(choice){
                    //call method to add a contact
                    
                    case 1:
                        try {
                            message = addContact();//call to method addContact 
                            if(message == true){
                                System.out.print("\nSuccessfully Saved Contact\n");
                            }else{
                                System.out.print("Contact not Successfully Saved");
                            }
                            valChoice = true;
                        } catch (IOException ex) {
                            Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
                        }//end of catch block//end of catch block
                        break;
                        
                    //call method to update a contact
                    case 2:
                        System.out.print("Module not yet created\n");
                        break;
                        
                    //call methodto delete a contact
                    case 3:
//                        System.out.print("Enter First Name : ");
//                        fName = input.next();
//                        System.out.print("Enter Last Name : ");
//                        lName = input.next();
//                        DeleteContact(fName, lName);
                        System.out.print("Module not yet created\n");
                        break;
                        
                    //call method to read file content 
                    case 4:
                        readFile();//call to method readFile
                        valChoice = true;
                        break;
                        
                    //call method to count saved contacts
                    case 5:
                        countContact();//call to meethod countContacts;
                        valChoice = true;
                        break;
                    
                    //call method to Search for contact
                    case 6:
                        System.out.print("Enter First Name of Searched Contact : ");
                        fName = input.next();
                        findContact(fName);
                        break;
                        
                    //call method to exitapp a contact
                    case 0:
                        exitApp();//call to method exit App
                        valChoice = true;
                        break;
                        
                    // call method to Invalid Input
                    default:
                        System.out.println("Entered choice is Invalid");
                }//end of switch statement
            }//end of while loop
        }catch(InputMismatchException e){
            System.out.print("Invalid Input Please try again: ");
            valChoice = false;
        }
        return valChoice;
}//end of method chooseAction   

    
//method exit app
public static void exitApp(){
    System.exit(0);
} //end of method exit App


//method read file contain
public static  void readFile(){
   buffer = null;
   String line;
   try{
      buffer = new BufferedReader(new FileReader("Contact File.txt"));//initialising buffer
      System.out.printf("%s\t\t%s\t\t%s\t\t\t%s\t\t\t     %s%n", "First Name", "Last Name", "Telephone", "Email", "Address");
      System.out.printf("--------------------------------------------------------------"
        + "----------------------------------------------------------------------%n"); 
      while((line = buffer.readLine()) != null){ 
        System.out.println(line);//print out content of file by after line
        System.out.printf("--------------------------------------------------------------"
        + "----------------------------------------------------------------------%n");  
      }
   }catch(IOException e){
       System.out.printf("Fail to Read File Content\n", e);
   }finally{
       try {
           buffer.close();//call to method close file
       } catch (IOException ex) {
           Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
       }//end of catch block//end of catch block
   }//end of finally block
}//end of method readFile
 


//Count Number of Save contacts
public static void countContact(){
    //declaration of LineNumberReader object
    LineNumberReader reader = null;
    int counter = 0;
        try {
            reader = new LineNumberReader(new FileReader("Contact File.txt")); //initialise LineNumberReader object
            while((reader.readLine()) != null){
                    counter = reader.getLineNumber();//get number of lines in file
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(reader != null){
                try {
                    reader.close();//call to method close file
                } catch (IOException ex) {
                    Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }//end of finally block
        System.out.printf("%nNumber of Saved Contacts = %d%n", counter);//print number of lines
}//end  of method count savedcontacts



    
//method getUpdate info
//public static  void updateContact(String fName, String lName){
//   buffer = null;
//   String line;
//   String nameOfReplaceContact = fName + lName;
//   String lowerCaseName = nameOfReplaceContact.toLowerCase();//setting input string to lowercase
//   try{
//      buffer = new BufferedReader(new FileReader("Contact File.txt"));//initialise buffer object
//      System.out.printf("%s\t\t%s\t\t%s\t\t\t%s\t\t\t\t\t%s\n", "First Name", "Last Name", "Telephone", "Email", "Address");
//      System.out.printf("--------------------------------------------------------------"
//        + "----------------------------------------------------------------------\n");
//      while((line = buffer.readLine()) != null){ 
//          String toLowerCase = line.toLowerCase();
//            if(toLowerCase.contains(lowerCaseName)){ //check if input match any string in line from file
//              String replaceAll = toLowerCase.replaceAll("673660071", "682887714");
//              System.out.println(toLowerCase);
//                 
//            }//end of switch statement
//      }//end of while loop
//       
//   }catch(IOException e){
//       System.out.printf("Fail to Update  Contact\n", e);
//        
//   }finally{
//       try {
//           buffer.close();
//       } catch (IOException ex) {
//           Logger.getLogger(ContactFile1.class.getName()).log(Level.SEVERE, null, ex);
//       }//end of catch block//end of catch block
//   }//end of finally block
//}//end of method updateContact

    
//method  delete contact
    @SuppressWarnings({"Convert2Diamond", "UnnecessaryContinue"})
//    public static void DeleteContact(String fName, String lName){
//       File temp = new File("tempFile.txt");
//       PrintWriter pw;
//       String currentLine;
//       String contactName = fName + lName;
//        
//             
//       try {
//             
//           pw = new PrintWriter(new FileWriter(temp, true));
//           buffer = new BufferedReader(new FileReader("Contact File.txt"));
//           while((currentLine = buffer.readLine()) != null){
//               String toLowerCase = currentLine.toLowerCase();
//               if(toLowerCase.contains(contactName.toLowerCase())){
//                   continue;
//               }else{
//                  pw.format("%s", currentLine);
//               }
//           }
//             
//  
//       } catch (IOException ex) {
//            Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
//       }
//        
// 
//    }//end method  delete contact

//method findcontact
public static  void findContact(String fName){
   buffer = null;
   String line;
   String fNameLowerCase = fName.toLowerCase();//setting input string to lowercase
   try{
      buffer = new BufferedReader(new FileReader("Contact File.txt"));//initialise buffer object
      System.out.printf("%s\t\t%s\t\t%s\t\t\t%s\t\t\t\t\t%s\t\t\t%n", "First Name", "Last Name", "Telephone", "Email", "Address");
      System.out.printf("--------------------------------------------------------------"
        + "----------------------------------------------------------------------%n");
      while((line = buffer.readLine()) != null){ 
          String toLowerCase = line.toLowerCase();
            if(toLowerCase.contains(fNameLowerCase)){//check if input match any string in line from file
                System.out.println(toLowerCase);
                System.out.printf("--------------------------------------------------------------"
                + "----------------------------------------------------------------------%n");
                 
            }//end of switch statement
      }//end of while loop
       
   }catch(IOException e){
       System.out.printf("Fail to Find Contact\n", e);
        
   }finally{
       try {
           buffer.close();
       } catch (IOException ex) {
           Logger.getLogger(ContactFile.class.getName()).log(Level.SEVERE, null, ex);
       }//end of catch block//end of catch block
   }//end of finally block
}//end of method findContact



 













}//end of class
 