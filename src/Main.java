import net.querz.nbt.io.NBTUtil;
import net.querz.nbt.tag.CompoundTag;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader; //Fast way to read large files and other data streams
import java.util.concurrent.atomic.AtomicReference;


public class Main{

    static Area area = new Area(0, 0, 0);
    static AreaEstimation areaEstimation = new AreaEstimation(0, 0, 0, 0);

    static List<Block2> blocks = readBooksFromCSV("data/blocks2.csv");

    private static java.util.List<Block2> readBooksFromCSV(String fileName) {
        List<Block2> blocks = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Block2 block = createBlock2(attributes);

                // adding book into ArrayList
                blocks.add(block);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return blocks;
    }

    private static Block2 createBlock2(String[] metadata) {
        String name = metadata[0];
        String tool = metadata[1];
        String dim = metadata[2];
        String biome = metadata[3];
        String craftable = metadata[4];

        // create and return book of this metadata
        return new Block2(name, tool, dim, biome, craftable);
    }

    public static Block2 getBlock(String name){
        for (Block2 block : blocks) {
            if (block.getName().equals(name)) {
                return block;
            }
        }
        return null;
    }

    //write code to get the position of a block in the list
    public static int getBlockIndex(String name){
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
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
            structure();
        });

        blockButton.addActionListener(e -> {
            block();
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


    //put stuff for structure data ana here
    public static void structure(){
        AtomicReference<String> structureFileName = new AtomicReference<>("");
        AtomicReference<String> trueFileName = new AtomicReference<>("");
        AtomicReference<CompoundTag> structureData = new AtomicReference<>(new CompoundTag());

        JFrame structureScreen = new JFrame("MineCalc - Structure Service");
        structureScreen.setLayout(new BoxLayout(structureScreen.getContentPane(), BoxLayout.Y_AXIS));

        JLabel structureNameInfo1Label = new JLabel("Put structure file in the structures folder");
        JLabel structureNameInfo2Label = new JLabel("Then, type the filename of the structure file EXACLTY");
        JTextField structureNameInput = new JTextField();


        structureNameInput.addActionListener(e -> {
            structureFileName.set(structureNameInput.getText());
            trueFileName.set("structures/" + structureFileName.get() + ".nbt");
            try {
                structureData.set((CompoundTag) NBTUtil.read(String.valueOf(trueFileName)).getTag());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            String test = structureData.get().getListTag("palette").toString();

            System.out.println(test);

        });

        structureScreen.add(structureNameInfo1Label);
        structureScreen.add(structureNameInfo2Label);
        structureScreen.add(structureNameInput);

        structureScreen.setSize(300, 200);
        structureScreen.setVisible(true);
        structureScreen.setLocationRelativeTo(null);
        structureScreen.setLocation(600, 200);

    }
    //end of that stuff



    public static void block(){
        AtomicReference<String> blockNameFixed = new AtomicReference<>("");
        AtomicReference<String> blockTool = new AtomicReference<>("");
        AtomicReference<String> blockDim = new AtomicReference<>("");
        AtomicReference<String> blockLoc = new AtomicReference<>("");
        AtomicReference<String> blockCraft = new AtomicReference<>("");

        JFrame blockScreen = new JFrame("MineCalc - Block Service");
        blockScreen.setLayout(new BoxLayout(blockScreen.getContentPane(), BoxLayout.Y_AXIS));

        JLabel blockNameInputLabel = new JLabel("Enter block name below!");
        JTextField blockNameInput = new JTextField();
        JLabel blockInfo = new JLabel("Block Name: " + blockNameFixed);
        JLabel blockToolLabel = new JLabel("Tool: " + blockTool);
        JLabel blockDimLabel = new JLabel("Dimension: " + blockDim);
        JLabel blockLocLabel = new JLabel("Biome: " + blockLoc);
        JLabel blockCraftLabel = new JLabel("Craftable: " + blockCraft);

        blockNameInput.addActionListener(e -> {
            String blockName = blockNameInput.getText();
            blockName = blockName.replace(" ", "_");
            blockName = blockName.toUpperCase();
            if(getBlockIndex(blockName)==-1){
                blockInfo.setText("Block Name: Not Found");
                blockToolLabel.setText("Tool: Not Found");
                blockDimLabel.setText("Dimension: Not Found");
                blockLocLabel.setText("Biome: Not Found");
                blockCraftLabel.setText("Craftable: Not Found");
            }
            else{
                blockNameFixed.set(blocks.get(getBlockIndex(blockName)).getName());
                blockTool.set(blocks.get(getBlockIndex(blockName)).getTool());
                blockDim.set(blocks.get(getBlockIndex(blockName)).getDim());
                blockLoc.set(blocks.get(getBlockIndex(blockName)).getBiome());
                blockCraft.set(blocks.get(getBlockIndex(blockName)).getCraftable());

                blockInfo.setText("Block Name: " + blockNameFixed);
                blockToolLabel.setText("Tool: " + blockTool);
                blockDimLabel.setText("Dimension: " + blockDim);
                blockLocLabel.setText("Biome: " + blockLoc);
                blockCraftLabel.setText("Craftable: " + blockCraft);
            }
        });

        blockScreen.add(blockNameInputLabel);
        blockScreen.add(blockNameInput);
        blockScreen.add(blockInfo);
        blockScreen.add(blockToolLabel);
        blockScreen.add(blockDimLabel);
        blockScreen.add(blockLocLabel);
        blockScreen.add(blockCraftLabel);

        blockScreen.setSize(300, 200);
        blockScreen.setVisible(true);
        blockScreen.setLocationRelativeTo(null);
        blockScreen.setLocation(600, 200);

        //System.out.println(blocks.get(5).getName());
    }
}

class Block2 {
    private String name;
    private String tool;

    private String dim;

    private String biome;

    private String craftable;

    public Block2(String name, String tool, String dim, String biome, String craftable) {
        this.name = name;
        this.tool = tool;
        this.dim = dim;
        this.biome = biome;
        this.craftable = craftable;
    }

    public String getName() {
        return name;
    }

    public String getTool() {
        return tool;
    }

    public String getDim() {
        return dim;
    }

    public String getBiome() {
        return biome;
    }

    public String getCraftable() {
        return craftable;
    }

    @Override
    public String toString() {
        return ""+name+","+tool+","+dim+","+biome+","+craftable+"";
    }


}