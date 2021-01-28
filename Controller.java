import java.io.File; 
import java.util.Scanner;
import java.util.*; 
import java.util.ArrayList;
import java.util.Random; 

/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    public static void main(String[] args) 
    { 
        ArrayList<ArrayList<String[][]>> book1 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book2 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book3 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book4 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book5 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book6 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book7 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book8 = new ArrayList<>();
        ArrayList<ArrayList<String[][]>> book9 = new ArrayList<>();
        
        try {
            book1 = sortData(readFile(), 10);  
            book2 = sortData(readFile(), 20); 
            book3 = sortData(readFile(), 30); 
            book4 = sortData(readFile(), 40); 
            book5 = sortData(readFile(), 50); 
            book6 = sortData(readFile(), 60); 
            book7 = sortData(readFile(), 70); 
            book8 = sortData(readFile(), 80); 
            book9 = sortData(readFile(), 90); 

            
        }catch(Exception e) {
            System.out.println(e);
        }
        
        Double currError = 0.0;
        Network Temp1 = new Network(book1);
        Temp1.Train();
        Double minError = Temp1.Test();
        int minType = 10;

        Network Temp2 = new Network(book2);
        Temp2.Train();
        currError = Temp2.Test();
        if (currError < minError){
            minError = currError;
            minType = 20;
        }
        
        Network Temp3 = new Network(book3);
        Temp3.Train();
        currError = Temp3.Test();
        if (currError < minError){
            minError = currError;
            minType = 30;
        }
        
        Network Temp4 = new Network(book4);
        Temp4.Train();
        currError = Temp4.Test();
        if (currError < minError){
            minError = currError;
            minType = 40;
        }
        
        Network Temp5 = new Network(book5);
        Temp5.Train();
        currError = Temp5.Test();
        if (currError < minError){
            minError = currError;
            minType = 50;
        }
        
        Network Temp6 = new Network(book6);
        Temp6.Train();
        currError = Temp6.Test();
        if (currError < minError){
            minError = currError;
            minType = 60;
        }
        
        Network Temp7 = new Network(book7);
        Temp7.Train();
        currError = Temp7.Test();
        if (currError < minError){
            minError = currError;
            minType = 70;
        }
        
        Network Temp8 = new Network(book8);
        Temp8.Train();
        currError = Temp8.Test();
        if (currError < minError){
            minError = currError;
            minType = 80;
        }
        
        Network Temp9 = new Network(book9);
        Temp9.Train();
        currError = Temp9.Test();
        if (currError < minError){
            minError = currError;
            minType = 90;
        }
        
        System.out.println("When the sample size is " + minType + "%. There is a an average of " + minError + " of error."); 
        
        
      
    }
    
    public static ArrayList<ArrayList<String[][]>> sortData(ArrayList<String[][]> fullData, int sampleSize){
        Double targetSample = fullData.size() * (sampleSize * (.01));        
        Random rand = new Random();        
 
        ArrayList<String[][]> test = new ArrayList<String[][]>();
        
        while(targetSample <= fullData.size()){
            test.add(fullData.remove(rand.nextInt(fullData.size())));
        }
        
        ArrayList<ArrayList<String[][]>> sortedbook = new ArrayList<ArrayList<String[][]>>();
        sortedbook.add(fullData);
        sortedbook.add(test);
        
        return sortedbook;
    }
    
    public static ArrayList<String[][]> readFile() throws Exception {
        File file = new File("digit-examples-all.txt"); 
        Scanner sc = new Scanner(file); 
        ArrayList<String[][]> book = new ArrayList<>();

        while (sc.hasNextLine()) {
          String input = sc.nextLine();
          String output = sc.nextLine();
          String temp1 = input;
          String temp2 = output;
          
          temp1 = temp1.substring(2,temp1.length()-1);
          temp2 = temp2.substring(2,temp2.length()-1);
          
          String[] data1 = temp1.split("\\s+");
          String[] data2 = temp2.split("\\s+");
          
          String[][] arrays = { data1, data2 };
          book.add(arrays);
        }
        
        return book;
    }
}
