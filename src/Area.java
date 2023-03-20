import java.util.Scanner; //for reading keyboard input and Files
import java.io.BufferedReader; //Fast way to read large files and other data streams
import java.io.FileReader; //used when using BufferedReader to read a File
import java.io.BufferedWriter; //Fast way to write large files and other data streams
import java.io.FileWriter; //used when using BufferedWriter to write a File
import java.io.IOException; //Exception that can be thrown by BufferedReader and BufferedWriter
import java.util.ArrayList;


public class Area{
    int length;
    int width;
    int height;
    public Area(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public int AreaCalc(){
        int area = this.length * this.width * this.height;
        return area;
    }
    public int setLength(int length){
        this.length = length;
        return length;
    }
    public int setWidth(int width){
        this.width = width;
        return width;
    }
    public int setHeight(int height){
        this.height = height;
        return height;
    }
    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}