
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

 class Create{

    
  String fname  ;
  String lname ;
  String email;
  String userName;
  String adhar ;
  String gender ;
  int MobNo;
  int password;
  String date;
  String address;
  String status;
  String dist ;
  String state;
  String city;
  double balance ;
  int ac ;
        Create()
        {
            ac =100;
        }
}

public class Customer{

    static Scanner sc =  new Scanner(System.in);
    static  String userName = "User123";
    static String Password ="Tiger" ;
     static String[] data =  new  String[12];
    static double balance = 100 ;
    static int  PIN = 1234;
    static Vector<Integer> vPin = new Vector<Integer>() ; 
    static Vector<Integer> miniWithdraw = new Vector<Integer>() ; 
    static Vector<Integer> bal = new Vector<Integer>() ; 
    static Vector<String> time = new Vector<String>() ; 
    static Vector<String> info = new Vector<String>() ; 

   
     
    static    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    static{
        System.out.println("***********************************************"); 
        System.out.println("\t\tWel-Come");
        System.out.println("\t\tStudent Bank");
        System.out.flush();

    }
    
    
    public static boolean login(){

            boolean val=true;
             

                System.out.print("Enter UserName(Email):  ");
                String usr = sc.next();
                System.out.print("Enter Password(mobile NUmber):  ");
                int  pass = sc.nextInt();

                Banking bank =  new Banking();
               // Vector<Create> v = bank.getter();
                
               int val1 = Banking.v.get(0).password;
               String val2 =  Banking.v.get(0).email;
               
               if(usr.equals(val1))
               {
                    System.out.println("Yes");
                }else
                    System.out.println("No");
                
                return val ;
    }
    
      // deposit

   static double deposit()
   {
       System.out.print("Enter Deposit Amount: ");
       double creditAmount =  sc.nextInt();
       balance +=creditAmount;
       return creditAmount;
   }
    
    // withdraw

    static boolean withdraw(){
    System.out.print("Enter withdraw Amount : ");
    int withdraw =sc.nextInt();
    Date date = new Date();

    if(withdraw < (balance))
        { 
            
            balance = balance -withdraw ;
            miniWithdraw.add(withdraw);
            bal.add((int)balance);
            time.add(formatter.format(date));
            return true;
         } else 
       { 
        System.out.println("Insufficient Funds!");
        return false;
       }
       
    }
  
    // mini statement 

        static void miniStatement(int rupay){
           // miniStatement(withdraw);
       Date date = new Date();

            
             System.out.println(formatter.format(date)+"    "+rupay);

        }

        //miniDisplay
      static  void miniDisplay(){
        System.out.println("***********************************************");
        System.out.println("  Date    *  Time   *  WithDrwal  *\tBalance");
        System.out.println("***********************************************");

        for(int i=0;i<miniWithdraw.size();i++)
        {
            System.out.print(time.get(i)+"    \t"+miniWithdraw.get(i)+"RS    \t"+bal.get(i) +"RS");
            System.out.println();
        }

      }


    // Pin 
   static  int pin()
    {   int num =PIN ;
        boolean val =false;
        
      
        do{
        System.out.print("Enter four digit Pin : ");
        num = sc.nextInt();
       
            PIN = num ;
            if(num >999 && num <10000)
            {
                val =true;
               // v.add(num);
                
                for(int i=0;i<vPin.size();i++)
                {
                    if(vPin.get(i) !=num)
                    {
                        continue;
                       // System.out.println("Pin: "+num+ " "+PIN);
                    }else{
                        System.out.println("\tAlready exit !");
                    }
                }
                break;
            }else
                System.out.println("Invalid PIN !");  
      }while (val ==false) ;
             //System.out.println(PIN); 
        return PIN ;

    }
    static int  displayPin()
    {
        for(int i=0;i<vPin.size();i++)
        {
            System.out.println(vPin.get(i));
            // if(v.get(i) != num)
            // {
                
            //     continue;

            // }else{
            //     System.out.println("Already used please enter valid PIN ");
            //     val=false;
            //     break;
            // }
        }
        return vPin.size();
    }

