import javax.swing.*;
import java.awt.*;
import java.util.Scanner; //for reading keyboard input and Files
import java.io.BufferedReader; //Fast way to read large files and other data streams
import java.io.FileReader; //used when using BufferedReader to read a File
import java.io.BufferedWriter; //Fast way to write large files and other data streams
import java.io.FileWriter; //used when using BufferedWriter to write a File
import java.io.IOException; //Exception that can be thrown by BufferedReader and BufferedWriter
import java.util.ArrayList;


public class Main{

    static int length = 0;
    int width = 0;
    int height = 0;
    int area = 0;

    public static void main(String[] args) {
        JFrame mainScreen = new JFrame("MineCalc - Selection Service");
        mainScreen.setLayout(new BoxLayout(mainScreen.getContentPane(), BoxLayout.Y_AXIS));

        JButton areaButton = new JButton("Area Service");
        JButton structureButton = new JButton("Structure Service");
        JButton blockButton = new JButton("Block/Item Index Service");
        areaButton.setBounds(0, 0, 100, 100);
        structureButton.setBounds(0, 0, 100, 100);
        blockButton.setBounds(0, 0, 100, 100);

        areaButton.addActionListener(e -> {
            area();
        });

        mainScreen.add(areaButton);
        mainScreen.add(structureButton);
        mainScreen.add(blockButton);

        mainScreen.setSize(300, 200);
        mainScreen.setVisible(true);
        mainScreen.setLocationRelativeTo(null);
        mainScreen.setLocation(0, 0);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void area(){

        JFrame areaScreen = new JFrame("MineCalc - Area Service");
        areaScreen.setLayout(new BoxLayout(areaScreen.getContentPane(), BoxLayout.Y_AXIS));

        JButton changeDataButton = new JButton("Change Area Data");
        JButton getDataButton = new JButton("Get Area Data");
        JButton getEstimationsButton = new JButton("Get Estimations from Area Data");

        changeDataButton.setBounds(0, 0, 100, 100);
        getDataButton.setBounds(0, 0, 100, 100);
        getEstimationsButton.setBounds(0, 0, 100, 100);

        changeDataButton.addActionListener(e -> {
            areaChangeData();
        });

        getDataButton.addActionListener(e -> {
            areaGetData();
        });

        getEstimationsButton.addActionListener(e -> {
            areaGetEstimations();
        });

        areaScreen.add(changeDataButton);
        areaScreen.add(getDataButton);
        areaScreen.add(getEstimationsButton);

        areaScreen.setSize(300, 200);
        areaScreen.setVisible(true);
        areaScreen.setLocationRelativeTo(null);
        areaScreen.setLocation(200, 200);


    }

    public static void areaChangeData(){

        JFrame areaChangeDataScreen = new JFrame("MineCalc - Area Service - Change Area Data");
        areaChangeDataScreen.setLayout(new BoxLayout(areaChangeDataScreen.getContentPane(), BoxLayout.Y_AXIS));


        JTextField lengthField = new JTextField();
        JTextField widthField = new JTextField();
        JTextField heightField = new JTextField();

        lengthField.addActionListener(e -> {
            length = Integer.parse()lengthField.getText();
        });

        areaChangeDataScreen.add(lengthField);
        areaChangeDataScreen.add(widthField);
        areaChangeDataScreen.add(heightField);

        areaChangeDataScreen.setSize(300, 200);
        areaChangeDataScreen.setVisible(true);
        areaChangeDataScreen.setLocationRelativeTo(null);
        areaChangeDataScreen.setLocation(400, 200);
    }

    public static void areaGetData(){

    }

    public static void areaGetEstimations(){

    }

}