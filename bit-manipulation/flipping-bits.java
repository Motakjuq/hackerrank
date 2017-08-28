// https://www.hackerrank.com/challenges/flipping-bits
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        long mask = 4294967295l;
        for(int i = 0 ; i < cases ; i++){
            System.out.println(in.nextLong()^mask);
        }
        in.close();
    }
}
