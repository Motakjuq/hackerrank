// https://www.hackerrank.com/challenges/maxsubarray
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
            int size = in.nextInt();
            long sumCon = in.nextLong();
            long sumNonCon = sumCon;
            long tmp = sumCon;
            long max = sumCon;
            for(int j = 1 ; j < size ; j++){
                long number = in.nextLong();
                if(sumCon < 0){
                    if(sumCon < number){
                        sumCon = number;
                        sumNonCon = number;
                        max = number;
                    }
                } else {
                    if(number > 0 )
                        sumNonCon += number;
                    if(sumCon + number > sumCon){
                        sumCon += number;
                        if(sumCon > max)
                            max = sumCon;
                    } else {
                        sumCon += number;
                        if(sumCon <= 0){
                            sumCon = 0;
                        }
                    }
                }
            }
            System.out.println(max + " " + sumNonCon);
        }
    }
}
