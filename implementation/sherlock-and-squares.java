// https://www.hackerrank.com/challenges/sherlock-and-squares
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0; i < cases ; i++){
            double lower = in.nextDouble();
            double upper = in.nextDouble();
            
            int lowerCeil = (int)Math.ceil(Math.sqrt(lower));
            int upperFloor = (int)Math.floor(Math.sqrt(upper));
            int result = 0;
            for(; lowerCeil <= upperFloor ; lowerCeil++ ){
                result ++;
            }
            System.out.println(result);
        }
    }
}
