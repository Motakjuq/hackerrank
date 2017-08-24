// https://www.hackerrank.com/challenges/extra-long-factorials
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        BigInteger result = BigInteger.valueOf(1L);
        for(long i = 1 ; i <= number ; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
