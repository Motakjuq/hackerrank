// https://www.hackerrank.com/challenges/library-fine
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        Calendar actual = Calendar.getInstance();
        actual.clear();
        Calendar expected = Calendar.getInstance();
        expected.clear();
        actual.set(y1, m1, d1);
        expected.set(y2, m2, d2);
        
        if(actual.compareTo(expected) < 0){
            System.out.println(0);
        } else {
            if(y2 == y1) {
                if(m2 == m1){
                    System.out.println(15*(d1-d2));
                } else {
                    System.out.println(500*(m1-m2));
                }
            } else {
                System.out.println(10000);
            }
        }
        in.close();
    }
}
