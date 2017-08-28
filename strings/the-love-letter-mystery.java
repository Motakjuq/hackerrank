// https://www.hackerrank.com/challenges/the-love-letter-mystery
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
            int changes = 0;
            for(int j = 0 ; j < word.length()/2 ; j++) {
                if(word.charAt(j) > word.charAt(word.length()-1-j)){
                    changes += ((int)word.charAt(j)) - ((int)word.charAt(word.length()-1-j));
                } else if(word.charAt(j) < word.charAt(word.length()-1-j)){
                    changes += ((int)word.charAt(word.length()-1-j)) - ((int)word.charAt(j));
                }
            }
            System.out.println(changes);
        }
    }
}
