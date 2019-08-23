import java.util.*;

public class PrimitiveCalculator2 {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    private static int optimal_sequence_rec(int n, int c){
    	//List<Integer> sequence=null;
    	//System.out.println(c);
    	if(c>30)
    		return c;
    	
    	if (n==1){
    		
    		return c;
    		
    	}
    	int div3= Integer.MAX_VALUE;
    	int div2=Integer.MAX_VALUE;
    	int m1=Integer.MAX_VALUE;
    	
    	if (n%3==0){
    		div3=optimal_sequence_rec(n/3,c+1);
    	}
    	
    	if (n%2==0){
    		div2=optimal_sequence_rec(n/2,c+1);
    	}
    	if((n%2!=0 || n%3!=0))
    		m1=optimal_sequence_rec(n-1,c+1);
    		
    		
    	int toReturn=div3;
    	
    	if(div2<toReturn)
    		toReturn=div2;
		if(m1<toReturn)
			toReturn=m1;
    	return toReturn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       // List<Integer> sequence = optimal_sequence_rec(n,0);
        int len=optimal_sequence_rec(n,0);
        System.out.println(len);
        //for (Integer x : sequence) {
          //  System.out.print(x + " ");
        //}
    }
}

