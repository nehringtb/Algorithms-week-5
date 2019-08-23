import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }

    static int optimalWeight_Dynamic(int W, int[] w) {
        int[][] value= new int[W+1][w.length+1];
        
       for (int i=1; i<w.length+1; i++){
    	   for (int wa=1;wa<=W; wa++){
    		   value[wa][i]=value[wa][i-1];
    		   if(w[i-1]<=wa){
    			   int val=value[wa-w[i-1]][i-1]+w[i-1];
    			   if(value[wa][i]<val){
    				   value[wa][i]=val;
    			   }
    		   }
           }
       }
       
    	
    	
    	
    	
    	return value[W][w.length];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight_Dynamic(W, w));
    }
}

