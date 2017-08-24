// https://www.hackerrank.com/challenges/find-digits
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static int calculateDigits(int value){
        int digits = 0;
        int number = value;
        for( ; number > 0 ; number = number / 10){
            int div = number % 10;
            if(div != 0 && value % div == 0){
                digits++;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0; i < cases; i++){
            System.out.println(calculateDigits(in.nextInt()));
        }
        in.close();
    }
}
