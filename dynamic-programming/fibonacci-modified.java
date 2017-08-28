// https://www.hackerrank.com/challenges/fibonacci-modified
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal first = in.nextBigDecimal();
        BigDecimal second = in.nextBigDecimal();
        int nth = in.nextInt();
        BigDecimal terms[] = new BigDecimal[nth];
        terms[0] = first;
        terms[1] = second;
        for(int i = 2 ; i < nth ; i++){
            terms[i] = terms[i-1].pow(2).add(terms[i-2]);
        }
        System.out.println(terms[nth-1].toPlainString());
        
        in.close();
    }
}
