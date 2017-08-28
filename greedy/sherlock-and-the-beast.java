// https://www.hackerrank.com/challenges/sherlock-and-the-beast
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static void buildResult(int five, int three){
        if(five == 0 && three == 0)
        	System.out.print("-1");
        for(int i = 0; i < three ; i++){
            System.out.print("555");
        }
        for(int i = 0; i < five ; i++){
        	System.out.print("33333");
        }
        System.out.println();
    }

    private static void calculate(int size){
        int five = size / 5;
        int fiveRemain = size % 5;
        int three = fiveRemain / 3;
        int threeRemain = fiveRemain % 3;
        while(five > 0 && threeRemain != 0){
            five--;
            fiveRemain = (size - five*5);
            three = fiveRemain / 3;
            threeRemain = fiveRemain % 3;
        }
        if(five*5 + three*3 == size){
            while(five - 3 >= 0){
                five -= 3;
                three +=5;
            }
            buildResult(five, three);
        }
        else
        	buildResult(0,0);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0; i < cases; i++){
            calculate(in.nextInt());
        }
    }
}
