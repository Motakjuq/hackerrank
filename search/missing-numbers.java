// https://www.hackerrank.com/challenges/missing-numbers
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sizeA = in.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < sizeA ; i++){
            Integer value = in.nextInt();
            if(map.get(value) == null){
                map.put(value,1);
            } else {
                map.put(value,map.get(value)+1);
            }
        }
        
        int sizeB = in.nextInt();
        for(int i = 0 ; i < sizeB ; i++){
            Integer value = in.nextInt();
            if(map.get(value) == null){
                map.put(value,-1);
            } else {
                if(map.get(value) - 1 == 0){
                    map.remove(value);
                }else{
                    map.put(value,map.get(value)-1);
                }
            }
        }
        
        List<Integer> elements = new ArrayList<Integer>(map.keySet());
        Collections.sort(elements);
        for(int i = 0 ; i < elements.size() ; i++){
            System.out.print(elements.get(i));
            if(i == elements.size() - 1){
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        in.close();
    }
}
