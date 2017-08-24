// https://www.hackerrank.com/challenges/utopian-tree
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int height[] = new int[60];
    private static int lastElement = 0;
    
    private static void calculateHeight(int cicle){
        if(lastElement < cicle){
            for(int i = lastElement+1; i <= cicle ; i++){
                if(i%2 == 0){
                    height[i] = height[i-1] + 1;
                }else{
                    height[i] = height[i-1] * 2;
                }
                lastElement++;
            }
        }
        System.out.println(height[cicle]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        height[0]=1;
        for(int a0 = 0; a0 < t; a0++){
            calculateHeight(in.nextInt());
        }
    }
}
