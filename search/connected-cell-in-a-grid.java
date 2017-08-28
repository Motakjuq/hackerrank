// https://www.hackerrank.com/challenges/connected-cell-in-a-grid
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int calculateRegion(int i, int j, int rows, int columns, boolean matrix[][]){
        if(i < 0 || j < 0 || i == rows || j == columns || !matrix[i][j])
            return 0;
        matrix[i][j] = false;
        int result = 1;
        
        result += calculateRegion(i-1, j-1, rows, columns, matrix);
        result += calculateRegion(i-1, j, rows, columns, matrix);
        result += calculateRegion(i-1, j+1, rows, columns, matrix);
        result += calculateRegion(i, j-1, rows, columns, matrix);
        result += calculateRegion(i, j+1, rows, columns, matrix);
        result += calculateRegion(i+1, j-1, rows, columns, matrix);
        result += calculateRegion(i+1, j, rows, columns, matrix);
        result += calculateRegion(i+1, j+1, rows, columns, matrix);
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();
        boolean matrix[][] = new boolean[rows][columns];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                matrix[i][j] = in.nextInt()==1?true:false;
            }
        }
        int result = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                if(matrix[i][j])
                    result = Math.max(result, calculateRegion(i, j, rows, columns, matrix));
            }
        }
        System.out.println(result);
    }
}
