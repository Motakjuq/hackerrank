// https://www.hackerrank.com/challenges/kaprekar-numbers
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long begin = in.nextLong();
        long last = in.nextLong();
        StringBuilder sb = new StringBuilder();
        for(Long i = begin ; i <= last ; i++){
            Long pow = i*i;
            String powString = pow.toString();
            double digits = powString.length()/2;
            if(powString.length() % 2 == 1)
                digits++;
            
            long right = pow / (long)Math.pow(10,digits);
            long left = pow % (long)Math.pow(10,digits);
            
            if(right + left == i){
                sb.append(" " + i);
            }
        }
        if(sb.toString().length() > 1){
            System.out.println(sb.toString().substring(1));
        } else {
            System.out.println("INVALID RANGE");
        }
        in.close();
    }
}
