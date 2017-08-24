// https://www.hackerrank.com/challenges/save-the-prisoner
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
            int prisoners = in.nextInt();
            int sweets = in.nextInt();
            int start = in.nextInt();
            
            int position = ((sweets % prisoners) + start - 1) % prisoners;
            System.out.println(position==0?prisoners:position);
        }
        
        in.close();
    }
}
