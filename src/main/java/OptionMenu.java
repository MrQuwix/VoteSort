import java.util.Scanner;
public class OptionMenu {

    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        // Display the menu
        System.out.println("1\t Java Programming");
        System.out.println("2\t Soft Engineering");
        System.out.println("3\t Requirement Engineering");
        System.out.println("4\t Project Management");

        System.out.println("Please enter your choice:");

        //Get user's choice
        int choice=in.nextInt();

        //Display the title of the chosen module
        switch (choice) {
            case 1: System.out.println("Java Programming");
                break;
            case 2: System.out.println("Soft Engineering");
                break;
            case 3: System.out.println("Req Engineering");
                break;
            case 4: System.out.println("Proj Management");
                break;
            default: System.out.println("Invalid choice");
        }//end of switch
    }//end of the main method
}//end of class
 