    // main
     /**
     * @param args
     */
    public static void main(String[] args) {
        vPin.add(PIN);
        while(true){
        System.out.println("***********************************************");
        System.out.println("1.Login");
        System.out.println("2.Create Account");
        System.out.println("3.Exit");
        System.out.print("Enter your choice:  ");
        int choice;
        choice =  sc.nextInt();
        //System.out.println("*******************************");

        switch(choice)
        {
            case 1:
            {
               boolean ans;

              
                
                ans = login();
               
                   char var;
                    
                   while(ans) {
                    System.out.println("************************************************************\n");
                   // System.out.println("Please select your Choice:");
                    System.out.println("1.Cash Witthdrawal");
                    System.out.println("2.Balance Enquiry");
                    System.out.println("3.Deposit Amount");
                    System.out.println("4.Mini Statement");
                    System.out.println("5.Change ATM pin");
                    System.out.println("6.Pin display");
                    System.out.println("7.Exit");
                    System.out.print("\nEnter your choice:");
                    int ch = sc.nextInt();
                    System.out.println();
                    switch(ch)
                    {
                        case 1:
                            {
                               boolean ret = withdraw();
                               if(ret==true)
                               {
                                System.out.println("\n\tPlease Collect your Amount.....\n");
                               }else{
                                System.out.println("Transaction Failed !");
                               }

                            }
                         break;

            
                        case 2:
                         {
                             
                             System.out.println("Available Balance: "+balance+" RS");
                             break;
                      
                         }
            
            
                        case 3: System.out.println("Successfully Deposited Amount : " + deposit()+" RS");
                            break;

                        case 4: miniDisplay();
                             break;
                        case 5:
                    
                                int changePin= pin();
                                vPin.add(changePin);
                                System.out.println("Successfully changed...\n");
                                 break;
                        case 6:
                                 int no= displayPin();
                                 System.out.println("Dipslayed............"+no);
                                break;
                        case 7:
                                 break;
                               // System.exit(0);
        
                    }       // inside switch end                
            }               // inside while end
        }       //case 1 end
        case 2:{
           Banking bank =  new Banking();
          Vector<Create> ret =  bank .openAccount();
            bank.display(ret);
                   
                if(ret!=null)
                {   System.out.println("your account is Created Succesfully....\n Thank you!");   
                
                }else
                    System.out.println("Null");
                }  
                 break; 
            case 3: 
            System.exit(0);

            System.out.println("*******************************************************");
    
        }
    }
}
}




/**
 * @return
 */


 class Banking {

 public static  Vector<Create> v = new Vector<Create>();

  public Vector<Create> getter( ){

    return v;
  }
public Vector<Create> setter(){
  
  return v;
}

 /**
 * @return
 */
public Vector<Create>  openAccount()
 {
   // object for customer
     int ch;
     Scanner sc =  new Scanner(System.in);
     Create s =  new Create();
 
     do{
    Create c =  new Create();
     
   System.out.println("***********************************************"); 
    System.out.println("Enter your First Name:");
    c.fname = sc.next();
    System.out.println("Enter your Last Name:");
     c. lname = sc.next();
     System.out.print("Enter your Mobile:");
     c.MobNo =sc.nextInt();
    System.out.println("Enter your Adhar Number:");
    c.adhar =sc.next();
   System.out.print("Enter your Email:");
   c.email =sc.next();
//     System.out.println("Enter your Birth date (DD/MM/YYY):");
//     c.date =sc.next();
//     System.out.println("Enter your Gender:");
//     c.gender =sc.next();
//     System.out.println("Enter your Maaried status(Y):");
//     c.status =sc.next();
//     System.out.println("Enter your Address:");
//     c.address =sc.next();
//     System.out.println("Enter your State:");
//     c.state =sc.next();
//     System.out.println("Enter your Distric:");
//     c.dist =sc.next();
//     System.out.println("Enter your city:");
//     c.city =sc.next();
   System.out.println("Enter Deposit Amount in account:");
   c.balance = c.balance + sc.nextInt();
   //user and password
       c.userName =c.email;
       c.password=c.MobNo;
   // acount generated automatically
   c.ac = c.ac + v.size()+1;    //100+5+1=106
   // 
   System.out.println("***********************************************"); 
   System.out.println("1.Submit");
   System.out.println("2.reset");
   System.out.print("Enter your choice:");
   ch = sc.nextInt();
     s=c;
    }while(ch==2);
     v.add(s);
    System.out.println("\n**Size:"+v.size());
 
     return v;
 }

public  static void display(Vector<Create> info)
  {
    int ac =101;
    for(int i=0 ;i<info.size();i++)
      {
          
          System.out.println(info.size());
          System.out.println("**********Account Details*************");
          System.out.println(" Account Number :"+info.get(i).ac);
          System.out.println(" balance :"+info.get(i).balance+" RS");
          System.out.println(" UserName :"+info.get(i).userName);
          System.out.println(" Password :"+info.get(i).password);
          System.out.println(" First Name :"+info.get(i).fname);
          System.out.println(" Last Name :"+info.get(i).lname);
          System.out.println(" Email :"+info.get(i).email);
          System.out.println(" Adhar :"+info.get(i).adhar);
          System.out.println(" Gender :"+info.get(i).gender);
          System.out.println(" Mobile Number :"+info.get(i).MobNo);
          System.out.println(" Birth Date :"+info.get(i).date);
          System.out.println(" Address :"+info.get(i).address);
          System.out.println(" Married Status :"+info.get(i).status);
          System.out.println(" Dist :"+info.get(i).dist);
          System.out.println(" State :"+info.get(i).state);
          System.out.println(" City :"+info.get(i).city);
          System.out.println("************************************************************\n");
        }
} 
  // toatal accoounts


}
