// https://www.hackerrank.com/challenges/count-luck
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static int waves(int currentWaves, int x, int y, int endX, int endY, int rows, int columns, 
                             boolean path[][]){
        if(x == endX && y == endY)
            return currentWaves;
        
        int paths = 0;
        int result = -1;
        
        path[x][y] = false;
        if(x - 1 >= 0 && path[x-1][y]) {
            paths++;
        }
        if(x + 1 < rows && path[x+1][y]) {
            paths++;
        }
        if(y - 1 >= 0 && path[x][y-1]) {
            paths++;
        }
        if(y + 1 < columns && path[x][y+1]) {
            paths++;
        }
        
        int increseWaves = 0;
        if(paths > 1)
            increseWaves++;
                
        if(x - 1 >= 0 && path[x-1][y] && result == -1) {
            result = waves(currentWaves + increseWaves, x - 1, y, endX, endY, rows, columns, path);
        }
        if(x + 1 < rows && path[x+1][y] && result == -1) {
            result = waves(currentWaves + increseWaves, x + 1, y, endX, endY, rows, columns, path);
        }
        if(y - 1 >= 0 && path[x][y-1] && result == -1) {
            result = waves(currentWaves + increseWaves, x, y - 1, endX, endY, rows, columns, path);
        }
        if(y + 1 < columns && path[x][y+1] && result == -1) {
            result = waves(currentWaves + increseWaves, x, y + 1, endX, endY, rows, columns, path);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int j = 0 ; j < cases ; j++){
            int rows = in.nextInt();
            int columns = in.nextInt();
            String maze[] = new String[rows];
            boolean path[][] = new boolean[rows][columns];
            int beginX = 0;
            int beginY = 0;
            int endX = 0;
            int endY = 0;
            for(int i = 0 ; i < rows ; i ++){
                maze[i] = in.next();
                for(int k = 0 ; k < columns ; k++){
                    if('X' != maze[i].charAt(k))
                        path[i][k] = true;
                }
                if(maze[i].indexOf("M") != -1){
                    beginX = i;
                    beginY = maze[i].indexOf("M");
                }
                if(maze[i].indexOf("*") != -1){
                    endX = i;
                    endY = maze[i].indexOf("*");
                }
            }
            int guess = in.nextInt();
            System.out.println(waves(0, beginX, beginY, endX, endY, rows, columns, path)==guess?"Impressed":"Oops!");
        }
        in.close();
    }
}
