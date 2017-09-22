package OA;

public class MultiDimensionArray {
	// This is a provided function, Assume it works
    public static Long getValue(int... indexOfDimension) {
        //... 
        return (long) 0;
    }
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
    	/*the key point or difficult point for this question is the requirement of no extra space and recursion.
    	My approach to fulfill this requirement is to modify the input array,
    	as the coordinate of elements in this MultiDimensionArray. By doing so I don't need to create a new int[]
    	to pass the coordinate.
    	But I realize if I want to modify this input array, anyway I need to store every dimension's length.
    	So I give up, I use an addition array which lenght is equal to the input array to pass the coordinate.*/
    	
    	// step 1, get the total number of elements in the MultiDimensionArray
    	long total = 1;
    	for(int i = 0; i < lengthOfDeminsion.length; i++) {
    		total *= lengthOfDeminsion[i];
    	}
    	
    	//step 2, declare a factor = total / lengthOfDeminsion[0], which used to calculate each demision's index,
    	//		 by total % factor. when we move to next demision's factor = factor / cur_demision_length;
    	
    	
    	long sum = 0;
    	int[] coordinate = new int[lengthOfDeminsion.length];
    	for(long i = total -1; i >= 0; i--) {
    		long cur_level = i;
    		long factor = total;
    		for(int j = 0; j < lengthOfDeminsion.length; j++) {
    			factor = factor / lengthOfDeminsion[j];
    			coordinate [j]= (int) (cur_level / factor);
    			cur_level = cur_level % factor;
    			
    			
    		}

    		sum += getValue(coordinate);
    	}
    	
    	
    
    return sum;
    }
    
}

// time: O(m * n) m: total number of elements in the MultiDimensionArray, n: the number of dimension
// space :O(n)  the number of dimension
