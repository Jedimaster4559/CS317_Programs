package data;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataHandler {
    private static DataHandler instance = null;
    private static Object lock = new Object();

    private ArrayList<Integer> values;

    private DataHandler(){
        values = new ArrayList<>();
        File searchOutputFile = new File("search_output.csv");
        searchOutputFile.delete();    // Delete the output file if it already exists.
        File sortOutputFile = new File("sort_output.csv");
        sortOutputFile.delete();
    }

    private static DataHandler getInstance(){
        if(instance == null){
            synchronized (lock){
                if(instance == null){
                    instance = new DataHandler();
                }
            }
        }
        return instance;
    }

    public static void start(){
        getInstance();
        readFile();
    }

    public static int[] getValues(int length){
        DataHandler instance = getInstance();
        if(length > instance.values.size()){
            return null;
        } else {
            int[] list = new int[length];
            for(int i = 0; i < length; i++){
                list[i] = instance.values.get(i);
            }
            return list;
        }
    }

    public static int getLength(){
        DataHandler instance = getInstance();
        return instance.values.size();
    }

    private static void readFile(){
        DataHandler instance = getInstance();
        try{
            JFrame frame = new JFrame();
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
            File inputFile = fc.getSelectedFile();
            frame.dispose();
            Scanner reader = new Scanner(inputFile);
            while(reader.hasNextInt()){
                instance.values.add(reader.nextInt());
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("That is an invalid file location. Exiting Now...");
            System.exit(1);
        }
        Collections.sort(instance.values);
    }

    public static void writeSearch(String s){
        writeFile(s, "search_output.csv");
    }

    public static void writeSort(String s){
        writeFile(s, "sort_output.csv");
    }

    private static boolean writeFile(String s, String fileName){
        try{
            FileWriter writer = new FileWriter(fileName, true);
            writer.append(s);
            writer.append("\n");
            writer.close();
            return true;
        } catch(IOException e){
            System.out.println("Unable to write to file");
            System.exit(2);
        }
        return false;
    }


}
