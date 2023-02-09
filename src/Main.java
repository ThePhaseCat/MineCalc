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
    static int width = 0;
    static int height = 0;
    static int area = 0;

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

        JLabel areaChangeDataLabel = new JLabel("Enter information here (Press enter when done with input to save selection)");
        areaChangeDataLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel lengthLabel = new JLabel("Length: " + length);
        JLabel widthLabel = new JLabel("Width: " + width);
        JLabel heightLabel = new JLabel("Height: "+ height);

        lengthLabel.setHorizontalAlignment(JLabel.CENTER);
        widthLabel.setHorizontalAlignment(JLabel.CENTER);
        heightLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField lengthField = new JTextField();
        JTextField widthField = new JTextField();
        JTextField heightField = new JTextField();

        lengthField.setHorizontalAlignment(JTextField.CENTER);
        widthField.setHorizontalAlignment(JTextField.CENTER);
        heightField.setHorizontalAlignment(JTextField.CENTER);

        lengthField.addActionListener(e -> {
            length = Integer.parseInt(lengthField.getText());
            lengthLabel.setText("Length: " + length);
        });

        widthField.addActionListener(e -> {
            width = Integer.parseInt(widthField.getText());
            widthLabel.setText("Width: " + width);
        });

        heightField.addActionListener(e -> {
            height = Integer.parseInt(heightField.getText());
            heightLabel.setText("Height: " + height);
            //areaGetData();
            //areaChangeDataScreen.dispose();
        });

        areaChangeDataScreen.add(areaChangeDataLabel);
        areaChangeDataScreen.add(lengthLabel);
        areaChangeDataScreen.add(lengthField);
        areaChangeDataScreen.add(widthLabel);
        areaChangeDataScreen.add(widthField);
        areaChangeDataScreen.add(heightLabel);
        areaChangeDataScreen.add(heightField);


        areaChangeDataScreen.setSize(500, 300);
        areaChangeDataScreen.setVisible(true);
        areaChangeDataScreen.setLocationRelativeTo(null);
        areaChangeDataScreen.setLocation(400, 200);
    }

    public static void areaGetData(){
        JFrame areaGetDataScreen = new JFrame("MineCalc - Area Service - Get Area Data");
        areaGetDataScreen.setLayout(new BoxLayout(areaGetDataScreen.getContentPane(), BoxLayout.Y_AXIS));

        JLabel lengthLabel = new JLabel("Length: " + length);
        JLabel widthLabel = new JLabel("Width: " + width);
        JLabel heightLabel = new JLabel("Height: " + height);
        JLabel areaLabel = new JLabel("Area: " + calArea(length, width, height));

        lengthLabel.setHorizontalAlignment(JLabel.CENTER);
        widthLabel.setHorizontalAlignment(JLabel.CENTER);
        heightLabel.setHorizontalAlignment(JLabel.CENTER);
        areaLabel.setHorizontalAlignment(JLabel.CENTER);

        areaGetDataScreen.add(lengthLabel);
        areaGetDataScreen.add(widthLabel);
        areaGetDataScreen.add(heightLabel);
        areaGetDataScreen.add(areaLabel);

        areaGetDataScreen.setSize(300, 200);
        areaGetDataScreen.setVisible(true);
        areaGetDataScreen.setLocationRelativeTo(null);
        areaGetDataScreen.setLocation(600, 200);
    }

    public static void areaGetEstimations(){

    }

    public static int calArea(int len, int wid, int hei){
        int sum = len * wid * hei;
        return sum;
    }
}