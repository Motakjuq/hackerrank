// https://www.hackerrank.com/challenges/game-of-thrones
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        int sum[] = new int[27];
        for(int i = 0; i < inputString.length() ; i++){
            char c = inputString.charAt(i);
            int arrayPosition = (int)c;
            sum[arrayPosition-97]++;
        }
        boolean isOdd = true;
        for(int i = 0 ; i < 27 ; i++){
            if(sum[i] % 2 != 0){
                if(isOdd){
                    isOdd = false;
                }else{
                    System.out.print("NO");
                    myScan.close();
                    return;
                }
            }
                
        }
        System.out.println("YES");
        myScan.close();
    }
}
