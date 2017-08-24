// https://www.hackerrank.com/challenges/kangaroo
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        if(v1 == v2 && x1 != x2)
            System.out.println("NO");
        else {
            int jumps = (x2 - x1) / (v1 - v2);
            if(jumps > 0 && x1 + jumps * v1 == x2 + jumps * v2)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
        in.close();
    }
}
