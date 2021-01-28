import java.util.Random; 
import java.util.*; 
import java.util.ArrayList;

/**
 * Write a description of class Network here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Network
{
    private int INPUT = 64;
    private int OUTPUT = 10;
    private int EPOCH = 1000;
    private Double RATE = .01;
    private ArrayList<String[][]> TEST;
    private ArrayList<String[][]> SAMPLE;
    private Double[][] neural = new Double[INPUT][OUTPUT];
    

    /**
     * Constructor for objects of class Network
     */
    public Network(ArrayList<ArrayList<String[][]>> twobooks)
    {
        Random rand = new Random();   
        for (int i = 0; i < INPUT; i++) {
            for (int j = 0; j < OUTPUT; j++) {
                neural[i][j] = (Math.random() * .30) - .15;
            }
        }
        SAMPLE = twobooks.get(0);
        TEST = twobooks.get(1);
        
    }
    public void Train(){
        Double total = 0.0;
        Double ratio = 0.0;
        String[][] pair = new String[0][0];
        int k = 0;
        int m = 0;
        
        while(k < EPOCH){
            while(m < SAMPLE.size()){
                pair = SAMPLE.get(m);
                for(int i = 0; i < OUTPUT; i++){
                    for (int j = 0; j <INPUT; j++) {
                        Double test =  Double.parseDouble(pair[0][j]);
                        total += neural[j][i] ;
                    }
                    ratio = perceptron(total, Double.parseDouble(pair[1][i]));
                    for (int j = 0; j < INPUT; j++) {
                            neural[j][i] = neural[j][i] + ratio *  Double.parseDouble(pair[0][j]);
                    }
                }
                m += 1;
            }
            k += 1;
        }

    }
    
    public Double perceptron(Double sum, Double target){
        Double sig = (1/( 1 + Math.pow(Math.E,(-1* sum))));
        Double error = target - sig;
        Double factor = sig * (1 - sig);
        return RATE * error * factor;
    }
    
    public Double Test(){
        Double total = 0.0;
        int m = 0;
        String[][] pair = new String[0][0];
        Double ratio = 0.0;
        Double error = 0.0;
        
        while(m < TEST.size()){
            pair = TEST.get(m);
            for(int i = 0; i < OUTPUT; i++){
                for (int j = 0; j <INPUT; j++) {
                    total += neural[j][i] *  Double.parseDouble(pair[0][j]);
                }
                error += Math.pow(Math.abs((total - Double.parseDouble(pair[1][i]))) , 2);
            }
            m += 1;
        }
        return error/m;
    }
}
