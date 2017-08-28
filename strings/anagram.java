// https://www.hackerrank.com/challenges/anagram
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
            String word = in.next();
            if(word.length()%2 == 1){
                System.out.println("-1");
                continue;
            }
            int charLeft[] = new int[26];
            int charRight[] = new int[26];
            for(int j = 0 ; j < word.length()/2 ; j++){
                charLeft[(int)word.charAt(j)-97]++;
                charRight[(int)word.charAt(word.length() - j - 1)-97]++;
            }
            int diff = 0;
            for(int j = 0 ; j < 26 ; j++){
                diff += Math.abs(charLeft[j] - charRight[j]);
            }
            System.out.println(diff/2);
        }
    }
}
