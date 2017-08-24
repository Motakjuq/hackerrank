// https://www.hackerrank.com/challenges/minimum-distances
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> positions = new HashMap<Integer, Integer>(100);
        int distance = -1;
        for(int i = 0 ; i < n ; i++){
            int value = in.nextInt();
            Integer position = positions.get(value);
            if( (position != null) && (distance == -1 || distance > i - position)){
                distance = i - position;
            }
            positions.put(value, i);
        }
        
        System.out.println(distance);
        in.close();
    }
}
