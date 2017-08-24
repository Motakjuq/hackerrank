// https://www.hackerrank.com/challenges/angry-professor
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
            int students = in.nextInt();
            int threshold = in.nextInt();
            int currentStudents = 0;
            for(int j = 0 ; j < students ; j++){
                if(in.nextInt() <= 0)
                    currentStudents++;
            }
            if(currentStudents >= threshold){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
        in.close();
    }
}
