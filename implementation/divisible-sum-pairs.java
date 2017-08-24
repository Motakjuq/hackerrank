// https://www.hackerrank.com/challenges/divisible-sum-pairs
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numbers = in.nextInt();
        int module = in.nextInt();
        int values[] = new int[module];
        for(int i = 0 ; i < numbers ; i++)
            values[in.nextInt()%module]++;
        
        int result = (values[0] - 1) * (values[0]) / 2;
        if(module % 2 == 0)
            result += (values[module/2] - 1) * (values[module/2]) / 2;
        for(int i = 1 ; i < (module+1) / 2; i++)
            result += values[i] * values[module-i];
        
        System.out.println(result);
        in.close();
    }
}
