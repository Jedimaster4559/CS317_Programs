import processes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program1Main {
    public static void main(String[] args){
        System.out.println("Please Choose what type of data to generate (enter the number):");
        System.out.println("1. Sort Data");
        System.out.println("2. Search Data");
        System.out.println("3. All Data");

        boolean validInput = false;
        int process = 0;
        while(!validInput){
            Scanner input = new Scanner(System.in);
            try {
                process = input.nextInt();
                if(process > 3 || process < 1){
                    throw new Exception();
                }
                validInput = true;
                input.close();
            } catch (Exception e){
                validInput = false;
                System.out.println("Please enter a valid number (1-3):");
            }
        }

        if(process == 1){

        } else if (process == 2){
            Search.Run();
        } else {
            Search.Run();
        }

    }
}
