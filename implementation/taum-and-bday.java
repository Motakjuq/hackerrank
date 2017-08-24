// https://www.hackerrank.com/challenges/taum-and-bday
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
            long b = in.nextLong();
            long w = in.nextLong();
            
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            
            long costB = b * x;
            long costW = w * y;
            
            if(costB > b * (y + z))
                costB = b * (y + z);
            
            if(costW > w * (x + z))
                costW = w * (x + z);
            
            System.out.println(costB + costW);
        }
    }
}
