// https://www.hackerrank.com/challenges/maximum-subarray-sum
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // 3 - 5 + 7 = 5
    // 3 - 2 + 7 = 8 % 7 = 1
    // 6 - 8 + 10 = 8
    // 6 - 7 + 10 = 9
    private static long maxSum(long module, List<Long> array){
        long result = 0L;
        TreeSet<Long> tree = new TreeSet<Long>();
        for(int i = 0 ; i < array.size() ; i ++){
            if(i > 0){
                tree.add(array.get(i-1));
                Long value = tree.ceiling(array.get(i)+1);
                if(value != null)
                    result = Math.max(result, (array.get(i) - value + module) % module );
            }

            result = Math.max(result, array.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            int size = in.nextInt();
            long module = in.nextLong();
            
            List<Long> prefix = new ArrayList<Long>(size);
            long sum = 0L;
            for(int j = 0 ; j < size ; j++){
                long value = in.nextLong()%module;
                sum = (value + sum) % module;
                prefix.add(sum);
            }
            
            System.out.println(maxSum(module, prefix));
        }
    }
}
