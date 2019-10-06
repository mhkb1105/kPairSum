package A2Q1;
import java.util.*;
/**
 * Represents a sorted integer array.  Provides a method, kpairSum, that
 * determines whether the array contains two elements that sum to a given
 * integer k.  Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
public class SortedIntegerArray {

    protected int[] sortedIntegerArray;

    public SortedIntegerArray(int[] integerArray) {
        sortedIntegerArray = integerArray.clone();
        Arrays.sort(sortedIntegerArray);
    }

/**
 * Determines whether the array contains two elements that sum to a given
 * integer k. Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
    private boolean kPairSumInterval(Integer k, int i, int j){
    	boolean result = false;
    	if(j == i) {
    		result = false;
    	}
    	if(i < 0 || j < 0) {
    		result = false;
    	}
    	if(i >= sortedIntegerArray.length || j >= sortedIntegerArray.length) {
    		result = false;
    	}
    	int sum = (sortedIntegerArray[i] + sortedIntegerArray[j]);
    	if((sum == k)) {
    		result = true;
    	}
    	else if((sum > k)) {
    		result = kPairSumInterval(k, i, j - 1);
    	}
    	else if((sum < k)) {
    		result = kPairSumInterval(k, i + 1, j);
    	}
    	if(sum > Integer.MAX_VALUE) {
    		long bigger = (long) sum;
    		
    		if((bigger == k)) {
    			result = true;
    		}
    		else if((bigger > k)) {
        		result = kPairSumInterval(k, i, j - 1);
        	}
        	else if((bigger < k)) {
        		result = kPairSumInterval(k, i + 1, j);
        	}
    		
    	}
    	return result;
    }
    
    public boolean kPairSum(Integer k) {
    	int i = 0;
    	int j = sortedIntegerArray.length - 1;
    	return kPairSumInterval(k, i, j);
    }
}