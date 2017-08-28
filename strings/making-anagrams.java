// https://www.hackerrank.com/challenges/making-anagrams
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        int chars[] = new int[26];
        for(int i = 0 ; i < first.length() ; i++){
            chars[(int)first.charAt(i)-97]++;
        }
        
        int changes = 0;
        for(int i = 0 ; i < second.length() ; i++){
            int charPos = (int)second.charAt(i) - 97;
            if(chars[charPos] > 0){
                chars[charPos]--;
            } else {
                changes++;
            }
        }
        
        for(int i = 0 ; i < 26 ; i++){
            changes += chars[i];
        }
        
        System.out.println(changes);
    }
}
