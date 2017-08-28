// https://www.hackerrank.com/challenges/icecream-parlor
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            int amount = in.nextInt();
            int size = in.nextInt();
            List<Integer> prices = new ArrayList<Integer>(size);
            Map<Integer, Integer> indexes = new HashMap<Integer, Integer>();
            Map<Integer, Integer> repeatedValue = new HashMap<Integer, Integer>();
            for(int j = 0 ; j < size ; j++){
                int value = in.nextInt();
                prices.add(value);
                if(indexes.get(value) == null){
                    indexes.put(value, j+1);
                } else {
                    repeatedValue.put(value, j+1);
                }
            }
            Collections.sort(prices);
            Integer minIndex = 0;
            Integer maxIndex = size-1;
            for(int j = 0 ; j < size ; j++){
                if(amount == prices.get(minIndex) + prices.get(maxIndex)){
                    break;
                }else if(amount > prices.get(minIndex) + prices.get(maxIndex)){
                    minIndex++;
                } else {
                    maxIndex--;
                }
            }
            
            if(prices.get(minIndex) == prices.get(maxIndex)){
                minIndex = indexes.get(prices.get(minIndex));
                maxIndex = repeatedValue.get(prices.get(minIndex));
            } else {
                minIndex = indexes.get(prices.get(minIndex));
                maxIndex = indexes.get(prices.get(maxIndex));
            }
            if(minIndex < maxIndex){
                System.out.println(String.format("%d %d", minIndex, maxIndex));
            }else {
                System.out.println(String.format("%d %d", maxIndex, minIndex));
            }
        }
        in.close();
    }
}
