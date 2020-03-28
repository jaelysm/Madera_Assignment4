
package madera_problem1;

import java.util.*;
import java.lang.System.*;
import java.io.*;
import java.io.File;

public class DuplicateRemover extends Application{
    static ArrayList<String> uniqueWords = new ArrayList<String>(); 
    public static void remove (String dataFile) throws Exception{
        // uses set of strings to eliminate duplicate line from the file
        // referenced by dataFile
        // unique line are stored in instance variable 
        String[] arr;
        
        try{
            
            File file = new File ("problem1.txt");
            Scanner line = new Scanner(file);
            
            arr = line.nextLine().split(" ");
            for (int i = 0; i <= arr.length-1; i++){
                if (!uniqueWords.contains(arr[i])){                        
                    uniqueWords.add(arr[i]);                    
                }
            }
            
            while (line.hasNextLine()){
                arr = line.nextLine().split(" ");
                for (int i = 0; i <= arr.length-1; i++){
                    if (!uniqueWords.contains(arr[i])){                        
                        uniqueWords.add(arr[i]);                    }
                }
            }             
            line.close();
        }
        catch (Exception e){
            System.out.println("Sorry! Something went wrong.");
        }
        
    }
      
    public static void write (String outputFile) throws Exception{
        // writes the line in uniqueWords to the file in outputFile
        // output file is overwritten is it exists or created if not
        
        File file = new File("unique_words.txt");
        FileWriter writing = new FileWriter(file);
        
        if (file.createNewFile()){
            System.out.println("File created!");
        } else {
            System.out.println("File already exists.");
        }
        
        System.out.println("Writing unique words now.");
                    
        writing.write(Arrays.toString(uniqueWords.toArray()));

        writing.close();
    }  
    
    public static void DuplicateRemover() throws Exception{
        String file = "problem1.txt";
        
        remove(file);
        write (file);
    }
    
}
