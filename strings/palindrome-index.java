// https://www.hackerrank.com/challenges/palindrome-indexv
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int calculateIndex(String input){
        int inputSize = input.length()-1;
        for(int i = 0; i <= input.length()/2 ; i++){
            char begin = input.charAt(i);
            char end = input.charAt(inputSize-i);
            
            if(begin != end){
                String first = input.substring(i,input.length()/2);
                String last = new StringBuilder(input.substring(input.length()/2+1,inputSize-i+1)).reverse().toString();
                if(last.indexOf(first.substring(1)) == 0){
                    return i;
                }else if(first.indexOf(last.substring(1)) == 0){
                    return inputSize - i;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            System.out.println(calculateIndex(in.next()));
        }
    }
}
