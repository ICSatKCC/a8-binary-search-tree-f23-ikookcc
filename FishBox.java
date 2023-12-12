import java.util.Scanner;
/**
 * FishBox Driver.
 * @author Adam Bell and Koo In Mo
 * @since 11/26/2023
 * 
 * Ella Self helped us a lot with debugging jUnit tests in IaNode and IaTree.
 * She also helped us with creating the user interface and we borrowed some
 * of the user interface functionality.
 */

public class FishBox {
    
    /**
    * @param args Not used.
    * main method is the userInterface for creating an IaTree.
    */
   public static void main(String[] args) {
        /** Creating new IaTree object. */
      IaTree tree = new IaTree();
        /** Scanner for user input */
      Scanner userIn = new Scanner(System.in);
        /** While loop boolean */
      boolean endLoop = false;
        /** Boolean to check if any fish have been added to Tree. */
      boolean fishadd = false;
   
      System.out.println("Welcome to the FishBox Binary Search Tree Driver.");
        //main programm loop
      while (!endLoop) {
         System.out.println("What would you like to do?\n");
         System.out.println("1. Add a fish.");
         System.out.println("2. Release a fish.");
         System.out.println("3. Print FishBox Tree.");
         System.out.println("0. Exit program.");
         String menuChoice = userIn.nextLine();
      
            //From Ella Self
         switch (menuChoice) {
            case "0":
                    //Ends the program
               endLoop = true; 
               System.out.println("Exiting program...Goodbye!!!");
               break;
         
            case "1":
               System.out.println("\nAdding a fish...\n");
               I_a fish = makeFish();
               tree.add(fish);
               fishadd = true;
               System.out.println("You have added a fish to your FishBox");
               break;
         
            case "2":
               System.out.println("Releasing a fish...");
               if (!fishadd) {
                  System.out.println("You must first add a fish to the box.");
               } else {
                  I_a fishToRemove = makeFish();
                  try {
                     if (fishToRemove != null) {
                        tree.remove(fishToRemove);
                        System.out.println("A Fish was removed from the box.");
                     }
                  } catch (IaTreeException e) {
                     System.out.println("No Fish Found!");
                     System.out.println("Please try again with another option.");
                  }
               }
               break;
         
            case "3":
               System.out.println("Printing FishBox...");
               if (!fishadd) {
                  System.out.println("Please add fish to the tank first.");
               } else {
                  tree.printIaTree();
               }
               break;
         
            default:
               System.out.println("Invalid input");
               System.out.println("Please try again.");
               break;
         }
      }
   }

   /**
    * MakeFish() method.
    * Gives a user an option of different
    * types of fish. This method is used
    * for both add and remove methods.
    * @return A I_a object.
    */
   public static I_a makeFish() {
   
      Scanner userIn = new Scanner(System.in);
      boolean userFish = false;
      I_a ia = null; // Create ia object to be assigned within switch statement.
        
      while (!userFish) {
         System.out.println("Please select your type of I'a:\n");
         System.out.println("1. Pua'ama");
         System.out.println("2. Kahaha");
         System.out.println("3. Ama'ama");
         System.out.println("4. Anae");
         System.out.println("5. Oama");
         System.out.println("6. Ohua");
         System.out.println("7. Weke a");
         System.out.println("8. Weke ula");
         System.out.println("9. MoiLi'i");
         System.out.println("10. Moi Mana");
         System.out.println("11. Pala Moi");
         System.out.println("12. Moi");
         System.out.println("13. Panuhunuhu");
         System.out.println("14. Uhu\n");
            
      
      
      
         String fishType = userIn.nextLine(); // User Input
         System.out.print("\nInput: ");
      
      
      /**
       * Switch statement for menu options.
       * Assigns Object to ia using subclass constructors.
       * Taken from Assignment 4
       * @param fishType is user input.
       */
         switch(fishType) {
            case "1": 
               ia = new Pua_ama();
               System.out.println("\nYou chose Pua'Ama\n");
               userFish = true;
               break;
         
            case "2": 
               ia = new Kahaha();
               System.out.println("\nYou chose Kahaha\n");
               userFish = true;
               break;
         
            case "3": 
               ia = new Ama_ama();
               System.out.println("\nYou chose 'Ama'ama\n");
               userFish = true;
               break;
         
            case "4": 
               ia = new Anae();
               System.out.println("\nYou chose 'Anae\n");
               userFish = true;
               break;
         
            case "5": 
               ia = new Oama();
               System.out.println("\nYou chose Oama\n");
               userFish = true;
               break;
         
            case "6": 
               ia = new Ohua();
               System.out.println("\nYou chose Ohua\n");
               userFish = true;
               break;
         
            case "7": 
               ia = new Weke_a();
               System.out.println("\nYou chose Weke'a\n");
               userFish = true;
               break;
         
            case "8": 
               ia = new Weke_ula();
               System.out.println("\nYou chose Weke'ula\n");
               userFish = true;
               break;
         
            case "9":
               ia = new MoiLi_i();
               System.out.println("\nYou chose Moi-li'i\n");
               userFish = true;
               break;
         
            case "10": 
               ia = new MoiMana();
               System.out.println("\nYou chose Moi Mana\n");
               userFish = true;
               break;
         
            case "11": 
               ia = new PalaMoi();
               System.out.println("\nYou chose Pala Moi\n");
               userFish = true;
            
               break;
         
            case "12": 
               ia = new Moi();
               System.out.println("\nYou chose Moi\n");
               userFish = true;
               break;
         
            case "13": 
               ia = new Panuhunuhu();
               System.out.println("\nYou chose Panuhunuhu\n");
               userFish = true;
               break;
         
            case "14": 
               ia = new Uhu();
               System.out.println("\nYou chose Uhu\n");
               userFish = true;
               break;
         
            default : 
               System.out.println("\nPlease select a valid entry\n");
               continue;
         
         } // Switch
           
      }
      return ia;
   }
}       
        
   

