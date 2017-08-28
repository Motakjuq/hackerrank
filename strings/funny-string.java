// https://www.hackerrank.com/challenges/funny-string
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static String checkFunnyString(String input){
        String reverse = new StringBuilder(input).reverse().toString();
        for(int i = 1 ; i < input.length()-1 ; i++){
            int inputCheck = Math.abs((int)input.charAt(i) - (int)input.charAt(i-1));
            int reverseCheck = Math.abs((int)reverse.charAt(i) - (int)reverse.charAt(i-1));
            if(inputCheck != reverseCheck)
                return "Not Funny";
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i ++){
            System.out.println(checkFunnyString(in.next()));
        }
    }
}
