/*Write a program that reads a line from the user to a text file called "chat.txt". 
The program should not overwrite the text file each time you call it, but only add it to the end.*/

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyChat {
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        // enter input and store it to a string
        System.out.print("Enter text input: "); 
        String textInput = readInput.nextLine(); 

        // create file
        File myFile = new File("chat.txt"); 

        // append text to file
        try (FileWriter writeFile = new FileWriter(myFile, true)) {
            writeFile.write(textInput + System.lineSeparator());
            System.out.println("NOTICE: Your input has been successfully added to the file, chat.txt");
        } catch (IOException e) {
            System.out.println("NOTICE: An error occurred.");
            e.printStackTrace();
        }
        
        readInput.close();
    
    }
}
