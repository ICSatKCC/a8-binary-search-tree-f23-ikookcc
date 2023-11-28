import java.util.Scanner;
/**
 * FishBox Driver.
 * @author Adam Bell and Koo In Mo
 * @since 11/26/2023
 */

public class FishBox {
    
    public static void main(String args[]) {

        Scanner userIn = new Scanner(System.in);
        boolean endLoop = false;
        System.out.println("Welcome to the FishBox Binary Search Tree Driver.");

        while (!endLoop) {
            System.out.println("What would you like to do?\n");
            System.out.println("1. Add a fish.");
            System.out.println("2. Release a fish.");
            System.out.println("3. Print FishBox Tree.");
            System.out.println("0. Exit program.");
            String menuChoice = userIn.nextLine();

            switch (menuChoice) {
                case "1": 
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    endLoop = true;
                    break;
            }
        userIn.close();
        }
    }

}
