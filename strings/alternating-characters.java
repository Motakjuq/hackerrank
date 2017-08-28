// https://www.hackerrank.com/challenges/alternating-characters
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int calculateDeletion(String input){
        char pivot = input.charAt(0);
        int result = 0;
        for(int i = 1 ; i < input.length() ; i++){
            char inputChar = input.charAt(i);
            if(pivot != inputChar){
                pivot = inputChar;
            } else {
                result++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            System.out.println(calculateDeletion(in.next()));
        }
        
        in.close();
    }
}
