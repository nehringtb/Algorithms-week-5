import java.util.*;

public class PrimitiveCalculator {
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
    
    private static List<Integer> optimal_sequence_rec(int n, int c){
    	List<Integer> sequence=null;
    	//System.out.println(c);
    	if(c>30)
    		return null;
    	if (n==1){
    		sequence= new ArrayList<Integer>();
    		sequence.add(n);
    		return sequence;
    		
    	}
    	List<Integer> div3=null;
    	List<Integer> div2=null;
    	List<Integer> m1=null;
    	
    	if (n%3==0){
    		div3=optimal_sequence_rec(n/3,c+1);
    	}
    	if(div3!=null)
        	sequence=div3;
    	
    	if (n%2==0){
    		div2=optimal_sequence_rec(n/2,c+1);
    	}
    	if(div2!=null){
    		if(sequence==null){
    			sequence=div2;
    		}
    		else if(div2.size()<sequence.size()){
    			sequence=div2;
    		}
    	}
    	
    	if(n%3!=0 || n%2!=0 || c<2)
    		m1=optimal_sequence_rec(n-1,c+1);
    	
    	if(m1!=null){
    		if(sequence==null){
    			sequence=m1;
    		}
    		else if(m1.size()<sequence.size()){
    			sequence=m1;
    		}
    	}
    	
    	
    	
    	if (sequence==null)
    		sequence= new ArrayList<Integer>();
    	
    	sequence.add(n);
    	return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence_rec(n,0);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
         //   System.out.print(x + " ");
        }
    }
}

