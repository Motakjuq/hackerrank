// https://www.hackerrank.com/challenges/cavity-map
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String grid[] = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        
        for(int i = 1 ; i < n - 1 ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                // up - down - left - righ
                char currentChar = grid[i].charAt(j);
                if(j != 0 && j != n - 1 
                   && grid[i-1].charAt(j) < currentChar && grid[i+1].charAt(j) < currentChar
                   && grid[i].charAt(j-1) < currentChar && grid[i].charAt(j+1) < currentChar){
                    sb.append("X");
                } else {
                    sb.append(currentChar);
                }
            }
            grid[i] = sb.toString();
        }
        
        for(int i = 0 ; i < n ; i++){
            System.out.println(grid[i]);
        }
    }
}
