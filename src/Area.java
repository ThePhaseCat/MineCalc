import java.util.Scanner; //for reading keyboard input and Files
import java.io.BufferedReader; //Fast way to read large files and other data streams
import java.io.FileReader; //used when using BufferedReader to read a File
import java.io.BufferedWriter; //Fast way to write large files and other data streams
import java.io.FileWriter; //used when using BufferedWriter to write a File
import java.io.IOException; //Exception that can be thrown by BufferedReader and BufferedWriter
import java.util.ArrayList;


public class Area{

    static int revertState = 0;

    public static int calArea(int len, int wid, int hei){
        int sum = len * wid * hei;
        return sum;
    }

    public int revert(){
        return revertState;
    }

    public static void AreaMenu(){
        ArrayList<Integer> areaData = new ArrayList<Integer>();
        areaData.add(0);
        areaData.add(0);
        areaData.add(0);
        areaData.add(0);
        Scanner keyboard = new Scanner(System.in);
        String input = "";

        //System.out.println("Welcome to the MineCalc Area Service!");
        System.out.println("1. Change Area Data");
        System.out.println("2. Get Area Data");
        System.out.println("3. Get Estimations from Area Data");
        System.out.println("Q. Return to Main Menu");

        input = keyboard.nextLine();
        input = input.toUpperCase();

        if (input.equals("1")){
            System.out.print("Length of Area: ");
            areaData.set(0, keyboard.nextInt());
            System.out.print("Width of Area: ");
            areaData.set(1, keyboard.nextInt());
            System.out.print("Height of Area: ");
            areaData.set(2, keyboard.nextInt());
            areaData.set(3, calArea(areaData.get(0), areaData.get(1), areaData.get(2)));
            AreaMenu();
        }
        if (input.equals("2")) {
            System.out.println("Length of Area: " + areaData.get(0));
            System.out.println("Width of Area: " + areaData.get(1));
            System.out.println("Height of Area: " + areaData.get(2));
            System.out.println("Area: " + areaData.get(3));
        }
        if (input.equals("3")){
            AreaEstimation area = new AreaEstimation();
            while(area.revertState == 0){
                area.EstimateArea(areaData.get(3));
                //find what 2*2 is
                //find what 3*3 is
            }
        }
        if (input.equals("Q")){
            revertState = 1;
    }
    }


}