import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class blockData {

    ArrayList<String[]> file;

    public blockData(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        BufferedReader myFile = new BufferedReader(file);

        ArrayList<String[]> csvdata = new ArrayList<String[]>();

        String[] row;
        String line = myFile.readLine();
        while (line != null) {
            row = line.split(",");
            csvdata.add(row);
            line = myFile.readLine();
        }
        myFile.close();
        this.file = csvdata;
    }

    public String getBlockName(int blockID){
        return file.get(blockID)[0];
    }
}
