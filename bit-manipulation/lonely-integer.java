// https://www.hackerrank.com/challenges/lonely-integer
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int size = in.nextInt();
       int value = in.nextInt();
       for(int i = 1 ; i < size ; i++){
           value ^= in.nextInt();
       }
       System.out.println(value);
       in.close();
   }
}
