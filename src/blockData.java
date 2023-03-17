import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of books stored in CSV file as comma separated values.
 *
 * @author WINDOWS 8
 *
 */
public class blockData {

    public static void main(String... args) {
        List<Block> blocks = readBooksFromCSV("data/blocks2.csv");

        System.out.println(blocks.get(5).getName());

        // let's print all the person read from CSV file
        //for (Block b : blocks) {
           // System.out.println(b);
       // }


    }

    private static List<Block> readBooksFromCSV(String fileName) {
        List<Block> blocks = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(",");

                Block block = createBlock(attributes);

                // adding block into list
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

    private static Block createBlock(String[] metadata) {
        String name = metadata[0];
        String tool = metadata[1];
        String dim = metadata[2];
        String biome = metadata[3];
        String craftable = metadata[4];

        // create and return block of this metadata
        return new Block(name, tool, dim, biome, craftable);
    }

}

class Block {
    private String name;
    private String tool;

    private String dim;

    private String biome;

    private String craftable;

    public Block(String name, String tool, String dim, String biome, String craftable) {
        this.name = name.replace("_", " ");
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