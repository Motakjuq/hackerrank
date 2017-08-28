// https://www.hackerrank.com/challenges/pangrams
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        String line = in.next().toLowerCase();
        in.close();
        boolean alphabet[] = new boolean[26];
        int usedLetters = 0;
        for(int i = 0 ; i < line.length() ; i++){
            int charCode = (int)line.charAt(i);
            if(charCode != 32 && !alphabet[charCode-97]){
                alphabet[charCode-97] = true;
                usedLetters++;
            }
            if(usedLetters == 26){
                System.out.println("pangram");
                return;
            }
        }
        System.out.println("not pangram");
    }
}
