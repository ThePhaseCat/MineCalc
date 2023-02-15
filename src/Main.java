import net.querz.nbt.io.NBTInputStream;
import net.querz.nbt.io.NBTUtil;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner; //for reading keyboard input and Files
import java.util.ArrayList;
import java.util.Arrays;
import net.querz.nbt.tag.CompoundTag;


public class Main{

    static Area area = new Area(0, 0, 0);
    static AreaEstimation areaEstimation = new AreaEstimation(0, 0, 0, 0);

    public static void main(String[] args) {
        //define stuff here



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

        structureButton.addActionListener(e -> {
            try {
                structure();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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
            areaGetEstimations1();
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

        JLabel lengthLabel = new JLabel("Length: " + area.getLength());
        JLabel widthLabel = new JLabel("Width: " + area.getWidth());
        JLabel heightLabel = new JLabel("Height: "+ area.getHeight());

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
            area.setLength(Integer.parseInt(lengthField.getText()));
            lengthLabel.setText("Length: " + area.getLength());
        });

        widthField.addActionListener(e -> {
            area.setWidth(Integer.parseInt(widthField.getText()));
            widthLabel.setText("Width: " + area.getWidth());
        });

        heightField.addActionListener(e -> {
            area.setHeight(Integer.parseInt(heightField.getText()));
            heightLabel.setText("Height: " + area.getHeight());
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

        JLabel lengthLabel = new JLabel("Length: " + area.getLength());
        JLabel widthLabel = new JLabel("Width: " + area.getWidth());
        JLabel heightLabel = new JLabel("Height: " + area.getHeight());
        JLabel areaLabel = new JLabel("Area: " + area.AreaCalc());

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

    public static void areaGetEstimations1(){
        areaEstimation.setAreaSelected(area.AreaCalc());

        JFrame areaGetEstimationsScreen = new JFrame("MineCalc - Area Service - Get Estimations from Area Data - Tool Select");
        areaGetEstimationsScreen.setLayout(new BoxLayout(areaGetEstimationsScreen.getContentPane(), BoxLayout.Y_AXIS));

        JButton pickaxeButton = new JButton("Pickaxe");
        JButton shovelButton = new JButton("Shovel");

        pickaxeButton.addActionListener(e -> {
            areaGetEstimations2("Pickaxe");
            areaGetEstimationsScreen.dispose();
        });

        shovelButton.addActionListener(e -> {
            areaGetEstimations2("Shovel");
            areaGetEstimationsScreen.dispose();
        });

        areaGetEstimationsScreen.add(pickaxeButton);
        areaGetEstimationsScreen.add(shovelButton);

        areaGetEstimationsScreen.setSize(300, 200);
        areaGetEstimationsScreen.setVisible(true);
        areaGetEstimationsScreen.setLocationRelativeTo(null);
        areaGetEstimationsScreen.setLocation(600, 200);
    }

    public static void areaGetEstimations2(String tool){
        JFrame areaGetEstimationsScreen = new JFrame("MineCalc - Area Service - Get Estimations from Area Data - Tool Type Select");
        areaGetEstimationsScreen.setLayout(new BoxLayout(areaGetEstimationsScreen.getContentPane(), BoxLayout.Y_AXIS));

        JButton woodButton = new JButton("Wood");
        JButton stoneButton = new JButton("Stone");
        JButton ironButton = new JButton("Iron");
        JButton goldButton = new JButton("Gold");
        JButton diamondButton = new JButton("Diamond");
        JButton netheriteButton = new JButton("Netherite");

        woodButton.addActionListener(e -> {
            areaEstimation.setToolSelect(1);
            areaGetEstimations3(tool);
            areaGetEstimationsScreen.dispose();
        });

        stoneButton.addActionListener(e -> {
            areaEstimation.setToolSelect(2);
            areaGetEstimations3(tool);
            areaGetEstimationsScreen.dispose();
        });

        ironButton.addActionListener(e -> {
            areaEstimation.setToolSelect(3);
            areaGetEstimations3(tool);
            areaGetEstimationsScreen.dispose();
        });

        goldButton.addActionListener(e -> {
            areaEstimation.setToolSelect(4);
            areaGetEstimations3(tool);
            areaGetEstimationsScreen.dispose();
        });

        diamondButton.addActionListener(e -> {
            areaEstimation.setToolSelect(5);
            areaGetEstimations3(tool);
            areaGetEstimationsScreen.dispose();
        });

        netheriteButton.addActionListener(e -> {
            areaEstimation.setToolSelect(6);
            areaGetEstimations3(tool);
            areaGetEstimationsScreen.dispose();
        });

        areaGetEstimationsScreen.add(woodButton);
        areaGetEstimationsScreen.add(stoneButton);
        areaGetEstimationsScreen.add(ironButton);
        areaGetEstimationsScreen.add(goldButton);
        areaGetEstimationsScreen.add(diamondButton);
        areaGetEstimationsScreen.add(netheriteButton);

        areaGetEstimationsScreen.setSize(300, 200);
        areaGetEstimationsScreen.setVisible(true);
        areaGetEstimationsScreen.setLocationRelativeTo(null);
        areaGetEstimationsScreen.setLocation(600, 200);
    }

    public static void areaGetEstimations3(String tool){
        JFrame areaGetEstimationsScreen = new JFrame("MineCalc - Area Service - Get Estimations from Area Data - Enchant Select");
        areaGetEstimationsScreen.setLayout(new BoxLayout(areaGetEstimationsScreen.getContentPane(), BoxLayout.Y_AXIS));

        JButton noUnbreakingButton = new JButton("No Unbreaking");
        JButton unbreaking1Button = new JButton("Unbreaking 1");
        JButton unbreaking2Button = new JButton("Unbreaking 2");
        JButton unbreaking3Button = new JButton("Unbreaking 3");

        noUnbreakingButton.addActionListener(e -> {
            areaEstimation.setEnchantIncrease(1);
            areaGetEstimations4(tool);
            areaGetEstimationsScreen.dispose();
        });

        unbreaking1Button.addActionListener(e -> {
            areaEstimation.setEnchantIncrease(2);
            areaGetEstimations4(tool);
            areaGetEstimationsScreen.dispose();
        });

        unbreaking2Button.addActionListener(e -> {
            areaEstimation.setEnchantIncrease(3);
            areaGetEstimations4(tool);
            areaGetEstimationsScreen.dispose();
        });

        unbreaking3Button.addActionListener(e -> {
            areaEstimation.setEnchantIncrease(4);
            areaGetEstimations4(tool);
            areaGetEstimationsScreen.dispose();
        });

        areaGetEstimationsScreen.add(noUnbreakingButton);
        areaGetEstimationsScreen.add(unbreaking1Button);
        areaGetEstimationsScreen.add(unbreaking2Button);
        areaGetEstimationsScreen.add(unbreaking3Button);

        areaGetEstimationsScreen.setSize(300, 200);
        areaGetEstimationsScreen.setVisible(true);
        areaGetEstimationsScreen.setLocationRelativeTo(null);
        areaGetEstimationsScreen.setLocation(600, 200);
    }

    public static void areaGetEstimations4(String tool){
        String material = "";
        String unbreaking = "";

        if(areaEstimation.getToolSelect() == 1){
            material = "Wood";
        } else if(areaEstimation.getToolSelect() == 2){
            material = "Stone";
        } else if(areaEstimation.getToolSelect() == 3){
            material = "Iron";
        } else if(areaEstimation.getToolSelect() == 4){
            material = "Gold";
        } else if(areaEstimation.getToolSelect() == 5){
            material = "Diamond";
        } else if(areaEstimation.getToolSelect() == 6){
            material = "Netherite";
        }

        if(areaEstimation.getEnchantIncrease() == 1){
            unbreaking = "No Unbreaking";
        } else if(areaEstimation.getEnchantIncrease() == 2){
            unbreaking = "Unbreaking 1";
        } else if(areaEstimation.getEnchantIncrease() == 3){
            unbreaking = "Unbreaking 2";
        } else if(areaEstimation.getEnchantIncrease() == 4){
            unbreaking = "Unbreaking 3";
        }

        double finalResult = area.AreaCalc()/areaEstimation.getDurability();


        JFrame areaGetEstimationsScreen = new JFrame("MineCalc - Area Service - Get Estimations from Area Data - Final Results");
        areaGetEstimationsScreen.setLayout(new BoxLayout(areaGetEstimationsScreen.getContentPane(), BoxLayout.Y_AXIS));

        JLabel areaLabel = new JLabel("Area: " + area.AreaCalc());
        JLabel toolLabel = new JLabel("Tool: " + tool);
        JLabel materialLabel = new JLabel("Material: " + material);
        JLabel unbreakingLabel = new JLabel("Unbreaking: " + unbreaking);
        JLabel finalResults = new JLabel("You will need " + finalResult + " " + tool + "s to mine this area.");

        areaGetEstimationsScreen.add(areaLabel);
        areaGetEstimationsScreen.add(toolLabel);
        areaGetEstimationsScreen.add(materialLabel);
        areaGetEstimationsScreen.add(unbreakingLabel);
        areaGetEstimationsScreen.add(finalResults);

        areaGetEstimationsScreen.setSize(300, 200);
        areaGetEstimationsScreen.setVisible(true);
        areaGetEstimationsScreen.setLocationRelativeTo(null);
        areaGetEstimationsScreen.setLocation(600, 200);
    }

    public static void structure() throws IOException {
        //NamedTag namedTag = NBTUtil.read("structures/igloo.nbt");

        NBTInputStream nbtInputStream = new NBTInputStream(new FileInputStream("structures/igloo.nbt"));

        JFrame structureScreen = new JFrame("MineCalc - Structure Service");
        structureScreen.setLayout(new BoxLayout(structureScreen.getContentPane(), BoxLayout.Y_AXIS));

        JLabel structureLabel = new JLabel("Structure File Loaded: " + nbtInputStream.readRawTag.getName());

    }
}