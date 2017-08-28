// https://www.hackerrank.com/challenges/sherlock-and-array
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
            long data[] = new long[size];
            long leftSum = 0L;
            for(int j = 0 ; j < size ; j++){
                data[j] = in.nextLong();
                if(j > 0 && j < size - 1){
                    leftSum += data[j-1];
                }
            }
            if(size == 1){
                System.out.println("YES");
                continue;
            }
            long rightSum = data[size-1];
            String result = "NO";
            for(int j = size - 2 ; j > 0 ; j--){
                if(rightSum == leftSum){
                    result = "YES";
                    break;
                }else{
                    rightSum += data[j];
                    leftSum -= data[j-1];
                }
            }
            System.out.println(result);
        }
    }
}
