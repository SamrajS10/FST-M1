package Activity14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activity14 
{
    public static void main(String[] args) 
    {
        try 
        {
            File file = new File("example1.txt");
            boolean fStatus = file.createNewFile();

            if (fStatus) 
            {
                System.out.println("File created successfully.");
            } else 
            {
                System.out.println("File already exists.");
            }

            // Write text into the file
            FileWriter writer = new FileWriter(file);
            writer.write("This is a sample text written to the file.\n");
            writer.write("File created using createNewFile().");
            writer.close();

            System.out.println("Text written to the file successfully.");
            
        } catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}



