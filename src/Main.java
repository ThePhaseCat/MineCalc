import java.util.Scanner; //for reading keyboard input and Files
import java.io.BufferedReader; //Fast way to read large files and other data streams
import java.io.FileReader; //used when using BufferedReader to read a File
import java.io.BufferedWriter; //Fast way to write large files and other data streams
import java.io.FileWriter; //used when using BufferedWriter to write a File
import java.io.IOException; //Exception that can be thrown by BufferedReader and BufferedWriter
import java.util.ArrayList;


public class Main{

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";

        while (!input.equals("Q")) {
            System.out.println("Welcome to MineCalc!");
            System.out.println("What service would you like to use?");
            System.out.println("1. Area Service");
            System.out.println("2. Structure Service");
            System.out.println("3. Block/Item Index Service");

            input = keyboard.nextLine();
            input = input.toUpperCase();

            if (input.equals("1")){
                Area AreaMenu = new Area();
                while(AreaMenu.revertState == 0){
                    AreaMenu.AreaMenu();
                }
            }
        }
    }


}