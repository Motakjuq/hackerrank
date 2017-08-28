// https://www.hackerrank.com/challenges/two-strings
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static String checkSubString(String first, String second){
        boolean chars[] = new boolean[26];
        int charsAmount = 0;
        for(int i = 0; i < first.length() ; i++){
            int index = ((int)first.charAt(i))-97;
            if(!chars[index])
                charsAmount++;
            if(charsAmount==26)
                return "YES";
            chars[index] = true;
        }
        for(int i = 0 ; i < second.length() ; i++){
            if(chars[((int)second.charAt(i))-97]){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            System.out.println(checkSubString(in.next(),in.next()));
        }
    }
}
