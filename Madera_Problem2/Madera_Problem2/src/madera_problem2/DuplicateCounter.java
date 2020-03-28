
package madera_problem2;

import java.util.*;
import java.lang.System.*;
import java.io.*;


public class DuplicateCounter extends Application {
    static ArrayList<String> uniqueWords = new ArrayList<String>(); 
    static Map<String,Integer> wordCounter = new HashMap<String,Integer>();
    public static void count (String count){
        // uses map of strings to count how many
        // times a word occurs in dataFile
        int found = 0;
        try{
        
        File file = new File ("problem2.txt");
        Scanner words = new Scanner(file);
        Scanner list = new Scanner(file);
                
        while (words.hasNextLine()){
                String[] arr = words.nextLine().split(" ");
                found = 0;
                for (int i = 0; i < arr.length; i++){
                    if (uniqueWords.contains(arr[i])){                        
                        found = 1;
                         
                    }
                    if (found == 0){
                        uniqueWords.add(words.nextLine());
                    }  
                }
                 
            }    
        

        while (list.hasNextLine()){
             
            // goes through file until it ends
            // and finds how many times each word is repeated
            found = 0;            
            
            while (list.hasNext()){
                
                String[] arr = list.nextLine().split(" ");
                
                for (int i = 0; i < arr.length; i++){
                    //System.out.println("ewifhewg");
                    if (uniqueWords.contains(arr[i])){
                        
                        found += 1;
                    }
                    
                }
                if (found != 0){
                       
                       wordCounter.put(list.nextLine(),found);
                }
                
            }
            
        }
        words.close();
        list.close();
        }
        catch (Exception e){
        }
        
    }
    public static void write (String outputFile) throws Exception{
        // writes contents of wordCounter to file in
        // the output file
        // file is overwritten if it exitsts, created if not
        
        File file = new File("unique_word_counts.txt");
        FileWriter writing = new FileWriter(file);
        
        if (file.createNewFile()){
            System.out.println("File created!");
        } else {
            System.out.println("File already exists.");
        }       
        for (Map.Entry<String,Integer> entry : wordCounter.entrySet()){            
            writing.write(entry.getKey() + " : " + entry.getValue() + "\n");
        }
        writing.close();
    }
    public static void DuplicateCounter() throws Exception{
        String file = "problem2.txt";
        count(file);
        write(file);
    }
}
