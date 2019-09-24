//package declaration
package contactapp;
//import statements
import java.util.InputMismatchException;
import java.util.Scanner;
//class declaration
public class ContactDetails {
    
//    declartion of variable
    String firstName;
    String lastName;
    String telephone;
    String userEmail;
    String  userAddress;
    
//    contructor
    public ContactDetails(){
      firstName = "Admin";
      lastName = "Admin";
      telephone ="111111111";
      userEmail = "something@gmail.com";
      userAddress = "XXXXXXXX";
    }
    
    
    
    
//    contructor
    @SuppressWarnings("OverridableMethodCallInConstructor")
     public ContactDetails(String firstName, String lastName, String telephoneNum, String email, String address){
        setFirstName(firstName);
        setLastName(lastName);
        setTelephoneNumber(telephoneNum);
        setUserEmail(email);
        setAddress(address);
     }//end of contructor

     
     
//    setFirstName method 
    public boolean setFirstName(String firstName) {
        boolean valFirstName = false;
        try{
            if(!firstName.matches("[0-9]*")){
                this.firstName = firstName;
                valFirstName = true;
            }
        }catch(InputMismatchException e){
            System.out.printf("Invalid Input for First Name");
            valFirstName = false;
        }  
        return valFirstName;
 
    }//end of method setFirstName
    
    
    
//    setFirstName method 
    public boolean setLastName(String lastName) {
        boolean valLastName = false;
        try{
            if(!lastName.matches("[0-9]*")){
                this.lastName = lastName;
                valLastName = true;
            }
        }catch(InputMismatchException e){
            System.out.printf("Invalid Input for First Name");
            valLastName = false;
        }  
        return valLastName;
 
    }//end of method setFirstName

    
//    method setTelephone number
    public boolean setTelephoneNumber(String telephoneNumber) {
        boolean checkValue = false;
       String PATTERN = "000000000000";
        if(!telephoneNumber.matches(PATTERN)){
            this.telephone = telephoneNumber;
            checkValue = true;
        }
        return checkValue;
    }//end of method setUserEmai

    
    
//    method setUserEmail
    public boolean setUserEmail(String userEmail) {
        boolean checkValue = false;
        String PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(userEmail.matches(PATTERN)){
            this.userEmail = userEmail;
            checkValue = true;
        }
        return checkValue;   
    }//end of method setUserEmail

    
    
//    method setAddress
    public void setAddress(String address) {
        this.userAddress = address;
    }//end of method setAddress
    
    
//method getFirstName
    public String getFirstName() {
        return firstName;
    }//end of method getFirstName

    
    
//method getLastName
    public String getLastName() {
        return lastName;
    }//end of method getLastName
  
    
    
//method getTelephoneNumber
    public String getTelephoneNumber() {
        return telephone;
    }//end of method getTelephoneNumber

    
    
//method getUserEmail
    public String getUserEmail() {
        return userEmail;
    }//end of method getTelephoneNumber

    
    
//method getAddress    
    public String getAddress() {
        return userAddress;
    }//end of method getAddress   
     
  
    
//method get info for NewContact     
public  ContactDetails  getContactInfo(){
        ContactDetails  contact;
        Scanner input = new Scanner(System.in);
        String fName,lName,telephoneNum,email,address;
        boolean valEmail,valTelephone, valFirstName,valLastName;
        contact = new ContactDetails();
        do{
        System.out.print("Enter First Name : ");
        fName = input.next();
            valFirstName = contact.setFirstName(fName);
        }while(valFirstName == false);
        do{
            System.out.print("Enter Last Name : ");
            lName = input.next();
            valLastName = contact.setLastName(lName);
        }while(valLastName == false);
        do{
            System.out.print("Enter Telephone Number : ");
            telephoneNum = input.next();
            valTelephone = contact.setTelephoneNumber(telephoneNum);
        }while(valTelephone == false);
        do{
            System.out.print("Enter Email Address : ");
            email = input.next();
            valEmail = contact.setUserEmail(email);
        }while(valEmail == false);
        System.out.print("Enter Home Address : ");
        address = input.next();
        contact.setAddress(address);

    return contact;
}//end of method addNewContact
 


//method help on how to use app
public void help(){
    System.out.println("\t\t\tWelcome to Contact Book, Follow the Rules below to use the Appliction\n");
    System.out.println("\t1 - Add A  new Contact");
    System.out.println("\t2 - Update A Contact");
    System.out.println("\t3 - Delete  A Contact");
    System.out.println("\t4 - View  Saved Contacts");
    System.out.println("\t5 - View  Number of Contacts");
    System.out.println("\t6 - Search A  Contact");
    System.out.println("\t0 - Exit Application");
    System.out.println("\tAll Home Addresses are Hypenated\n");
    
}//end of help method
    
    
     
 

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}//end of class declaration

